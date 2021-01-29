//package com.smart.user.lock;
//
//import lombok.extern.slf4j.Slf4j;
//import org.apache.curator.framework.CuratorFramework;
//import org.apache.curator.framework.recipes.cache.PathChildrenCache;
//import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
//import org.apache.zookeeper.CreateMode;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.CountDownLatch;
//
///**
// *
// * @version V1.0
// * @title: ZkDistributedLock
// * @description:
// * @author: lukewei
// * @date: 2021-01-25 14:07
// * @remark: 修改内容
// */
//@Slf4j
//@Component
//public class ZkDistributedLock implements InitializingBean {
//
//    /**
//     * 分布式锁，用于挂起当前县城，等待上一把分布式锁的释放
//     */
//    private CountDownLatch countDownLatch = new CountDownLatch(1);
//
//    /**
//     * 根节点锁
//     */
//    private final static String ROOT_PATH_LOCK = "root";
//
//    @Autowired
//    private CuratorFramework curatorFramework;
//
//    @Autowired
//    private ZkClient zkClient;
//
//
//    @Override
//    public void afterPropertiesSet() {
//        String path = "/" + ROOT_PATH_LOCK;
//        try {
//            if (!zkClient.checkNode(path)) {
//                zkClient.createNode(path, null);
//            }
//            addWatcher(ROOT_PATH_LOCK);
//            log.info("root path 的 watcher 事件创建成功");
//        } catch (Exception ex) {
//            log.error("ZooKeeper连接发生错误，错误信息 {}", ex.toString(), ex);
//        }
//    }
//
//
//    /**
//     * 增加监听
//     *
//     * @param path
//     */
//    private void addWatcher(String path) {
//        String keyPath;
//        if (path.equals(ROOT_PATH_LOCK)) {
//            keyPath = "/" + path;
//        } else {
//            keyPath = "/" + ROOT_PATH_LOCK + "/" + path;
//        }
//        final PathChildrenCache cache = new PathChildrenCache(curatorFramework, keyPath, false);
//        try {
//            cache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        cache.getListenable().addListener((client, event) -> {
//            if (event.getType().equals(PathChildrenCacheEvent.Type.CHILD_REMOVED)) {
//                String oldPath = event.getData().getPath();
//                log.info("上一个节点 " + oldPath + " 已经被断开");
//                if (oldPath.contains(path)) {
//                    // 释放计数器，让当前的请求获取锁
//                    countDownLatch.countDown();
//                }
//            }
//        });
//    }
//
//    /**
//     * 获取分布式锁
//     */
//    public void acquireDistributedLock(String path) {
//        String keyPath = "/" + ROOT_PATH_LOCK + "/" + path;
//        while (true) {
//            try {
//                zkClient.createNodeWithMode(keyPath, CreateMode.EPHEMERAL);
//                log.info("success to acquire lock for path:{}", keyPath);
//                break;
//            } catch (Exception e) {
//                log.info("failed to acquire lock for path:{}", keyPath);
//                log.info("while try again .......");
//                try {
//                    if (countDownLatch.getCount() <= 0) {
//                        countDownLatch = new CountDownLatch(1);
//                    }
//                    countDownLatch.await();
//                } catch (InterruptedException e1) {
//                    e1.printStackTrace();
//                }
//            }
//        }
//    }
//
//    /**
//     * 获取分布式锁
//     */
//    public Boolean acquireDistributedLockFlag(String path) {
//        String keyPath = "/" + ROOT_PATH_LOCK + "/" + path;
//        while (true) {
//            try {
//                zkClient.createNodeWithMode(keyPath, CreateMode.EPHEMERAL);
//                log.info("success to acquire lock for path:{}", keyPath);
//                return true;
//            } catch (Exception e) {
//                log.info("failed to acquire lock for path:{}", keyPath);
//                log.info("while try again .......");
//                return false;
//            }
//        }
//    }
//
//    /**
//     * 释放分布式锁
//     */
//    public boolean releaseDistributedLock(String path) {
//        try {
//            String keyPath = "/" + ROOT_PATH_LOCK + "/" + path;
//            if (zkClient.checkNode(keyPath)) {
//                zkClient.deleteNode(keyPath);
//            }
//        } catch (Exception e) {
//            log.error("failed to release lock");
//            return false;
//        }
//        return true;
//    }
//}
