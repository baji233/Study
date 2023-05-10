package com.jiuyun.mapper;

import com.jiuyun.bean.Student;
import com.jiuyun.util.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author cj
 * @create 2022年10月28日 15:09:44
 */
public class StudentMapperTest {
    private static final Logger log = LoggerFactory.getLogger(StudentMapperTest.class);
    private StudentMapper studentMapper;
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

    @Before
    public void before() {
        studentMapper = SqlSessionUtil.getSqlSession().getMapper(StudentMapper.class);
    }

    @Test
    public void testSelectAll() {
        log.info("查询结果：" + studentMapper.selectAll());
    }

    @Test
    public void selectById() {
        log.info("查询结果：" + studentMapper.selectById(1));
    }

    @Test
    public void save() {
        Student student = new Student(null, "雷神","计算机","男",38, "基尼福尼亚");
        log.info("保存前的学员信息：" + student);
        studentMapper.save(student);
        log.info("保存后的学员信息：" + student);
    }

    @Test
    public void batchSave() {
        List<Student> studentList = getStudentList();
        log.info("插入前的数据：" + studentList);
        studentMapper.batchSave(studentList);
        log.info("插入后的数据：" + studentList);
    }

    @Test
    public void selectSortByColumnName() {
        List<Student> studentList = studentMapper.selectSortByColumnName("major");
        log.info("查询结果：" + studentList);
    }

    @Test
    public void selectByColumnName() {
        List<Student> studentList = studentMapper.selectByColumnName("age", "18");
        log.info("查询结果：" + studentList);
    }

    @Test
    public void selectByName() {
        List<Student> studentList = studentMapper.selectByName("a");
        log.info("查询结果：" + studentList);
    }


    private List<Student> getStudentList() {
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student( null, "jack", "计算机", "男", 19, "长沙"));
        studentList.add(new Student( null, "lacy", "计算机", "女", 19, "长沙"));
        studentList.add(new Student( null, "mark", "计算机", "男", 19, "长沙"));
        studentList.add(new Student( null, "marry", "计算机", "女", 19, "长沙"));
        studentList.add(new Student( null, "tom", "计算机", "男", 19, "长沙"));
        return studentList;
    }




}