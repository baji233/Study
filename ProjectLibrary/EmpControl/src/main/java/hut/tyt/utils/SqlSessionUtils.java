package hut.tyt.utils;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 小飞侠 ysrazxy@foxmail.com
 * @version JDK 13.0.1
 * @description: TODO
 * @date 2022/5/3 23:55
 */
public class SqlSessionUtils {
    public static SqlSession getSqlSession(){
        SqlSession sqlSession = null;
        try {
            InputStream resourceAsStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory build = new SqlSessionFactoryBuilder().build(resourceAsStream);
            sqlSession = build.openSession(true);


        } catch (IOException e) {
            e.printStackTrace();
        }
        return sqlSession;

    }
}
