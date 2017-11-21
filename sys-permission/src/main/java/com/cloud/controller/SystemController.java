package com.cloud.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by Administrator on 2017/11/6.
 */
@Controller
@RequestMapping(value = "sys")
public class SystemController {
    @PostMapping(value = "login")
    public String login(@RequestParam("userName") String userName, @RequestParam(value = "password") String password){
        UsernamePasswordToken token=new UsernamePasswordToken(userName,password);
        SecurityUtils.getSubject().login(token);
        return "home";
    }
}
