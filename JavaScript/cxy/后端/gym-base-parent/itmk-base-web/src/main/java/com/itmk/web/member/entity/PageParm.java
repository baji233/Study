package com.itmk.web.member.entity;

import lombok.Data;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@Data
public class PageParm {
    private Long currentPage;
    private Long pageSize;
    private String name;
    private String phone;
    private String username;
    private String userType;
    private String memberId;
}
