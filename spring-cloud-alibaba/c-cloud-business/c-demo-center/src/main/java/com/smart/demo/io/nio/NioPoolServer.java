package com.smart.demo.io.nio;

import com.smart.common.thread.ThreadPoolProvider;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;

/**
 * @version V1.0
 * @title: NioPoolServer
 * @description:
 * @author: lukewei
 * @date: 2021-03-09 10:36
 * @remark: 修改内容
 */
public class NioPoolServer {


    /**
     * 线程池
     */
    ExecutorService pool = ThreadPoolProvider.newFixedThreadPool();

    /**
     * 选择器
     */
    private Selector selector;

    /**
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        NioPoolServer server = new NioPoolServer();
        server.initServer(8000);
        server.listen();
    }

    /**
     * @param port
     * @throws IOException
     */
    public void initServer(int port) throws IOException {
        //
        ServerSocketChannel serverChannel = ServerSocketChannel.open();
        //
        serverChannel.configureBlocking(false);
        //
        serverChannel.socket().bind(new InetSocketAddress(port));
        //
        this.selector = Selector.open();

        serverChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务端启动成功！");
    }

    /**
     * @throws IOException
     */
    @SuppressWarnings("unchecked")
    public void listen() throws IOException {
        // 轮询访问selector
        while (true) {
            //
            selector.select();
            //
            Iterator ite = this.selector.selectedKeys().iterator();
            while (ite.hasNext()) {
                SelectionKey key = (SelectionKey) ite.next();
                //
                ite.remove();
                //
                if (key.isAcceptable()) {
                    ServerSocketChannel server = (ServerSocketChannel) key.channel();
                    //
                    SocketChannel channel = server.accept();
                    //
                    channel.configureBlocking(false);
                    //
                    channel.register(this.selector, SelectionKey.OP_READ);
                    //
                } else if (key.isReadable()) {
                    //
                    key.interestOps(key.interestOps() & (~SelectionKey.OP_READ));
                    //
                    pool.execute(new ThreadHandlerChannel(key));
                }
            }
        }
    }
}

/**
 * @param
 * @throws IOException
 */
class ThreadHandlerChannel extends Thread {
    private SelectionKey key;

    ThreadHandlerChannel(SelectionKey key) {
        this.key = key;
    }

    @Override
    public void run() {
        //
        SocketChannel channel = (SocketChannel) key.channel();
        //
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            int size = 0;
            while ((size = channel.read(buffer)) > 0) {
                buffer.flip();
                baos.write(buffer.array(), 0, size);
                buffer.clear();
            }
            baos.close();
            //
            byte[] content = baos.toByteArray();
            ByteBuffer writeBuf = ByteBuffer.allocate(content.length);
            writeBuf.put(content);
            writeBuf.flip();
            channel.write(writeBuf);//
            if (size == -1) {

                channel.close();
            } else {
                //
                key.interestOps(key.interestOps() | SelectionKey.OP_READ);
                key.selector().wakeup();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
