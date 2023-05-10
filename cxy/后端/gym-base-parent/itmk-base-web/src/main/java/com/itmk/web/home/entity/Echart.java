package com.itmk.web.home.entity;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@Data
public class Echart {
    private List<String> names = new ArrayList<>();
    private List<Integer> values = new ArrayList<>();
}
