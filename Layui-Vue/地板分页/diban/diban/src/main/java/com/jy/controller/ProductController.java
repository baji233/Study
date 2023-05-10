package com.jy.controller;

import com.jy.service.ProductService;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("/Product")
@RestController
public class ProductController {

    @Autowired
    ProductService ps;
    @RequestMapping("findByPage")
    public List findByPage(Integer page, Integer count) {
        //把查询到的结果，转为json后再输出给前端
        return  ps.findByPage(page,count);

    }

}