package com.itmk.web.member.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itmk.utils.ResultUtils;
import com.itmk.utils.ResultVo;
import com.itmk.web.member.entity.*;
import com.itmk.web.member.service.MemberService;
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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@RestController
@RequestMapping("/api/member")
public class MemberController {
    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRoleService memberRoleService;
    @Autowired
    private MemberCardService memberCardService;
    @Autowired
    private MemberRechargeService memberRechargeService;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //我的充值查询
    @GetMapping("/getMyRecharge")
    public ResultVo getMyRecharge(RechargeParmList parm) {
        //判断是会员还是员工
        if (parm.getUserType().equals("1")) {//会员
            IPage<MemberRecharge> list = memberRechargeService.getRecherByMember(parm);
            return ResultUtils.success("查询成功", list);
        } else if (parm.getUserType().equals("2")) { //员工
            IPage<MemberRecharge> list = memberRechargeService.getRecherList(parm);
            return ResultUtils.success("查询成功", list);
        } else {
            return ResultUtils.error("用户类型不存在!");
        }
    }

    //新增
    @PostMapping
    @PreAuthorize("hasAuthority('sys:memberList:add')")
    public ResultVo add(@RequestBody Member member) {
        //判断卡号是否重复
        QueryWrapper<Member> query = new QueryWrapper<>();
        query.lambda().eq(Member::getUsername, member.getUsername());
        Member one = memberService.getOne(query);
        if (one != null) {
            return ResultUtils.error("会员卡号被占用!");
        }
        //密码加密
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        memberService.addMember(member);
        return ResultUtils.success("新增成功!");
    }

    //编辑
    @PutMapping
    @PreAuthorize("hasAuthority('sys:memberList:edit')")
    public ResultVo edit(@RequestBody Member member) {
        //判断卡号是否重复
        QueryWrapper<Member> query = new QueryWrapper<>();
        query.lambda().eq(Member::getUsername, member.getUsername());
        Member one = memberService.getOne(query);
        if (one != null && !one.getMemberId().equals(member.getMemberId())) {
            return ResultUtils.error("会员卡号被占用!");
        }
        memberService.editMember(member);
        return ResultUtils.success("编辑成功!");
    }

    //删除
    @PreAuthorize("hasAuthority('sys:memberList:delete')")
    @DeleteMapping("/{memberId}")
    public ResultVo delete(@PathVariable("memberId") Long memberId) {
        memberService.deleteMember(memberId);
        return ResultUtils.success("删除成功!");
    }

    //查询
    @GetMapping("/list")
    public ResultVo list(PageParm pageParm) {
        if (pageParm.getUserType().equals("1")) {
                //构造分页对象
            IPage<Member> page = new Page<>(pageParm.getCurrentPage(), pageParm.getPageSize());
            //构造查询条件
            QueryWrapper<Member> query = new QueryWrapper<>();
            if (StringUtils.isNotEmpty(pageParm.getName())) {
                query.lambda().like(Member::getName, pageParm.getName());
            }
            if (StringUtils.isNotEmpty(pageParm.getPhone())) {
                query.lambda().like(Member::getPhone, pageParm.getPhone());
            }
            if (StringUtils.isNotEmpty(pageParm.getUsername())) {
                query.lambda().like(Member::getUsername, pageParm.getUsername());
            }
            query.lambda().eq(Member::getMemberId,pageParm.getMemberId());
            query.lambda().orderByDesc(Member::getJoinTime);
            IPage<Member> list = memberService.page(page, query);
            return ResultUtils.success("查询成功", list);
        } else {
            //构造分页对象
            IPage<Member> page = new Page<>(pageParm.getCurrentPage(), pageParm.getPageSize());
            //构造查询条件
            QueryWrapper<Member> query = new QueryWrapper<>();
            if (StringUtils.isNotEmpty(pageParm.getName())) {
                query.lambda().like(Member::getName, pageParm.getName());
            }
            if (StringUtils.isNotEmpty(pageParm.getPhone())) {
                query.lambda().like(Member::getPhone, pageParm.getPhone());
            }
            if (StringUtils.isNotEmpty(pageParm.getUsername())) {
                query.lambda().like(Member::getUsername, pageParm.getUsername());
            }
            query.lambda().orderByDesc(Member::getJoinTime);
            IPage<Member> list = memberService.page(page, query);
            return ResultUtils.success("查询成功", list);
        }
    }

    //根据会员id查询角色id
    @GetMapping("/getRoleByMemberId")
    public ResultVo getRoleByMemberId(Long memberId) {
        QueryWrapper<MemberRole> query = new QueryWrapper<>();
        query.lambda().eq(MemberRole::getMemberId, memberId);
        MemberRole one = memberRoleService.getOne(query);
        return ResultUtils.success("查询成功", one);
    }

    //查询会员卡列表
    @GetMapping("/getCardList")
    public ResultVo getCardList() {
        List<MemberCard> list = memberCardService.list();
        return ResultUtils.success("查询成功", list);
    }

    //办卡
    @PreAuthorize("hasAuthority('sys:memberList:setCard')")
    @PostMapping("/joinApply")
    public ResultVo joinApply(@RequestBody JoinParm joinParm) throws ParseException {
        memberService.joinApply(joinParm);
        return ResultUtils.success("办卡成功!");
    }

    //充值
    @PreAuthorize("hasAuthority('sys:memberList:rechart')")
    @PostMapping("/recharge")
    public ResultVo recharge(@RequestBody RechargeParm rechargeParm) throws ParseException {
        memberService.recharge(rechargeParm);
        return ResultUtils.success("充值成功!");
    }
}
