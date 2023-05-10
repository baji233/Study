package com.jiuyun.main;

import com.jiuyun.dao.StudentDAO;
import com.jiuyun.dao.UserDAO;
import com.jiuyun.service.BaseService;
import com.jiuyun.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author cj
 * @create 2022年11月01日 18:46:29
 */
public class MainClass {
    public static void main(String[] args) {
        demo4();
    }

    private static void demo4() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        BaseService baseService = (BaseService) applicationContext.getBean("baseService");
        baseService.save();
    }

    private static void demo3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDAO userDAO = (UserDAO) applicationContext.getBean("userDAO");
        userDAO.save();
    }

    private static void demo2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        studentService.save();
    }

    private static void demo1() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentDAO studentDAO = (StudentDAO) applicationContext.getBean("studentDAO");
        studentDAO.save();
    }
}
