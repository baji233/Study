package com.jiuyun.main;

import com.jiuyun.dao.StudentDAO;
import com.jiuyun.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 常见的自动装配注解
 */
public class MainDemo {
    private static final Logger log = LoggerFactory.getLogger(StudentDAO.class);
    //ClassPathXmlApplicationContext 类路径Xml应用程序上下文(靠xml配置文件用这个)
    //AnnotationConfigApplicationContext 注解配置应用程序上下文(只写注解不写xml用这个)
    private static ApplicationContext applicationContext =  new AnnotationConfigApplicationContext("com.jiuyun");

    public static void main(String[] args){
        demo1();
    }

    private static void demo1() {
        StudentDAO studentDao = (StudentDAO) applicationContext.getBean("studentDAO");
        studentDao.dao();
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        studentService.book();
    }


}
