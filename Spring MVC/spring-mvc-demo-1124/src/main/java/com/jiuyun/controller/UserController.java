package com.jiuyun.controller;

import com.jiuyun.bean.User;
import com.jiuyun.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * @author cj
 * @create 2022年11月24日 20:46:41
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    @RequestMapping("selectById")
    public ModelAndView selectById(Integer id) {
        ModelAndView modelAndView = new ModelAndView();

        return modelAndView;
    }

    @RequestMapping("save")
    public String save() {
        return "success";
    }

}
