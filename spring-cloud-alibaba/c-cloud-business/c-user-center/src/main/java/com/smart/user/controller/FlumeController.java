package com.smart.user.controller;

import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * All rights Reserved, Designed By http://www.hollysmart.com.cn
 *
 * @version V1.0
 * @title: FlumeController
 * @description:
 * @author: lukewei
 * @date: 2020-11-22 15:15
 * @remark: 修改内容
 */
@Slf4j
@RestController
public class FlumeController {


    @GetMapping("/flume")
    public void flumeTest() throws InterruptedException {

        for (int i = 0; i < 30; i++) {
            Thread.sleep(3000);
            String word = IdUtil.randomUUID();
            log.info(i + " ：" + word);
        }

    }
}
