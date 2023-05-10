package com.jiuyun.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

@Repository //注解@Repository ：Classpath扫描与组件管理，持久层注解，表示这个类不用new获得对象，因为它已经交由容器管理
public class CatDao {
    private static final Logger log = LoggerFactory.getLogger(CatDao.class);

    public void save(){
        log.info("CatDao.save()");
    }
}
