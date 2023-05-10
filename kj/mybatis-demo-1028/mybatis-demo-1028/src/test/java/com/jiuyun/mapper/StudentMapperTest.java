package com.jiuyun.mapper;

import com.jiuyun.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.Assert.*;

/**
 * @author cj
 * @create 2022年10月28日 15:09:44
 */
public class StudentMapperTest {
    private static final Logger log = LoggerFactory.getLogger(StudentMapperTest.class);
    @Test
    public void selectAll() throws FileNotFoundException {
        //创建SQLSession工厂的构建者
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取核心配置文件的真实路径
        String path = StudentMapperTest.class.getClassLoader().getResource("mybatis-config.xml").getPath();
        //创建SqlSession工厂
        SqlSessionFactory factory = sqlSessionFactoryBuilder.build(new FileReader(path));
        //通过工厂获取SQLSession
        SqlSession sqlSession = factory.openSession(true);
        //获取接口
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        //调用接口
        log.info("查询结果：" + studentMapper.selectAll());
    }

    @Test
    public void testSelectAll() {
        StudentMapper studentMapper = SqlSessionUtil.getSqlSession().getMapper(StudentMapper.class);
        log.info("查询结果：" + studentMapper.selectAll());
    }
}