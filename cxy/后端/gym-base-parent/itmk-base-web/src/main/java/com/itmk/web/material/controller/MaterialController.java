package com.itmk.web.material.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itmk.utils.ResultUtils;
import com.itmk.utils.ResultVo;
import com.itmk.web.material.entity.ListParm;
import com.itmk.web.material.entity.Material;
import com.itmk.web.material.service.MaterialService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@RestController
@RequestMapping("/api/material")
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    //新增
    @PostMapping
    @PreAuthorize("hasAuthority('sys:materialList:add')")
    public ResultVo add(@RequestBody Material material){
        if(materialService.save(material)){
            return ResultUtils.success("新增成功!");
        }
        return ResultUtils.error("新增失败!");
    }

     //编辑
    @PutMapping
    @PreAuthorize("hasAuthority('sys:materialList:edit')")
    public ResultVo edit(@RequestBody Material material){
        if(materialService.updateById(material)){
            return ResultUtils.success("编辑成功!");
        }
        return ResultUtils.error("编辑失败!");
    }

    //删除
    @PreAuthorize("hasAuthority('sys:materialList:delete')")
    @DeleteMapping("/{id}")
    public ResultVo delete(@PathVariable("id") Long id){
        if(materialService.removeById(id)){
          return ResultUtils.success("删除成功!");
        }
        return ResultUtils.error("删除失败!");
    }

    //列表
    @GetMapping("/list")
    public ResultVo list(ListParm parm){
        //构造分页对象
        IPage<Material> page = new Page<>(parm.getCurrentPage(),parm.getPageSize());
        //构造查询条件
        QueryWrapper<Material> query = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(parm.getName())){
            query.lambda().like(Material::getName,parm.getName());
        }
        IPage<Material> list = materialService.page(page, query);
        return ResultUtils.success("查询成功",list);
    }

}
