package com.itmk.web.member.entity;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@Data
public class RechargeParm {
    private Long userId;
    private Long memberId;
    private BigDecimal money;
}