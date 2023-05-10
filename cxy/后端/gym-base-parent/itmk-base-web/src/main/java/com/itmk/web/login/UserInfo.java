package com.itmk.web.login;

import lombok.Data;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@Data
public class UserInfo {
    private Long userId;
    private String name;
    private Object[] permissons;
}
