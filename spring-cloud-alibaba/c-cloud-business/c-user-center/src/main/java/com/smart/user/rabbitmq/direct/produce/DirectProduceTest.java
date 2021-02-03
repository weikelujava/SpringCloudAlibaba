package com.smart.user.rabbitmq.direct.produce;

import com.smart.user.rabbitmq.direct.config.ChannelPool;
import com.smart.user.rabbitmq.pool.ChannelFactory;
import com.smart.user.rabbitmq.pool.Queue;
import com.smart.user.rabbitmq.pool.QueueUtil;

import java.text.MessageFormat;
import java.time.Duration;
import java.time.Instant;

/**
 *
 * @version V1.0
 * @title: DirectProduceTest
 * @description:
 * @author: lukewei
 * @date: 2021-02-03 17:35
 * @remark: 修改内容
 */
public class DirectProduceTest {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(
                    () -> {
                        try {
                            Instant start = Instant.now();

                            for (int j = 0; j < 10; j++) {
                                boolean b = QueueUtil.pushMessage(Queue.HELLO,
                                        MessageFormat.format("[{0}] - Message: {1}", Thread.currentThread().getName(), j));
                            }
                            ChannelPool instance = ChannelPool.getInstance();
                            Duration duration = Duration.between(start, Instant.now());
                            System.out.println(MessageFormat.format("Thread time: {0}ms", duration.toMillis()));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
            ).start();
        }
    }
}
