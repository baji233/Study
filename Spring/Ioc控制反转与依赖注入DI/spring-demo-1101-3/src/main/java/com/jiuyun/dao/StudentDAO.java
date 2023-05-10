package com.jiuyun.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author cj
 * @create 2022年11月01日 19:52:12
 */
@Repository
public class StudentDAO {
    private static final Logger log = LoggerFactory.getLogger(StudentDAO.class);

    public void save() {
        log.info("this is StudentDAO.save() method!");
    }
}

