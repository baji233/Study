package com.jy.controller;

import com.jy.entity.User;
import com.jy.service.UserService;
import com.jy.util.AESUtils;
import com.jy.util.SecretKeyUtils;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/User")
@RestController//所有方法的返回都是以json格式的数据输出
public class UserController {
    @Autowired
    UserService us;

    @RequestMapping("login")
    public Map login(String username, String password, HttpSession session, HttpServletRequest request) {
        Map map=new HashMap();
        try{
            List list=us.login(username, password);
            if(list.size()>0){
                map.put("code",1);
                User user= (User) list.get(0);
                map.put("data",user);
                String token_str="username:"+user.getUsername()+",userId:"+user.getUserid();
                String key= SecretKeyUtils.generateAESKey();//生产密钥
                String encrypt_token=AESUtils.encrypt(token_str,key);//加密
                request.getServletContext().setAttribute("key",key);//把密钥存入application
                //产生一个token
                map.put("token",encrypt_token);//加密后的token传给前端

                //服务器要备份
                // session.setAttribute("token","username:"+user.getUsername()+",userId:"+user.getUserid()+",password:"+user.getUsername());
            }else{
                map.put("code",0);
            }
            return map;
        }catch (Exception e){
            e.printStackTrace();
            map.put("code",0);
            return map;
        }

    }

    //根据传入的角色id查询出对应的菜单信息
    @RequestMapping("admin/findMneu")
    public List findMenu(Integer roleId,String token,HttpServletRequest request){
        System.out.println("findMenu.......");
        return  us.findMenu(roleId);

    }




}
