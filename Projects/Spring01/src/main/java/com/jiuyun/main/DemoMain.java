package com.jiuyun.main;

import com.jiuyun.dao.*;
import com.jiuyun.service.CatService;
import com.jiuyun.service.MyService;
import com.jiuyun.service.StudentService;
import com.jiuyun.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;


public class DemoMain {
    private static final Logger log = LoggerFactory.getLogger(DemoMain.class);

    public static void main(String[] args){
        demo8();
    }

    private static void demo8() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        DogDao dogDao = (DogDao) applicationContext.getBean("dogDao");
        dogDao.wang();
    }

    private static void demo7() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        CatDao catDao = (CatDao) applicationContext.getBean("catDao");
        catDao.save();
        CatService catService = (CatService) applicationContext.getBean("catService");
        catService.miao();
    }

    private static void demo6() {
        //获取资源文件的接口Resource
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Resource resource1 = applicationContext.getResource("db.properties");
        log.info(resource1.getFilename());
        //String转成Resource的策略file:文件 http:网址
        Resource resource2 = applicationContext.getResource("file:d://Baby");
        try {
            log.info("Baby文件大小："+String.valueOf(resource2.contentLength()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void demo5() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyDao myDao = (MyDao) applicationContext.getBean("myDao");
        myDao.myTest();
        MyService myService = (MyService) applicationContext.getBean("myService");
        myDao.myTest();
        MyDao myDao1 = MyDao.getInstance();
        myDao.myTest();
    }


    private static void demo4() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao userDao = (UserDao) applicationContext.getBean("userDao");
        userDao.delete();;
    }
    private static void demo3() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
    }


    private static void demo2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        studentService.save();
    }
    private static void demo1() {
        //创建Spring容器，同时加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从容器中根据beanId获取bean对象
        StudentDao studentDao = (StudentDao)applicationContext.getBean("studentDao");
        studentDao.save();
    }


}
