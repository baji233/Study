package com.jiuyun.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyDao {
    private static final Logger log = LoggerFactory.getLogger(MyDao.class);

    //声明一个私有静态的MyDao引用
    private static MyDao myDao;
    private MyDao() {
        //私有化他的构造方法
    }
    public static MyDao getInstance(){
        //使用饿汉式单例设计模式
        if(myDao == null){
            myDao = new MyDao();
        }
        return myDao;
    }

    public void myTest(){
        log.info("MyDao.myTest()");
    }

    private void init(){
        log.info("初始化bean");
    }
    private void dest(){
        log.info("销毁bean");
    }
}
