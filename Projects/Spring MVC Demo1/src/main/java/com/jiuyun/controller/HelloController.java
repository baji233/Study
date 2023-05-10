package com.jiuyun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//请求映射->路径中带有/SpringMVC/..的请求关联
@RequestMapping("SpringMVC")
@Controller
public class HelloController {
    //请求映射->路径中带有/hello的请求关联hello方法
    @RequestMapping("hello")
    public String hello(){
        return "hello";
    }
}
