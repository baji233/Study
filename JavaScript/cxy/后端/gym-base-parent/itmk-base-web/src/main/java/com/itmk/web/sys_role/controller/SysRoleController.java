package com.itmk.web.sys_role.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.itmk.utils.ResultUtils;
import com.itmk.utils.ResultVo;
import com.itmk.web.sys_role.entity.*;
import com.itmk.web.sys_role.service.SysRoleService;
import com.itmk.web.sys_role_menu.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
@RestController
@RequestMapping("/api/role")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private RoleMenuService roleMenuService;

    //新增
    @PreAuthorize("hasAuthority('sys:role:add')")
    @PostMapping
    public ResultVo add(@RequestBody SysRole sysRole){
        //设置插入时间
        sysRole.setCreateTime(new Date());
        if(sysRoleService.save(sysRole)){
            return ResultUtils.success("新增角色成功!");
        }
        return ResultUtils.error("新增角色失败!");
    }

    //编辑
    @PreAuthorize("hasAuthority('sys:role:edit')")
    @PutMapping
    public ResultVo edit(@RequestBody SysRole sysRole){
        //设置更新时间
        sysRole.setUpdateTime(new Date());
        if(sysRoleService.updateById(sysRole)){
            return ResultUtils.success("编辑角色成功!");
        }
        return ResultUtils.error("编辑角色失败!");
    }

    //删除
    @PreAuthorize("hasAuthority('sys:role:delete')")
    @DeleteMapping("/{roleId}")
    public ResultVo delete(@PathVariable("roleId") Long roleId){
        if(sysRoleService.removeById(roleId)){
            return ResultUtils.success("删除成功!");
        }
        return ResultUtils.error("删除失败!");
    }

    //列表
    @GetMapping("/list")
    public ResultVo list(RoleParm parm){
        IPage<SysRole> list = sysRoleService.getList(parm);
        return ResultUtils.success("查询成功",list);
    }

    //员工新增列表
    @GetMapping("/getSelect")
    public ResultVo getListSelect(){
        List<SysRole> list = sysRoleService.list();
        //组装后的select数据
        List<SelectType> selectTypeList = new ArrayList<>();
        if(list.size() >0){
            list.stream().forEach(item ->{
                SelectType selectType = new SelectType();
                selectType.setLabel(item.getRoleName());
                selectType.setValue(item.getRoleId());
                selectTypeList.add(selectType);
            });
        }
        return ResultUtils.success("查询成功",selectTypeList);
    }

    //分配权限树数据回显查询
    @GetMapping("/getMenuTree")
    public ResultVo getMenuTree(RoleAssignParm parm){
        RolePermissionVo tree = sysRoleService.getMenuTree(parm);
        return ResultUtils.success("查询成功",tree);
    }

    //分配权限保存
    @PreAuthorize("hasAuthority('sys:role:assign')")
    @PostMapping("/saveRoleMenu")
    public ResultVo saveRoleMenu(@RequestBody SaveMenuParm parm){
        roleMenuService.saveMenu(parm);
        return ResultUtils.success("分配成功");
    }
}
