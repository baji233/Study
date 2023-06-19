package com.itmk.web.suggest.entity;

import lombok.Data;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@Data
public class SuggestParm {
    private Long currentPage;
    private Long pageSize;
    private String title;
}
