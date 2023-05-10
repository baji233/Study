package com.itmk.web.lost.entity;

import lombok.Data;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@Data
public class LostParm {
    private Long currentPage;
    private Long pageSize;
    private String lostName;
}
