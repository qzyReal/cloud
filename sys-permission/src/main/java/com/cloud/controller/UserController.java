package com.cloud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/11/5.
 */
@RestController
public class UserController {
    Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private RestTemplate template;
    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping(value = "users/{id}")
    public String getUser(@PathVariable Integer id) {
        for (int i=0;i<10;i++){
            ServiceInstance serviceInstance=loadBalancerClient.choose("system-common");
            logger.info("======{}:{}:{}",serviceInstance.getServiceId(),serviceInstance.getHost(),serviceInstance.getPort());
        }
        return this.template.getForObject("http://system-common/common/users/" + id, String .class);
    }
}
