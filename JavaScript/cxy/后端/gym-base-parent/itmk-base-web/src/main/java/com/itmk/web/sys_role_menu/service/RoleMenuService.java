package com.itmk.web.sys_role_menu.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.itmk.web.sys_role.entity.SaveMenuParm;
import com.itmk.web.sys_role_menu.entity.RoleMenu;

/**
 * @Author java实战基地
 * @Version 2383404558
 */
public interface RoleMenuService extends IService<RoleMenu> {
    //保存角色权限
    void saveMenu(SaveMenuParm parm);
}
