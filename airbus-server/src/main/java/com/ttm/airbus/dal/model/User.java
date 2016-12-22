package com.ttm.airbus.dal.model;

/**
 * Created by liguoqing on 2016/9/13.
 */
public class User extends BaseModel {

    private String userId; //登录帐号
    private String userPwd; //登录密码
    private String salt; //加密 随机数

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public User() {
    }

    public User(String userId, String userPwd) {
        this.userId = userId;
        this.userPwd = userPwd;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", salt='" + salt + '\'' +
                '}';
    }
}
