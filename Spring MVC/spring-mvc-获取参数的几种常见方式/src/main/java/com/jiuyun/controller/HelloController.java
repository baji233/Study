package com.jiuyun.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cj
 * @create 2022年11月25日 18:51:15
 */
@Slf4j
@Controller
public class HelloController {

    @RequestMapping("hello")
    public String hello() {
        log.info("this is HelloController.hello() method!");
        return "hello";
    }
}
