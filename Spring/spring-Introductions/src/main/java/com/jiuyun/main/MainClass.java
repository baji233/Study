package com.jiuyun.main;

import com.jiuyun.bean.Student;
import com.jiuyun.service.MyService;
import com.jiuyun.service.StudentService;
import com.jiuyun.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cj
 * @create 2022年11月23日 18:49:17
 */
public class MainClass {
    public static void main(String[] args) {
        demo4();
    }

    private static void demo4() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.update();
    }

    private static void demo3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyService myService = (MyService) applicationContext.getBean("userService");
        myService.service();
    }

    private static void demo2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        MyService myService = (MyService) studentService;
        myService.service();
    }

    private static void demo1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        studentService.save(Student.builder().stuId(1).stuName("tom").build());
    }
}
