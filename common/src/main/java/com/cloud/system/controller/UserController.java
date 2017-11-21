package com.cloud.system.controller;

import com.cloud.system.entity.SystemUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/11/5.
 */
@RestController
@RequestMapping(value = "common")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping(value = "users/{id}")
    public SystemUser getUser(@PathVariable Integer id) {
        return new SystemUser(id, "张三", "admin");
    }
}
