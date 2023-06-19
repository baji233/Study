package com.itmk.web.suggest.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itmk.utils.ResultUtils;
import com.itmk.utils.ResultVo;
import com.itmk.web.suggest.entity.Suggest;
import com.itmk.web.suggest.entity.SuggestParm;
import com.itmk.web.suggest.service.SuggestService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@RestController
@RequestMapping("/api/suggest")
public class SuggestController {
    @Autowired
    private SuggestService suggestService;

    //新增
    @PreAuthorize("hasAuthority('sys:suggestList:add')")
    @PostMapping
    public ResultVo add(@RequestBody Suggest suggest){
        suggest.setDateTime(new Date());
        if(suggestService.save(suggest)){
            return ResultUtils.success("反馈成功!");
        }
        return ResultUtils.error("反馈失败!");
    }

    //编辑
    @PreAuthorize("hasAuthority('sys:suggestList:edit')")
    @PutMapping
    public ResultVo edit(@RequestBody Suggest suggest){
        if(suggestService.updateById(suggest)){
            return ResultUtils.success("编辑成功!");
        }
        return ResultUtils.error("编辑失败!");
    }

    //删除
    @PreAuthorize("hasAuthority('sys:suggestList:delete')")
    @DeleteMapping("/{id}")
    public ResultVo delete(@PathVariable("id") Long id){
        if(suggestService.removeById(id)){
            return ResultUtils.success("删除成功!");
        }
        return ResultUtils.error("删除失败!");
    }

    //列表
    @GetMapping("/list")
    public ResultVo list(SuggestParm parm){
        //构造分页对象
        IPage<Suggest> page = new Page<>(parm.getCurrentPage(),parm.getPageSize());
        //构造查询条件
        QueryWrapper<Suggest> query = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(parm.getTitle())){
            query.lambda().like(Suggest::getTitle,parm.getTitle());
        }
        query.lambda().orderByDesc(Suggest::getDateTime);
        IPage<Suggest> list = suggestService.page(page, query);
        return ResultUtils.success("查询成功",list);
    }

}
