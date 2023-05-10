package com.jiuyun.bean;

/**
 * @author cj
 * @create 2022年10月26日 19:45:46
 */
public class User {
    private Integer id;
    private String userName;
    private String password;
    private String remark;

    public User() {
    }

    public User(Integer id, String userName, String password, String remark) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.remark = remark;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
