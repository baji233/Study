package com.jiuyun.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author cj
 * @create 2022年10月28日 15:33:12
 */
public class SqlSessionUtil {
    private static SqlSessionFactory factory;

    static {
        //获取核心配置文件的真实路径
        String path = SqlSessionUtil.class.getClassLoader().getResource("mybatis-config.xml").getPath();
        try {
            factory = new SqlSessionFactoryBuilder().build(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        return factory.openSession(true);
    }
}
