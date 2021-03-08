package com.smart.demo.io.nio;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * NIO 基于事件驱动模型
 * New Non-Blocking 或者 Non-blocking
 * 单线程 single thread，这个通道的大小受Linux内核中的FD_SETSIZE参数影响
 *
 * 基于Selector,每隔一段时间做轮询，Selector不仅盯着是否有新的Client连接进来，而且还盯着已经连接上的Client是否有读写操作
 */
public class ReactorServer {


    ExecutorService pool = Executors.newFixedThreadPool(50);

    private Selector selector;

    public static void main(String[] args) throws IOException {

        ReactorServer server = new ReactorServer();
        server.initServer(800);
        server.listen();

    }


    public void initServer(int port) throws IOException {

        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);
        serverChannel.bind(new InetSocketAddress(800));

        this.selector = Selector.open();
        serverChannel.register(selector,SelectionKey.OP_ACCEPT);

        System.out.println("服务端启动成功");


    }

    public void listen() throws IOException{
        while (true){
            selector.select();
            Iterator<SelectionKey> it = this.selector.selectedKeys().iterator();
            if(it.hasNext()){
                SelectionKey key = (SelectionKey) it.next();
                it.remove();

                if(key.isAcceptable()){
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    SocketChannel channel = server.accept();
                    channel.configureBlocking(false);
                    channel.register(this.selector,SelectionKey.OP_ACCEPT);

                }else if(key.isReadable()){
                    key.interestOps(key.interestOps()&(~SelectionKey.OP_ACCEPT));
                    pool.execute(new ThreadHandlerChannel(key));
                }

            }
        }

    }


   static class ThreadHandlerChannel extends Thread{

        private SelectionKey key;

        ThreadHandlerChannel(SelectionKey key){
            this.key = key;
        }

        @Override
        public void run() {

            SocketChannel channel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            try {
                int size = 0;
                while ((size = channel.read(buffer)) > 0){
                    buffer.flip();
                    baos.write(buffer.array(),0,size);
                    buffer.clear();
                }
                baos.close();

                byte[] bytes = baos.toByteArray();
                ByteBuffer writeBuffer = ByteBuffer.allocate(bytes.length);
                writeBuffer.put(bytes);
                writeBuffer.flip();
                channel.write(writeBuffer);
                if(size == -1){
                    channel.close();
                }else {
                    key.interestOps(key.interestOps() | SelectionKey.OP_ACCEPT);
                    key.selector().wakeup();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }



}
