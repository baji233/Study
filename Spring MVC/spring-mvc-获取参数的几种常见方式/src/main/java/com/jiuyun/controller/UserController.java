package com.jiuyun.controller;

import com.jiuyun.bean.User;
import com.jiuyun.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author cj
 * @create 2022年11月25日 19:09:06
 */
@Slf4j
@Controller
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("login")
    public String login(String userName, String password) {
        if("admin".equals(userName) && "123".equals(password)) {
            return "ok";
        } else {
            return "fail";
        }
    }

    @RequestMapping("selectById")
    public ModelAndView selectById(@RequestParam("userId") Integer userId) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.selectById(userId);
        modelAndView.setViewName("showUser");
        modelAndView.addObject("user", user);
        return modelAndView;
    }

}
