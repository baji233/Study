package com.itmk.web.member_recharge.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itmk.web.member_recharge.entity.MemberRecharge;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
public interface MemberRechargeMapper extends BaseMapper<MemberRecharge> {
    IPage<MemberRecharge> getRecherList(IPage<MemberRecharge> page);
    IPage<MemberRecharge> getRecherByMember(IPage<MemberRecharge> page,@Param("memberId") Long memberId);
}
