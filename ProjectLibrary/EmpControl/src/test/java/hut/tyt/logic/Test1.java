package hut.tyt.logic;


import hut.tyt.mapper.EmployeeMapper;
import hut.tyt.mapper.InformationMapper;
import hut.tyt.pojo.Information;
import hut.tyt.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReference;
import java.util.regex.Matcher;

/**
 * @author 小飞侠 ysrazxy@foxmail.com
 * @version 1.0 JDK 13.0.1
 * @BelongsProject: EmpControl
 * @BelongsPackage: hut.tyt.logic
 * @CreateTime: 2022-07-30  17:38
 * @Description: TODO
 */
public class Test1 {
    @Test
    public void test1(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        long l = mapper.countByExample(null);
        System.out.println(l);
    }

    @Test
    public void test2(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        InformationMapper mapper = sqlSession.getMapper(InformationMapper.class);
        Information information = mapper.selectByPrimaryKey(1);
        System.out.println(information.getNumber()+"####"+information.getPassword());
    }
}
