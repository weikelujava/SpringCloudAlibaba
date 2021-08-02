package com.smart.demo.test;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.symmetric.SymmetricAlgorithm;
import cn.hutool.crypto.symmetric.SymmetricCrypto;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * Created by kgp on 2017/4/5.
 */
public class CMIUtil {

    private static final Logger logger = LoggerFactory.getLogger("CMIUtil");

    public static void main(String[] args) {

//        String secretVal = "12345678";  // dev,并行，test环境
        String secretVal = "02D609E09BCA06BE"; // stage
//        String body = "{\"sec\":\"dGVzdDE7MTYyNjc5NDczOTc5MDI5MDswMQ==\",\"body\":\"HSmGXqy3nnnQOVrLAPmfVV0e7JODAvhWHAFDAxejrFezNrLyGGFDLL6MzkOimKFE\"}";
//        String body = "{\"code\":0,\"msg\":\"success\",\"sysTime\":\"2021-07-20 16:23:28\",\"body\":\"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\",\"sec\":\"dGVzdDE7MTYyNjc2OTQwODY3MjU1NjswMQ==\"}\n";
        String body = "{\"sec\":\"c3RhZ2VfamVnb19oNTsxNjI3ODkwOTM3NzE0MjY0OzAx\",\"body\":\"s01Jx+gynIO/n8KMeIYoM3VjFG6vxkbcP1KXwGcjgXd1NaNk6DN2hIUN09vm+UncEZ+EVVmaQ5bdEyb/6AauxRHerDTtyw4B4o5HMn5vpalqhKiWhkuwnQn3BAzj3nbXDMY9JBu0ebza6BDD9S3JwKwpU1pjPiUpfMn0vwZHAIc=\"}";
        // 获得请求体
        RequestBody requestBody = JSON.parseObject(body, RequestBody.class);

        String originalSec = new String(Base64.getDecoder().decode(requestBody.getSec().getBytes(StandardCharsets.UTF_8)));

        // secArray
        String[] secArray = splitSec(originalSec);

        // 获得盐
        String salt = secArray[1];

        // 获得真实密钥
        String realSecret = SecureUtil.md5(secretVal.concat(salt)).toLowerCase().substring(8, 24);

        SymmetricCrypto aes = new SymmetricCrypto(SymmetricAlgorithm.AES, realSecret.getBytes(StandardCharsets.UTF_8));
        String originalBody = aes.decryptStr(requestBody.getBody());


        logger.info("");
        logger.info("");
        logger.info("originalBody:{}", originalBody);
        logger.info("");
        logger.info("");

    }

    private static final String SEPARATOR = ";";

    /**
     * 约定格式: 固定密钥key;加密盐值;加密方式
     *
     * @param sec sec
     * @return sec[]
     */
    private static String[] splitSec(String sec) {
        String[] secArray = StringUtils.split(sec, SEPARATOR);
        if (StringUtils.isBlank(secArray[0])) {
            throw new RuntimeException("固定密钥key不能为空 => " + secArray[0]);
        }
        if (secArray[1].length() != 16) {
            throw new RuntimeException("盐值需要为16位 => " + secArray[1]);
        }
        if (!"01".equals(secArray[2])) {
            throw new RuntimeException("不支持的加密方式 => " + secArray[2]);
        }
        return secArray;
    }

    @Data
    private static class RequestBody {

        private String sec;
        private String body;

    }

}
