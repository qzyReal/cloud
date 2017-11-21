package com.cloud.system.entity;

/**
 * Created by Administrator on 2017/11/5.
 */
public class SystemUser {
    private Integer id;
    private String userName;
    private String password;

    public SystemUser() {
    }

    public SystemUser(Integer id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
