package com.cloud.service;

import com.cloud.model.SystemUser;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/11/6.
 */
@Service
public class SystemUserService {
    public SystemUser getUserByUserName(String userName) {
        return new SystemUser();
    }
}
