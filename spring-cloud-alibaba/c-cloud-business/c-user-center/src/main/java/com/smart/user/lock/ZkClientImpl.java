package com.smart.user.lock;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @version V1.0
 * @title: ZkClientImpl
 * @description:
 * @author: lukewei
 * @date: 2021-01-25 13:58
 * @remark: 修改内容
 */
@Slf4j
public class ZkClientImpl implements ZkClient{

    @Autowired
    private CuratorFramework client;

    @Override
    public String createNode(String path, String value) {
        String result = null;
        try {
            if (!checkNode(path)) {
                if (null == value) {

                    this.client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).forPath(path, new byte[0]);
                } else {
                    result = this.client.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT)
                            .forPath(path, value.getBytes());
                }
            } else {
                log.info("[CreateNode] node is already exists。path:{}", path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("[CreateNode] path:{},value:{},result:{}", path, value, result);
        return result;
    }

    @Override
    public void createNodeWithMode(String path, CreateMode createMode) throws Exception {
        try {
            this.client.create().creatingParentsIfNeeded().withMode(createMode).forPath(path, new byte[0]);
        } catch (Exception e) {
            log.info("[zookeeper]创建节点 {} 发生错误, 异常信息: {}",path, e.getMessage());
            throw e;
        }
    }

    @Override
    public Boolean checkNode(String path) {
        boolean exist = false;
        try {
            Stat stat = this.client.checkExists().forPath(path);
            if (stat != null) {
                exist = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("[CheckNode] Path:{} is exist?{}", path, exist);
        return exist;
    }

    @Override
    public Boolean deleteNode(String path) {
        boolean isSuccess = false;
        try {
            this.client.delete().guaranteed().deletingChildrenIfNeeded().withVersion(-1).forPath(path);
            isSuccess = true;
            log.info("[DeleteNode] path:{},{}", path, true);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSuccess;
    }
}
