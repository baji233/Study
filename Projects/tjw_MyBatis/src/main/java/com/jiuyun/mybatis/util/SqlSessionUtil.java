package com.jiuyun.mybatis.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {

    private static SqlSessionFactory factory;
    static {
        //获取核心配置文件的真实路径
        String path = SqlSessionFactory.class.getClassLoader().getResource("tjw_mybatis-config.xml").getPath();
        try {
            factory = new SqlSessionFactoryBuilder().build(new FileReader(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getFactory() {
        return factory.openSession(true);
    }


    public static SqlSession getSqlSession(){
        InputStream resourceAsStream = null;
        try {
            resourceAsStream = Resources.getResourceAsStream("tjw_mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
        }
        SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
        SqlSession sqlSession = build.openSession();
        return sqlSession;
    }
}
