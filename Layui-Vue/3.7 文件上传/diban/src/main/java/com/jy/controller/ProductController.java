package com.jy.controller;

import com.jy.entity.Product;
import com.jy.service.ProductService;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/Product")
@RestController
public class ProductController {

    @Autowired
    ProductService ps;

    @RequestMapping("/admin/add")
    public Map add(Product p){
        Map m=new HashMap();
        int i= ps.add(p);
        m.put("coke",i);
        return m;
    }

    @RequestMapping("findByPage")
    public Map findByPage(Integer page, Integer limit) {
        //把查询到的结果，转为json后再输出给前端
        return  ps.findByPage(page,limit);

    }

    @RequestMapping("findByPageMs")
    public Map findByPageMs(Integer page, Integer count) {
            //把查询到的结果，转为json后再输出给前端
            Map map=new HashMap();
            map.put("code",0);
            map.put("data",ps.findByPage(page,count).get("products"));

        return  map;

    }

    @RequestMapping("deleteById")
    public int deleteById(Integer productid){
        return ps.deleteById(productid);
    }
}
