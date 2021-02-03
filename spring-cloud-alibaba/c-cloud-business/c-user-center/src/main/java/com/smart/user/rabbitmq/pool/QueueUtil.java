package com.smart.user.rabbitmq.pool;

import com.smart.user.rabbitmq.direct.config.ChannelPool;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class QueueUtil {

	public static boolean pushMessage(Queue queue, final String message) {
		return ChannelPool.getInstance().execute(channel -> {
			try {
				channel.basicPublish(queue.getExchange(), queue.getName(), queue.getProps(), message.getBytes(StandardCharsets.UTF_8));
				return true;
			} catch (IOException up) {
				up.printStackTrace();
				return false;
			}
		});
	}

}
