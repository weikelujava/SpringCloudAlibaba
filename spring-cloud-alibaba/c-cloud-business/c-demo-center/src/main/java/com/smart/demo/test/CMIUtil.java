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

        String secretVal = "12345678";
//        String body = "{\"sec\":\"dGVzdDE7MTYyNTgyMDkxNDcwMjE2MjswMQ==\",\"body\":\"hlW+i7534+5V4woKswo/bmeuSRAxrbY9MrG7oJ84EgucZiY6SSfJu6vtf2TITkBa/De2v9fpO/xUEFGYyA3OKL+oZwSdWqzpLR2aIuIqwA1rM7db9Il8kOu4fS52AWmOzAzqXE2rBviBSMTbvjS2b5rAcukVfd3ngB2k5m93jFM9izdUt3t/ba/cZnc4M8ur2roffVDM6NM6E3rEemEn2rXPqkxnm4n3v0c5hwk5Cqfx1SHsMFUbIkFs7YSPLSEY9tdUzBXHMDREEOYni8i+j3MV9Z9DQiay6YwVEW5TikN4dyiSwIQNiwVnNkD5M+lq5XpezBUGSx9d+EWiK/UnvY54KVmXlf6X10vL0IrrYfpSnMaNkxcmDNd6HPxxeT16BnQDtlnhvSLsxIIseOuKz0EdzS4cAYExj69u2iIh9GN+dGrjkbWrWogjeEzRliDypKfYwq7BN9m/B2dxpR8a6zxm/Sq/S/EKofSigfsZCmEAMIkymLU+NOQgtFiLQz6Jl54GvRByB6Ft+jzPGkuGCM1wTQSlbJdItgYHm55FYWShOF9QBDDvUuChNr80QZFZ\"}";
        String body = "{\"code\":0,\"msg\":\"success\",\"sysTime\":\"2021-07-10 09:50:18\",\"body\":\"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\",\"sec\":\"dGVzdDE7MTYyNTg4MTgxODQxOTU0ODswMQ==\"}";
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
