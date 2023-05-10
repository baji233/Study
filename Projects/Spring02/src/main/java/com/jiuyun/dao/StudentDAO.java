package com.jiuyun.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Repository("studentDAO") //Classpath扫描与组件管理
public class StudentDAO {
//    private static final Logger log = LoggerFactory.getLogger(StudentDAO.class);
    private StudentDAO studentDAO;
    private StudentDAO(){}
    public StudentDAO getInstance(){
        if(studentDAO == null){
            studentDAO = new StudentDAO();
        }
        return studentDAO;
    }

    @PostConstruct //初始化方法
    public void initialize(){
        log.info("StudentDAO初始化方法");
    }

    public void dao(){
        log.info("StudentDAO的dao方法");
    }

    @PreDestroy //销毁方法
    public void destroy(){
        log.info("StudentDAO销毁方法");
    }

}
