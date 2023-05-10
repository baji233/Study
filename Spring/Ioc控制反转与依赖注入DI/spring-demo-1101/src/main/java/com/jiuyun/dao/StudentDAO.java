package com.jiuyun.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author cj
 * @create 2022年11月01日 15:03:37
 */
public class StudentDAO {
    private static final Logger log = LoggerFactory.getLogger(StudentDAO.class);

    public void init() {
        log.info("加载数据库资源！");
    }

    public void save() {
        log.info("this is StudentDAO.save() method!");
    }

    public void destroy() {
        log.info("销毁数据库资源！");
    }
}
