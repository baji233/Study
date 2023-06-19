package com.itmk.web.member_card.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@Data
@TableName("member_card")
public class MemberCard {
    @TableId(type = IdType.AUTO)
    private Long cardId;
    private String title;
    private String cardType;
    private BigDecimal price;
    private Integer cardDay;
    private String status;
}
