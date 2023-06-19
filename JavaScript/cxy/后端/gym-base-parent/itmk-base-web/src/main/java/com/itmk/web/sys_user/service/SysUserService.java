package com.itmk.web.sys_user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itmk.web.sys_user.entity.PageParm;
import com.itmk.web.sys_user.entity.SysUser;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
public interface SysUserService extends IService<SysUser> {
    //新增
    void addUser(SysUser sysUser);

    //编辑
    void editUser(SysUser sysUser);

    //删除出
    void deleteUser(Long userId);

    //列表
    IPage<SysUser> getList(PageParm parm);

    //根据用户名查用户
    SysUser loadUser(String username);

}
