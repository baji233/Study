package com.itmk.web.sys_role.entity;

import lombok.Data;

import java.util.List;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@Data
public class SaveMenuParm {
    private Long roleId;
    private List<Long> list;
}
