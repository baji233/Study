package com.jiuyun.service.impl;

import com.jiuyun.bean.Student;
import com.jiuyun.dao.StudentDAO;
import com.jiuyun.service.StudentService;

/**
 * @author cj
 * @create 2022年10月26日 20:39:00
 */
public class StudentServiceImpl implements StudentService {
    private StudentDAO studentDAO;

    @Override
    public boolean save(Student student) throws Exception {
        return studentDAO.save(student);
    }

    @Override
    public boolean delete(Integer stuId) throws Exception {
        return studentDAO.delete(new Student(stuId, null, null, null, null, null));
    }
}
