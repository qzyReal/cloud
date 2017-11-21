package com.cloud.model;

/**
 * Created by Administrator on 2017/11/5.
 */
public class SystemUser {
    private Integer id;
    private String userName;
    private String password;
    private String userSalt;
    private Integer status;
    /**
     * 密码盐.
     * @return
     */
    public String getCredentialsSalt(){
        return this.userName+this.userSalt;
    }

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

    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
