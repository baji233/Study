package com.jy.service;

import com.jy.entity.Menu;
import com.jy.entity.User;

import java.util.List;

public interface UserService {
    public List login(String username, String password);
    public List<Menu> findMenu(Integer roleId);

}
