package com.smart.user.lock;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

/**
 *
 * @version V1.0
 * @title: ZKServer
 * @description:
 * @author: lukewei
 * @date: 2021-01-25 14:14
 * @remark: 修改内容
 */
@Configuration
@EnableConfigurationProperties(ZKConfig.class)
public class ZKServer {

    @Autowired
    private ZKConfig config;

    private final RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 10);

    /**
     * 默认创建的根节点是没有做权限控制的, 需要自己手动加权限
     * ACLProvider aclProvider = new ACLProvider() {
     *     private List<ACL> acl;
     *     @Override
     *     public List<ACL> getDefaultAcl() {
     *         if (acl == null) {
     *             ArrayList<ACL> acl = ZooDefs.Ids.CREATOR_ALL_ACL;
     *             acl.clear();
     *             acl.add(new ACL(ZooDefs.Perms.ALL, new Id("digest", "admin:admin")));
     *             this.acl = acl;
     *         }
     *         return acl;
     *     }
     *     @Override
     *     public List<ACL> getAclForPath(String path) {
     *         return acl;
     *     }
     * };
     * @return CuratorFramework
     */
    @Bean
    public CuratorFramework curatorFramework() {
        CuratorFrameworkFactory.Builder builder = CuratorFrameworkFactory.builder()
                .connectString(config.getZookeeperUri())
                .retryPolicy(retryPolicy)
                .sessionTimeoutMs(config.getSessionTimeout())
                .connectionTimeoutMs(config.getConnectionTimeout());

        if (!StringUtils.isEmpty(config.getNamespace())) {
            builder.namespace(config.getNamespace());
        }
//        if (!StringUtils.isEmpty(config.getUsername()) && !StringUtils.isEmpty(config.getPassword())) {
//            builder.authorization("digest", config.buildDigestString().getBytes());
//            builder.aclProvider(config.getACLProvider());
//        }
        CuratorFramework client = builder.build();
        client.start();
        try {
            client.blockUntilConnected();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return client;
    }
}

