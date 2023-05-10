package com.itmk.web.login;

import lombok.Data;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@Data
public class LoginResult {
    private Long userId;
    private String username;
    private String token;
    private String userType;
}