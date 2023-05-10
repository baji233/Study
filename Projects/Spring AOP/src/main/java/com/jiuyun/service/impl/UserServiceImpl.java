package com.jiuyun.service.impl;

import com.jiuyun.dao.UserDAO;
import com.jiuyun.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.SQLException;

@Slf4j
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    public void save() {
        userDAO.save();
    }

    public void update() throws SQLException {
        userDAO.update();
    }
}
