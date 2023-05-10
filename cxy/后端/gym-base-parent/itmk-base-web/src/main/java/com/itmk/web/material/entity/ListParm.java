package com.itmk.web.material.entity;

import lombok.Data;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@Data
public class ListParm {
    private Long currentPage;
    private Long pageSize;
    private String name;
}
