package com.jiuyun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cj
 * @create 2022年11月24日 19:38:50
 */
@Controller
public class HelloController {

    @RequestMapping("hello")
    public String hello() {
        return "hello";
    }
}
