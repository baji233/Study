package com.jiuyun.mapper;

import com.jiuyun.bean.Student;
import com.jiuyun.util.SqlSessionUtil;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author cj
 * @create 2022年10月29日 09:23:47
 */
public class StudentMapperTest {
    private static final Logger log = LoggerFactory.getLogger(StudentMapperTest.class);
    private StudentMapper studentMapper;

    @Before
    public void before() {
        studentMapper = (StudentMapper) SqlSessionUtil.getMapper(StudentMapper.class);
    }

    @Test
    public void selectAll() {
        log.info("查询结果：" + studentMapper.selectAll());
    }

    @Test
    public void selectByParams() {
        log.info("查询结果：" + studentMapper.selectByParams(new Student(null, null, null, null, null, null)));
    }

    @Test
    public void update() {
        studentMapper.update(new Student(321, "tony", "美发", null, 17, null));
    }

    @Test
    public void selectByIds() {
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(10);
        ids.add(11);
        ids.add(15);
        ids.add(16);
        ids.add(20);
        studentMapper.selectByIds(ids);
    }
}