package com.jiuyun.dao;

import com.jiuyun.bean.Student;
import com.jiuyun.bean.User;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author cj
 * @create 2022年10月26日 19:52:51
 */
public class BaseDAOTest {

    private BaseDAO baseDAO;

    @Before
    public void before() {
        baseDAO = new BaseDAO();
    }

    @Test
    public void save() {
        try {
            baseDAO.save(new Student(315, "tom", "计算机","男",18, "南昌"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void selectById() {
        try {
            assertNotNull(baseDAO.selectById(new User(1, null, null, null)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}