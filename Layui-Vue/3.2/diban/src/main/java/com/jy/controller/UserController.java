package com.jy.controller;

import com.jy.entity.User;
import com.jy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/User")
@RestController//所有方法的返回都是以json格式的数据输出
public class UserController {
    @Autowired
    UserService us;

    @RequestMapping("login")
    public Map login(String username, String password) {
         Map map=new HashMap();
         List list=us.login(username, password);
         if(list.size()>0){
            map.put("code",1);
            map.put("data",list.get(0));

         }else{
            map.put("code",0);
         }
         return map;
    }

    //根据传入的角色id查询出对应的菜单信息
    @RequestMapping("findMneu")
    public List findMenu(Integer roleId){
        return  us.findMenu(roleId);
    }
}
