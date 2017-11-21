package com.cloud.service;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/11/20.
 */
@Component
public interface MessageService {
    String ORDER_CHANNEL = "orderChannel";

    @Output(ORDER_CHANNEL)
    SubscribableChannel sendMsg();
}
