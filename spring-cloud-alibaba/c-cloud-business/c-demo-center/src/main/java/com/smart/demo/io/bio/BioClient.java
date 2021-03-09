package com.smart.demo.io.bio;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.Socket;

/**
 *
 * @version V1.0
 * @title: BioClient
 * @description:
 * @author: lukewei
 * @date: 2021-03-09 10:12
 * @remark: 修改内容
 */
@Slf4j
public class BioClient {

    public static void main(String[] args) {
        try {
            Socket s = new Socket("127.0.0.1", 8888);
            s.getOutputStream().write("HelloServer".getBytes());
            s.getOutputStream().flush();
            //s.getOutputStream().close();
            System.out.println("write over, waiting for msg back...");
            byte[] bytes = new byte[1024];
            int len = s.getInputStream().read(bytes);
            System.out.println(new String(bytes, 0, len));
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
