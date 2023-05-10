package com.itmk.web.home.entity;

import lombok.Data;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@Data
public class ResetPassword {
    private Long userId;
    private String userType;
    private String password;
    private String oldPassword;
}
