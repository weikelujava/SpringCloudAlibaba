package com.smart.demo.io.bio;

import com.smart.demo.io.common.ThreadPoolProvider;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    /**
     * BIO 基于线程的驱动模型
     *
     * 1.todo  这里简单demo，不能直接throws IOException，一定要正常关闭通道，不能抛异常
     * 2.todo 修改单线程为线程池
     *
     * 模型效率非常低，很多地方会阻塞
     * 不是效率低就没用，根据相关场景去选择，其特点是简单粗暴，客户端少的话使用可以选择该模型
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {

        ServerSocket ss = new ServerSocket();
        ss.bind(new InetSocketAddress("127.0.0.1",8888));

        while (true){

            // 阻塞方法
            Socket s = ss.accept();

            ThreadPoolProvider.newFixedThreadPool().execute(()->{
                handle(s);
            });
        }
    }

    static void handle(Socket s){
        byte[] bytes = new byte[1024];
        try {
            // read 会阻塞 没有数据会阻塞，等待CPU唤醒
            int len = s.getInputStream().read(bytes);
            System.out.println(new String(bytes,0,len));
            // write 会阻塞 客户端不接受
            s.getOutputStream().write(len);
            s.getOutputStream().flush();
            // CPU切来切去实际上很浪费资源

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
