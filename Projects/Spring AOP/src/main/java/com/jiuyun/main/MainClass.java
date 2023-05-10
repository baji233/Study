package com.jiuyun.main;

import com.jiuyun.bean.Student;
import com.jiuyun.bean.User;
import com.jiuyun.service.StudentService;
import com.jiuyun.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class MainClass {
    public static void main(String[] args) {
        try {
            demo3();
        } catch (SQLException throwables) { }
    }

    private static void demo3() throws SQLException{
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();
        userService.update();
    }

    private static void demo2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        studentService.update(Student.builder().stuId(2).stuName("tjw").age(54).sex("男").remark("sb").build());
    }

    private static void demo1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        studentService.save(Student.builder().stuId(1).stuName("tjw").age(78).sex("男").remark("无").build());
    }

}
