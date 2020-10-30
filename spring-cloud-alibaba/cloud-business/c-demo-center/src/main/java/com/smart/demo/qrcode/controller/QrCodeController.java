package com.smart.demo.qrcode.controller;

import cn.hutool.core.util.IdUtil;
import com.google.common.collect.Lists;
import com.smart.demo.qrcode.config.QrCodeUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.testng.Assert;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @version V1.0
 * @title: QrCodeController
 * @description:
 * @author: lukewei
 * @date: 2020-10-30 14:29
 * @remark: 修改内容
 */
@Slf4j
@RestController
public class QrCodeController {

//    private String content = "啥时候能去听一场周杰伦的演唱会！";

    private String content = "https://baike.baidu.com/item/%E5%BC%A0%E5%AD%A6%E5%8F%8B/141598?fr=aladdin";

    private List<Path> generatedQrCodePaths = Lists.newArrayList();

    /**
     * 创建未带Logo的二维码
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/qr-code/no-logo")
    public String createQrCode() throws Exception {
        byte[] bytes = QrCodeUtils.createQrCode(content, 800, null);
        Path path = Files.createTempFile("qrcode_800_", ".jpg");
        generatedQrCodePaths.add(path);
        log.info("{}", path.toAbsolutePath());
        Files.write(path, bytes);

        bytes = QrCodeUtils.createQrCode(content, null);
        path = Files.createTempFile("qrcode_400_", ".jpg");
        generatedQrCodePaths.add(path);
        log.info("{}", path.toAbsolutePath());
        Files.write(path, bytes);
        return "创建不带Logo的二维码成功！";
    }

    /**
     * 创建带Logo的二维码
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/qr-code/logo")
    public String createQrCodeWithLogo() throws Exception {
        long fileId = IdUtil.createSnowflake(1, 1).nextId();
        String qrPath = "E:\\\\tmp\\data\\qrcode\\";
        String baseUrl = qrPath + fileId + ".jpg";
        InputStream inputStream = ClassLoader.getSystemResourceAsStream("love.jpg");
        File logoFile = Files.createTempFile("logo_", ".jpg").toFile();
        FileUtils.copyInputStreamToFile(inputStream, logoFile);
        log.info("{}", logoFile);
        byte[] bytes = QrCodeUtils.createQrCode(content, 800, logoFile);
//        Path path = Files.createTempFile("qrcode_with_logo_", ".jpg");
//        generatedQrCodePaths.add(path);
//        log.info("{}", path.toAbsolutePath());
        // 取消默认生成的二维码
//        Files.write(path, bytes);
       // 如果文件不存在就创建
        File file = new File(qrPath);
        if (!file.exists() && !file.isDirectory()) {
            file.mkdirs();
        }
        // 直接将流写入到文件中
        FileOutputStream fileOutputStream = new FileOutputStream(new File(baseUrl));
        for (int i = 0; i < bytes.length; i++) {
            fileOutputStream.write(bytes[i]);
        }
        fileOutputStream.flush();
        fileOutputStream.close();
        return "创建带Logo的二维码成功！二维码地址："+ baseUrl;
    }

    /**
     * 解密
     *
     * @return
     * @throws Exception
     */
    @GetMapping("/qr-code/de")
    public List<String> decodeQrCode() throws Exception {
        List<String> list = new ArrayList<>();
        for (Path path : generatedQrCodePaths) {
            // 获取解密内容
            String str = QrCodeUtils.decodeQrCode(path.toFile());
            Assert.assertEquals(QrCodeUtils.decodeQrCode(path.toFile()), content);
            list.add(str);
        }
        return list;
    }

}
