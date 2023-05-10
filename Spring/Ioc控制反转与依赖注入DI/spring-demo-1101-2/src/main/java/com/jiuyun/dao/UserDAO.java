package com.jiuyun.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author cj
 * @create 2022年11月01日 19:05:40
 */
@Repository
public class UserDAO extends BaseDAO {
    private static final Logger log = LoggerFactory.getLogger(UserDAO.class);

    public void save() {
        log.info("this is UserDAO.save() method!");
    }
}
