package com.itmk.web.member_recharge.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itmk.web.member.entity.RechargeParmList;
import com.itmk.web.member_recharge.entity.MemberRecharge;
import com.itmk.web.member_recharge.mapper.MemberRechargeMapper;
import com.itmk.web.member_recharge.service.MemberRechargeService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@Service
public class MemberRechargeServiceImpl extends ServiceImpl<MemberRechargeMapper, MemberRecharge> implements MemberRechargeService {
    @Override
    public IPage<MemberRecharge> getRecherList(RechargeParmList parmList) {
        //构造分页对象
        IPage<MemberRecharge> page = new Page<>(parmList.getCurrentPage(),parmList.getPageSize());
        return this.baseMapper.getRecherList(page);
    }

    @Override
    public IPage<MemberRecharge> getRecherByMember(RechargeParmList parmList) {
        //构造分页对象
        IPage<MemberRecharge> page = new Page<>(parmList.getCurrentPage(),parmList.getPageSize());
        return this.baseMapper.getRecherByMember(page,parmList.getMemberId());
    }
}
