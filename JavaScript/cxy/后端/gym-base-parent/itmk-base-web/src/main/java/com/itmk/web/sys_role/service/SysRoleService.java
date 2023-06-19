package com.itmk.web.sys_role.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itmk.web.sys_role.entity.RoleAssignParm;
import com.itmk.web.sys_role.entity.RoleParm;
import com.itmk.web.sys_role.entity.RolePermissionVo;
import com.itmk.web.sys_role.entity.SysRole;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
public interface SysRoleService extends IService<SysRole> {
    IPage<SysRole> getList(RoleParm parm);
    //查询权限树数据回显
    RolePermissionVo getMenuTree(RoleAssignParm parm);
}
