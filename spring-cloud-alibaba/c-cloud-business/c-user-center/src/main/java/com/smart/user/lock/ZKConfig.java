package com.smart.user.lock;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @version V1.0
 * @title: ZKConfig
 * @description:
 * @author: lukewei
 * @date: 2021-01-25 14:15
 * @remark: 修改内容
 */
@ConfigurationProperties(prefix = "curator.zk")
public class ZKConfig {

    /**
     * 定义失败重试的间隔时间  单位：毫秒
     */
    @Value("${curator.zk.base-sleep-time}")
    private Integer baseSleepTime;

    /**
     * 定义失败后重试的次数
     */
    @Value("${curator.zk.max-retries}")
    private Integer maxRetries;

    /**
     * 定义会话存货时间 单位：毫秒
     */
    @Value("${curator.zk.session-time-out}")
    private Integer sessionTimeout;

    /**
     * zookeeper url:port,多个以逗号分隔
     */
    @Value("${curator.zk.zookeeper-uri}")
    private String zookeeperUri;

    /**
     * 工作空间,可以不指定,建议指定,功能类似于项目包,之后创建的所有的节点都会在该工作空间下,方便管理
     */
    @Value("${curator.zk.namespace}")
    private String namespace;

    /**
     * 锁
     */
    @Value("${curator.zk.lock-path}")
    private String lockPath;

    /**
     * 连接超时时间
     */
    @Value("${curator.zk.connection-time-out}")
    private Integer connectionTimeout;

    /**
     * 定义产品中心锁的路径
     */
    @Value("${curator.zk.product-lock-path}")
    private String productLockPath;
    /**
     * 连接用户名
     */
//    @Value("${curator.zk.username}")
//    private String username;
//    /**
//     * 连接密码
//     */
//    @Value("${curator.zk.password}")
//    private String password;
//
//    public String buildDigestString() {
//        return String.format("%s:%s", getUsername(), getPassword());
//    }
//
//    public ACLProvider getACLProvider() {
//        return new ACLProvider() {
//            private List<ACL> acl = Lists.newArrayList();
//            @Override
//            public List<ACL> getDefaultAcl() {
//                try {
//                    acl.add(new ACL(Perms.ALL, new Id("digest", DigestAuthenticationProvider.generateDigest
//                        (buildDigestString()))));
//                } catch (NoSuchAlgorithmException e) {
//                    e.printStackTrace();
//                }
//                return acl;
//            }
//
//            @Override
//            public List<ACL> getAclForPath(String s) {
//                try {
//                    acl.add(new ACL(Perms.ALL, new Id("digest", DigestAuthenticationProvider.generateDigest
//                        (buildDigestString()))));
//                } catch (NoSuchAlgorithmException e) {
//                    e.printStackTrace();
//                }
//                return acl;
//            }
//        };
//    }


    public Integer getBaseSleepTime() {
        return baseSleepTime;
    }

    public void setBaseSleepTime(Integer baseSleepTime) {
        this.baseSleepTime = baseSleepTime;
    }

    public Integer getMaxRetries() {
        return maxRetries;
    }

    public void setMaxRetries(Integer maxRetries) {
        this.maxRetries = maxRetries;
    }

    public Integer getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(Integer sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

    public String getZookeeperUri() {
        return zookeeperUri;
    }

    public void setZookeeperUri(String zookeeperUri) {
        this.zookeeperUri = zookeeperUri;
    }

    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    public String getLockPath() {
        return lockPath;
    }

    public void setLockPath(String lockPath) {
        this.lockPath = lockPath;
    }

    public Integer getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(Integer connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public String getProductLockPath() {
        return productLockPath;
    }

    public void setProductLockPath(String productLockPath) {
        this.productLockPath = productLockPath;
    }
}
