package com.itmk.web.member_role.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@Data
@TableName("member_role")
public class MemberRole {
    @TableId(type = IdType.AUTO)
    private Long memberRoleId;
    private Long memberId;
    private Long roleId;
}
