package com.smart.demo.upload.controller;

import com.smart.demo.qrcode.config.QrCodeUtils;

/**
 *
 * @version V1.0
 * @title: BytesConvertMultipartFile
 * @description:
 * @author: lukewei
 * @date: 2020-11-02 14:05
 * @remark: 修改内容
 */
public class BytesConvertMultipartFile {

    public static void main(String[] args) {
        String content = "https://baike.baidu.com/item/%E5%BC%A0%E5%AD%A6%E5%8F%8B/141598?fr=aladdin";
        byte[] bytes = QrCodeUtils.createQrCode(content, 800, null);
    }
}


