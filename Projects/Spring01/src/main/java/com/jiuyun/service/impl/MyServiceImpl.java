package com.jiuyun.service.impl;

import com.jiuyun.dao.MyDao;
import com.jiuyun.service.MyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyServiceImpl implements MyService {
    private static final Logger log = LoggerFactory.getLogger(MyServiceImpl.class);

    private MyDao myDao;

    public void setMyDao(MyDao myDao){
        this.myDao = myDao;
    }

    public void test() {
        log.info("MyServiceImpl.test()");
        myDao.myTest();
    }


}
