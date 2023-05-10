package com.itmk.web.goods.entity;

import lombok.Data;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@Data
public class GoodsParm {
    private Long currentPage;
    private Long pageSize;
    private String name;
}
