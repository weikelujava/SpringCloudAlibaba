package com.smart.user.lock;

import org.apache.zookeeper.CreateMode;

/**
 *
 * @version V1.0
 * @title: ZkClinet
 * @description:
 * @author: lukewei
 * @date: 2021-01-25 13:53
 * @remark: 修改内容
 */
public interface ZkClient {


    /**
     * 创建节点
     *
     * @param path
     * @param value
     * @return
     */
    String createNode(String path, String value);

    /**
     * 如果节点不存在就创建节点
     *
     * @param path
     * @param createMode
     * @throws Exception
     */
    void createNodeWithMode(String path, CreateMode createMode) throws Exception;


    /**
     * 判断节点是否存在
     *
     * @param path
     * @return
     */
    Boolean checkNode(String path);

    /**
     * 删除节点
     *
     * @param path
     * @return
     */
    Boolean deleteNode(String path);

}
