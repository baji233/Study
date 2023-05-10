package com.jy.service.impl;

import com.jy.dao.MenuMapper;
import com.jy.dao.UserMapper;
import com.jy.entity.Menu;
import com.jy.entity.User;
import com.jy.entity.UserExample;
import com.jy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper um;
    @Autowired
    MenuMapper mm;
    //查询当前角色对应的菜单信息
    public List<Menu> findMenu(Integer roleId){
        return mm.findMenu(roleId);
    }
    public List login(String username, String password){
        UserExample ue=new UserExample();
        UserExample.Criteria criteria = ue.createCriteria();
        criteria.andUsernameEqualTo(username);
        criteria.andPasswordEqualTo(password);
        return  um.selectByExample(ue);


    }
}
