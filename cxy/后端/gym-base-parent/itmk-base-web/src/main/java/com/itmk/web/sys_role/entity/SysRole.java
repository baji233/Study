package com.itmk.web.sys_role.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@Data
@TableName("sys_role")
public class SysRole {
    //指定roleId为主键，自动递增
    @TableId(type = IdType.AUTO)
    private Long roleId;
    private String roleName;
    private String remark;
    private Date createTime;
    private Date updateTime;
}
