package com.jiuyun.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author cj
 * @create 2022年11月01日 18:45:05
 */
//@Component
@Repository
public class StudentDAO extends BaseDAO {
    private static final Logger log = LoggerFactory.getLogger(StudentDAO.class);

    public void save() {
        log.info("this is StudentDAO.save() method!");
    }
}
