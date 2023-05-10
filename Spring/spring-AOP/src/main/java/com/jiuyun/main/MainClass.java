package com.jiuyun.main;

import com.jiuyun.bean.Student;
import com.jiuyun.service.StudentService;
import com.jiuyun.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * @author cj
 * @create 2022年11月22日 18:50:23
 */
public class MainClass {
    public static void main(String[] args) {
        try {
            demo3();
        } catch (SQLException exception) {
//            exception.printStackTrace();
        }
    }

    private static void demo3() throws SQLException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
//        userService.save();
        userService.update();
    }

    private static void demo2() {ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        studentService.update(Student.builder().stuId(1).stuName("jack").age(19).build());

    }

    private static void demo1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        studentService.save(Student.builder().stuId(1).stuName("jack").age(19).build());
    }
}
















