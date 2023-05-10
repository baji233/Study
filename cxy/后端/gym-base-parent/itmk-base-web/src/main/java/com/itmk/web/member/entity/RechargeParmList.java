package com.itmk.web.member.entity;

import lombok.Data;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@Data
public class RechargeParmList {
    private Long currentPage;
    private Long pageSize;
    private Long memberId;
    private String userType;
}
