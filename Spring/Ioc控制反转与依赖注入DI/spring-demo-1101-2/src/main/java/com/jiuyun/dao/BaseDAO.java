package com.jiuyun.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * @author cj
 * @create 2022年11月01日 19:33:38
 */
@Repository
public class BaseDAO {
    private static final Logger log = LoggerFactory.getLogger(BaseDAO.class);

    public void save() {
        log.info("this is BaseDAO.save() method!");
    }
}
