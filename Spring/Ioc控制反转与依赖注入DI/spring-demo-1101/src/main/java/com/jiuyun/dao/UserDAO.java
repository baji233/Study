package com.jiuyun.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author cj
 * @create 2022年11月01日 18:07:18
 */
public class UserDAO {
    private static final Logger log = LoggerFactory.getLogger(UserDAO.class);

    public void save() {
        log.info("this is UserDAO.save() method!");
    }
}
