package com.smart.demo.io.aio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousChannelGroup;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @version V1.0
 * @title: AioThreadGroupServer
 * @description:
 * @author: lukewei
 * @date: 2021-03-09 10:49
 * @remark: 修改内容
 * <p>
 * todo 1.需要手动创建线程池  2.完善异常处理 3.将while(true)可以使用CountDownLatch代替
 */
public class AioThreadGroupServer {


    /**
     * todo 不要抛出异常，应该尽可能的处理异常
     */

    public static void main(String[] args) throws Exception {

        // todo 手动创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        // 异步管道组
        AsynchronousChannelGroup threadGroup = AsynchronousChannelGroup.withCachedThreadPool(executorService, 1);

        final AsynchronousServerSocketChannel serverChannel = AsynchronousServerSocketChannel.open(threadGroup)
                .bind(new InetSocketAddress(8888));

        // 如果有Client连接进来，就进行钩子函数回调，其方法为 new CompletionHandler<>方法，这种方式的实现叫观察者模式
        serverChannel.accept(null, new CompletionHandler<AsynchronousSocketChannel, Object>() {
            @Override
            public void completed(AsynchronousSocketChannel client, Object attachment) {
                serverChannel.accept(null, this);
                try {
                    System.out.println(client.getRemoteAddress());
                    ByteBuffer buffer = ByteBuffer.allocate(1024);

                    // 如果有Client读请求进来，就进行钩子函数回调，其方法为 new CompletionHandler<>方法，这种方式的实现叫观察者模式
                    client.read(buffer, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            attachment.flip();
                            System.out.println(new String(attachment.array(), 0, result));
                            client.write(ByteBuffer.wrap("HelloClient".getBytes()));
                        }

                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            exc.printStackTrace();
                        }
                    });

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void failed(Throwable exc, Object attachment) {
                exc.printStackTrace();
            }
        });

        // todo 可以使用并发编程中的CountDownLatch来实现
        while (true) {
            Thread.sleep(1000);
        }

    }
}
