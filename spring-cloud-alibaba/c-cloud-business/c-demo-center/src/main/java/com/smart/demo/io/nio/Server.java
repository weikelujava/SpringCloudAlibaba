package com.smart.demo.io.nio;



import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * NIO 基于事件驱动模型
 * New Non-Blocking 或者 Non-blocking
 * 单线程 single thread，这个通道的大小受Linux内核中的FD_SETSIZE参数影响
 *
 * 基于Selector,每隔一段时间做轮询，Selector不仅盯着是否有新的Client连接进来，而且还盯着已经连接上的Client是否有读写操作
 */
public class Server {

    public static void main(String[] args) throws IOException {

        // 双向通道模型，可以读可以写
        SocketChannel ssc = SocketChannel.open();
        ssc.socket().bind(new InetSocketAddress("127.0.0.1",8888));
        ssc.configureBlocking(false);

        System.out.println("server started,listening on :"+ssc.getLocalAddress());
        Selector selector = Selector.open();
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        while (true){
            // 阻塞方法，有客户端连接发生了
            selector.select();
            Set<SelectionKey> keys = selector.selectedKeys();
            Iterator<SelectionKey> it = keys.iterator();
            while (it.hasNext()){
                SelectionKey key = it.next();
                // 拿到key后必须remove，要不下次轮询的时候会重复处理
                it.remove();
                handle(key);
            }
        }
    }




    private static void handle(SelectionKey key){
        if(key.isAcceptable()){
            SocketChannel sc = null;
            try {
                ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
                sc = ssc.accept();
                sc.configureBlocking(false);

                sc.register(key.selector(),SelectionKey.OP_ACCEPT);




            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(sc != null){
                    try {
                        sc.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }else if(key.isReadable()){

            SocketChannel sc = null;

            try {
                sc = (SocketChannel) key.channel();
                ByteBuffer buffer = ByteBuffer.allocate(512);
                buffer.clear();
                int len = sc.read(buffer);

                if(len != -1){
                    System.out.println(new String(buffer.array(),0,len));
                }

                ByteBuffer bufferToWrite = ByteBuffer.wrap("hello word".getBytes());
                sc.write(bufferToWrite);

            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if(sc != null){
                    try {
                        sc.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }

    }
}
