package com.jiuyun.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author cj
 * @create 2022年11月24日 20:22:08
 */
@Slf4j
@Repository
public class StudentDAO {
    public void save() {
        log.info("this is StudentDAO.save() method!");
    }
}

