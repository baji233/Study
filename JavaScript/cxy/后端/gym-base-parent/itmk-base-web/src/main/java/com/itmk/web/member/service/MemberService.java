package com.itmk.web.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itmk.web.member.entity.JoinParm;
import com.itmk.web.member.entity.Member;
import com.itmk.web.member.entity.RechargeParm;

import java.text.ParseException;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
public interface MemberService extends IService<Member> {
    void addMember(Member member);

    void editMember(Member member);

    void deleteMember(Long memberId);

    //办卡
    void joinApply(JoinParm joinParm) throws ParseException;

    //充值
    void recharge(RechargeParm parm);

    //根据用户名查用户
    Member loadUser(String username);
}
