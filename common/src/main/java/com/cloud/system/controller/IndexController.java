package com.cloud.system.controller;

import com.cloud.system.service.MessageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/11/20.
 */
@RestController
public class IndexController {
    Logger logger = LoggerFactory.getLogger(IndexController.class);

    @StreamListener(MessageService.ORDER_CHANNEL)
    public void getMsg(byte[] message) {
        logger.info("==接收到的信息====={}", new String(message));
    }
}
