package com.smart.data.flink;

import com.smart.data.thread.ThreadPoolProvider;
import lombok.extern.slf4j.Slf4j;
import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringSchema;
import org.apache.flink.streaming.api.CheckpointingMode;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.CheckpointConfig;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @version V1.0
 * @title: FlinkKafkaConsumer
 * @description:
 *
 * 这里简单说下这个类的作用就是实现这个类的方法：beginTransaction、preCommit、commit、abort，
 * 达到事件（preCommit）预提交的逻辑（当事件进行自己的逻辑处理后进行预提交，
 * 如果预提交成功之后才进行真正的（commit）提交，如果预提交失败则调用abort方法进行事件的回滚操作），
 * 结合flink的checkpoint机制，来保存topic中partition的offset。
 *
 * 达到的效果我举个例子来说明下：
 * 比如checkpoint每10s进行一次，此时用FlinkKafkaConsumer011实时消费kafka中的消息，
 * 消费并处理完消息后，进行一次预提交数据库的操作，
 * 如果预提交没有问题，10s后进行真正的插入数据库操作，
 * 如果插入成功，进行一次checkpoint，flink会自动记录消费的offset，可以将checkpoint保存的数据放到hdfs中，
 * 如果预提交出错，比如在5s的时候出错了，此时Flink程序就会进入不断的重启中，重启的策略可以在配置中设置，
 * 当然下一次的checkpoint也不会做了，checkpoint记录的还是上一次成功消费的offset，本次消费的数据因为在checkpoint期间，消费成功，
 * 但是预提交过程中失败了，注意此时数据并没有真正的执行插入操作，因为预提交（preCommit）失败，提交（commit）过程也不会发生了。
 * 等你将异常数据处理完成之后，再重新启动这个Flink程序，它会自动从上一次成功的checkpoint中继续消费数据，以此来达到Kafka到Mysql的Exactly-Once。
 * @author: lukewei
 * @date: 2021-01-06 9:42
 * @remark: 修改内容
 */
@Slf4j
@Component
public class FlinkKafkaConsumerLocal {


    @PostConstruct
    public void init(){
        start();
    }

    private void start(){
        ThreadPoolProvider.newFixedThreadPool().execute(()->{
            log.info("flink 启动开始...");
            final StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

            env.setParallelism(1);
            // 设置监控数据流时间间隔（官方叫状态与检查点）
            env.enableCheckpointing(10000);
            //设置为事件时间

            // 设置模式为：exactly_one，仅一次语义
            env.getCheckpointConfig().setCheckpointingMode(CheckpointingMode.EXACTLY_ONCE);
            // 确保检查点之间有1S的时间间隔(checkpoint最小间隔)
            env.getCheckpointConfig().setMinPauseBetweenCheckpoints(1000);
            // 检查点必须在10S内完成或者被丢弃(checkpoint超时时间)
            env.getCheckpointConfig().setCheckpointTimeout(10000);
            // 同一时间只允许进行一次检查点
            env.getCheckpointConfig().setMaxConcurrentCheckpoints(1);
            // 表示一旦Flink程序被cancel后，会保留checkpoint数据，以便根据实际需要回复到指定的checkpoint
            env.getCheckpointConfig().enableExternalizedCheckpoints(CheckpointConfig.ExternalizedCheckpointCleanup.RETAIN_ON_CANCELLATION);
            // 设置statebackend,将检查点保存到本地，默认保存在内存中
//            env.setStateBackend(new FsStateBackend("file:///user/local/flink/data"));

            Properties properties = new Properties();
            properties.setProperty("bootstrap.servers","10.2.9.150:9092");
            properties.setProperty("group.id","bill_groupId");

            FlinkKafkaConsumer<String> consumer = new FlinkKafkaConsumer<String>("bill_topic", new SimpleStringSchema(), properties);
            consumer.setStartFromEarliest();
            DataStream<String> stream = env
                    .addSource(consumer);

//            stream.print();
            stream.rebalance().map(new MapFunction<String, Object>() {
                private static final long serialVersionUID = 1L;
                public String map(String value)throws IOException {
                    System.out.println("kafka日志："+value);
//                writeIntoHBase(value);
                    return null;
                }

            });

            try {
                env.execute();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

}
