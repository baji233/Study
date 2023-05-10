package com.jiuyun.config;

import com.jiuyun.dao.UserDAO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author cj
 * @create 2022年11月01日 19:07:06
 *
 */
//@Configuration  //配置注解，该类成为配置类
public class AppConfig {
    @Bean
    public Object userDAO() {
        return new UserDAO();
    }
}
