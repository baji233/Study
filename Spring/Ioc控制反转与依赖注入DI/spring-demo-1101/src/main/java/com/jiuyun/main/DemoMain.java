package com.jiuyun.main;

import com.jiuyun.dao.StudentDAO;
import com.jiuyun.service.StudentService;
import com.jiuyun.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;

/**
 * @author cj
 * @create 2022年11月01日 15:06:27
 */
public class DemoMain {
    private static final Logger log = LoggerFactory.getLogger(DemoMain.class);

    public static void main(String[] args) throws IOException {
        demo6();
    }

    private static void demo6() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Resource resource = applicationContext.getResource("file:d://JavaScript考试卷2.pdf");
        log.info("文件名：" + resource.getFilename());
    }

    private static void demo5() throws IOException {
//        DemoMain.class.getClassLoader().getResource("db.properties").getPath();

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Resource resource = applicationContext.getResource("db.properties");
        log.info("文件名：" + resource.getFilename());
        log.info("文件大小：" + resource.contentLength());
    }

    private static void demo4() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) applicationContext.getBean("userService");
        userService.save();
    }

    private static void demo3() {
        ApplicationContext applicationContext = new FileSystemXmlApplicationContext("d://applicationContext.xml");
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        studentService.save();
    }

    private static void demo2() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = (StudentService) applicationContext.getBean("studentService");
        studentService.save();
    }

    private static void demo1() {
        //创建Spring容器，同时加载配置文件
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //从容器中根据ID获取bean对象
        StudentDAO studentDAO = (StudentDAO) applicationContext.getBean("studentDAO");
        studentDAO.save();
    }
}
