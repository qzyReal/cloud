package com.cloud.controller;

import com.cloud.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/11/20.
 */
@RestController
public class MessageController {
    @Autowired
    private MessageService messageService;

    @PostMapping("sendMsg")
    public boolean serMsg() {
        return messageService.sendMsg().send(MessageBuilder.withPayload("你好！".getBytes()).build());
    }
}
