package com.smart.demo.io.bio;

import com.smart.common.thread.ThreadPoolProvider;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @version V1.0
 * @title: BioServer
 * @description:
 * @author: lukewei
 * @date: 2021-03-09 9:53
 * @remark:
 *
 * 注意：
 * 1.所有的异常能解决的一定要解决
 * 2.多个客服端连接对业务处理一定要使用合适大小的线程池，防止拖垮CPU
 * 3.此次的阻塞的地方会有3个，一个是serverSocket.accept(),一个是Read(),一个是write()
 */
@Slf4j
public class BioServer {

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket();
            serverSocket.bind(new InetSocketAddress("127.0.0.1", 8888));

            while (true) {
                // 阻塞操作
                Socket socket = serverSocket.accept();
                ThreadPoolProvider.newFixedThreadPool().execute(() -> {
                    handle(socket);
                });
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    static void handle(Socket socket){
        try {
            byte[] bytes = new byte[1024];
            // read也是阻塞操作
            int len = socket.getInputStream().read(bytes);
            if(len == -1){
                log.error("无数据");
                return;
            }
            log.info(new String(bytes, 0, len));
            // write也是阻塞操作
            socket.getOutputStream().write(bytes, 0, len);
            socket.getOutputStream().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
