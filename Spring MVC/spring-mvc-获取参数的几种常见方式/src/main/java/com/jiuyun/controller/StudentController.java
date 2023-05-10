package com.jiuyun.controller;

import com.jiuyun.bean.Student;
import com.jiuyun.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author cj
 * @create 2022年11月25日 19:01:28
 */
@Slf4j
@Controller
@RequestMapping("student")
public class StudentController {
    @Resource
    private StudentService studentService;

    @ModelAttribute
    public void init() {
        log.info("this is StudentController.init() method!");
    }

    @RequestMapping(value = "save",method = RequestMethod.GET)
    public String save(@ModelAttribute Student student) {
        studentService.save(student);
        return "success";
    }

    @RequestMapping("deleteById")
    public String deleteById(HttpServletRequest request) {
        String strId = request.getParameter("stuId");
        log.info("需要删除的学号为：" + strId);
        return "success";
    }

    @RequestMapping(value = "selectById/{stuId}", method = RequestMethod.GET)
    public String selectById(@PathVariable Integer stuId) {
        log.info("您要查找的学员编号为：" + stuId);
        return "success";
    }
}
