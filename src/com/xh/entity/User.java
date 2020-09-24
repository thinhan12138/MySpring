package com.xh.entity;

public class User {
    private Integer userId;

    private String userName;

    private String userPhone;

    private Integer roleId;

    public User() {
    }

    public User(Integer userId, String userName, String userPhone, Integer roleId) {
        this.userId = userId;
        this.userName = userName;
        this.userPhone = userPhone;
        this.roleId = roleId;
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

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
