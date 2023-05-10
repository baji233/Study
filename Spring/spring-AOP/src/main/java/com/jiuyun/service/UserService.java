package com.jiuyun.service;

import java.sql.SQLException;

/**
 * @author cj
 * @create 2022年11月22日 19:52:52
 */
public interface UserService {
    void save();
    void update() throws SQLException;
}
