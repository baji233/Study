package com.jiuyun.controller;

import com.jiuyun.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;

/**
 * @author cj
 * @create 2022年11月24日 20:25:11
 */
@Controller
@RequestMapping("student")
public class StudentController {
    @Resource
    private StudentService studentService;

    @RequestMapping(value = "save" , method = RequestMethod.POST)
    public String save() {
        studentService.save();
        return "success";
    }


    @RequestMapping("update")
    public String update() {
        studentService.save();
        return "success";
    }
}
