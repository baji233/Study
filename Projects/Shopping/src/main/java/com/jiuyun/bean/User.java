package com.jiuyun.bean;

public class User {
    private Integer userId;
    private String userName;
    private String password;
    private String remark;

    public User() {

    }

    public User(Integer userId, String userName, String password, String remark) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.remark = remark;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
