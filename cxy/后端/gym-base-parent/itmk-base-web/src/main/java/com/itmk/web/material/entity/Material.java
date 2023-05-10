package com.itmk.web.material.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@Data
@TableName("material")
public class Material {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private String details;
    private Integer numTotal;
}
