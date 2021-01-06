package com.smart.data.mode;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: KafkaMsg
 * @description:
 * @author: lukewei
 * @date: 2021-01-06 11:18
 * @remark: 修改内容
 */
public class KafkaMsg {

    private String topic;

    private int partition;

    private long offset;

    private String msg;

    private String key;

    @Override
    public String toString() {
        return "KafkaMsg{" +
                "topic='" + topic + '\'' +
                ", partition=" + partition +
                ", offset=" + offset +
                ", msg='" + msg + '\'' +
                ", key='" + key + '\'' +
                '}';
    }

    public KafkaMsg() {
    }

    public KafkaMsg(String topic, int partition, long offset, String msg, String key) {
        this.topic = topic;
        this.partition = partition;
        this.offset = offset;
        this.msg = msg;
        this.key = key;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getPartition() {
        return partition;
    }

    public void setPartition(int partition) {
        this.partition = partition;
    }

    public long getOffset() {
        return offset;
    }

    public void setOffset(long offset) {
        this.offset = offset;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
