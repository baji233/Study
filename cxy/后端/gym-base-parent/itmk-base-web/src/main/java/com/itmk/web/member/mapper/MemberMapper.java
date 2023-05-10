package com.itmk.web.member.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.itmk.web.member.entity.Member;
import com.itmk.web.member.entity.RechargeParm;
import org.apache.ibatis.annotations.Param;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
public interface MemberMapper extends BaseMapper<Member> {
    //更新会员充值金额
     int addMoney(@Param("parm") RechargeParm parm);
     int subMoney(@Param("parm") RechargeParm parm);
}
