package com.itmk.web.member.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.itmk.web.member.entity.JoinParm;
import com.itmk.web.member.entity.Member;
import com.itmk.web.member.entity.RechargeParm;
import com.itmk.web.member.mapper.MemberMapper;
import com.itmk.web.member.service.MemberService;
import com.itmk.web.member_apply.entity.MemberApply;
import com.itmk.web.member_apply.service.MemberApplyService;
import com.itmk.web.member_card.entity.MemberCard;
import com.itmk.web.member_card.service.MemberCardService;
import com.itmk.web.member_recharge.entity.MemberRecharge;
import com.itmk.web.member_recharge.service.MemberRechargeService;
import com.itmk.web.member_role.entity.MemberRole;
import com.itmk.web.member_role.service.MemberRoleService;
import com.itmk.web.sys_user.entity.SysUser;
import com.itmk.web.sys_user.service.SysUserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@Service
public class MemberServiceImpl extends ServiceImpl<MemberMapper, Member> implements MemberService {
    @Autowired
    private MemberRoleService memberRoleService;
    @Autowired
    private MemberCardService memberCardService;
    @Autowired
    private MemberApplyService memberApplyService;
    @Autowired
    private MemberRechargeService memberRechargeService;
    @Autowired
    private SysUserService sysUserService;

    @Override
    @Transactional
    public void addMember(Member member) {
        //新增会员
        int insert = this.baseMapper.insert(member);
        //设置会员角色
        if (insert > 0) {
            MemberRole role = new MemberRole();
            role.setMemberId(member.getMemberId());
            role.setRoleId(member.getRoleId());
            memberRoleService.save(role);
        }
    }

    @Override
    @Transactional
    public void editMember(Member member) {
        int i = this.baseMapper.updateById(member);
        //设置角色  先删除，再插入
        if (i > 0) {
            //删除
            QueryWrapper<MemberRole> query = new QueryWrapper<>();
            query.lambda().eq(MemberRole::getMemberId, member.getMemberId());
            memberRoleService.remove(query);
            //重新插入
            MemberRole role = new MemberRole();
            role.setMemberId(member.getMemberId());
            role.setRoleId(member.getRoleId());
            memberRoleService.save(role);
        }

    }

    @Override
    @Transactional
    public void deleteMember(Long memberId) {
        //删除
        int i = this.baseMapper.deleteById(memberId);
        if (i > 0) {
            QueryWrapper<MemberRole> query = new QueryWrapper<>();
            query.lambda().eq(MemberRole::getMemberId, memberId);
            memberRoleService.remove(query);
        }
    }

    @Override
    public void joinApply(JoinParm joinParm) throws ParseException {
        //根据会员id查询会员信息
        Member select = this.baseMapper.selectById(joinParm.getMemberId());
        //根据会员卡查询信息
        MemberCard card = memberCardService.getById(joinParm.getCardId());
        //更新会员信息
        Member member = new Member();
        member.setMemberId(joinParm.getMemberId());
        member.setCardType(card.getTitle());
        member.setCardDay(card.getCardDay());
        member.setPrice(card.getPrice());
        String endTime = select.getEndTime();
        Calendar calendar = Calendar.getInstance();
        //判断结束时间是否空
        if (StringUtils.isNotEmpty(endTime)) {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(select.getEndTime());
            calendar.setTime(date);
            //结束时间，加上会员卡类型的时间
            calendar.add(Calendar.DATE, card.getCardDay());
        } else {
            //当前时间
            Date data = new Date();
            calendar.setTime(data);
            //当前时间+ 卡的天数 = 结束时间
            calendar.add(Calendar.DATE, card.getCardDay());
        }
        member.setEndTime(new SimpleDateFormat("yyyy-MM-dd").format(calendar.getTime()));
        //更新会员信息
        int i = this.baseMapper.updateById(member);
        if (i > 0) {
            //插入办卡明细
            MemberApply apply = new MemberApply();
            apply.setMemberId(member.getMemberId());
            apply.setCreateTime(new Date());
            apply.setCardDay(card.getCardDay());
            apply.setCardType(card.getTitle());
            apply.setPrice(card.getPrice());
            memberApplyService.save(apply);
        }
    }

    @Override
    public void recharge(RechargeParm parm) {
        Long userId = parm.getUserId();
        SysUser user = sysUserService.getById(userId);
        //生成充值明细
        MemberRecharge recharge = new MemberRecharge();
        recharge.setMoney(parm.getMoney());
        recharge.setMemberId(parm.getMemberId());
        recharge.setCreateTime(new Date());
        recharge.setCreateUser(user.getNickName());
        boolean save = memberRechargeService.save(recharge);
        //更新会员的充值金额
        if (save) {
            this.baseMapper.addMoney(parm);
        }
    }

    @Override
    public Member loadUser(String username) {
        QueryWrapper<Member> query = new QueryWrapper<>();
        query.lambda().eq(Member::getUsername, username);
        return this.baseMapper.selectOne(query);
    }
}
