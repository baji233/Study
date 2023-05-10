package com.jiuyun.dao;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

/**
 * @author cj
 * @create 2022年11月22日 19:54:02
 */
@Slf4j
@Repository
public class UserDAO {
    public void save() {
        log.info("this is UserDAO.save() method!");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void update() throws SQLException {
        log.info("this is UserDAO.update() method!");
        throw new SQLException();
    }
}
