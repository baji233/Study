package com.jiuyun.dao;

import com.jiuyun.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author cj
 * @create 2022年11月23日 20:32:31
 */
@Slf4j
@Repository
public class UserDAO {
    public void save(User user) {
        log.info("保存的用户信息：" + user);
    }
    public void update(User user) {
        log.info("修改的用户信息：" + user);
    }

}
