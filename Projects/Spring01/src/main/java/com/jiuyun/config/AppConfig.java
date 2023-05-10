package com.jiuyun.config;

import com.jiuyun.dao.DogDao;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration //配置项：初始化容器,可以把这个类当作applicationContext.xml(适合引入第三方)
public class AppConfig {
    @Bean //相当于bean标签
    public Object dogDao(){
        return new DogDao();
    }
}
