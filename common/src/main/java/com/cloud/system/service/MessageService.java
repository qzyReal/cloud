package com.cloud.system.service;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

/**
 * Created by Administrator on 2017/11/20.
 */
public interface MessageService {
    String ORDER_CHANNEL = "orderChannel";
    @Input(ORDER_CHANNEL)
    SubscribableChannel inputOrder();
}
