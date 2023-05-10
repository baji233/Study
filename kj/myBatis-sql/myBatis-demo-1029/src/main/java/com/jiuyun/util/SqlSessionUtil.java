package com.jiuyun.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author cj
 * @create 2022年10月29日 09:14:12
 */
public class SqlSessionUtil {
    private static SqlSessionFactory factory;

    static {
        try {
            factory = new SqlSessionFactoryBuilder().build(new FileReader(SqlSessionUtil.class.getClassLoader().getResource("mybatis-config.xml").getPath()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSqlSession() {
        //打开自动提交
        return factory.openSession(true);
    }

    public static Object getMapper(Class clazz) {
        return getSqlSession().getMapper(clazz);
    }
}


