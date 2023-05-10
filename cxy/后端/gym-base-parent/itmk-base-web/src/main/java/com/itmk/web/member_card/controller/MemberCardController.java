package com.itmk.web.member_card.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itmk.utils.ResultUtils;
import com.itmk.utils.ResultVo;
import com.itmk.web.member_card.entity.ListCard;
import com.itmk.web.member_card.entity.MemberCard;
import com.itmk.web.member_card.service.MemberCardService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@RestController
@RequestMapping("/api/memberCard")
public class MemberCardController {
    @Autowired
    private MemberCardService memberCardService;

    //新增
    @PreAuthorize("hasAuthority('sys:memberRoot:add')")
    @PostMapping
    public ResultVo add(@RequestBody MemberCard memberCard){
        if(memberCardService.save(memberCard)){
            return ResultUtils.success("新增成功!");
        }
        return ResultUtils.error("新增失败!");
    }
     //编辑
    @PreAuthorize("hasAuthority('sys:memberRoot:edit')")
    @PutMapping
    public ResultVo edit(@RequestBody MemberCard memberCard){
        if(memberCardService.updateById(memberCard)){
            return ResultUtils.success("编辑成功!");
        }
        return ResultUtils.error("编辑失败!");
    }

    //删除
    @PreAuthorize("hasAuthority('sys:memberRoot:delete')")
    @DeleteMapping("/{cardId}")
    public ResultVo delete(@PathVariable("cardId") Long cardId){
        if(memberCardService.removeById(cardId)){
         return ResultUtils.success("删除成功!");
        }
        return ResultUtils.error("删除失败!");
    }

    //列表
    @GetMapping("/list")
    public ResultVo list(ListCard listCard){
        //构造分页对象
        IPage<MemberCard> page = new Page<>(listCard.getCurrentPage(),listCard.getPageSize());
        //构造查询条件
        QueryWrapper<MemberCard> query = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(listCard.getTitle())){
            query.lambda().like(MemberCard::getTitle,listCard.getTitle());
        }
        IPage<MemberCard> list = memberCardService.page(page, query);
        return ResultUtils.success("查询成功",list);
    }
}
