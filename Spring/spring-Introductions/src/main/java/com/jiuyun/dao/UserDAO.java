package com.jiuyun.dao;

import com.jiuyun.bean.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author cj
 * @create 2022年11月23日 18:44:29
 */
@Slf4j
@Repository
public class UserDAO {

    public void save() {
        log.info("保存用户");
    }

    public void update() {
        log.info("修改用户");
    }

    public void selectByParams() {
        log.info("查询用户");
    }
}
