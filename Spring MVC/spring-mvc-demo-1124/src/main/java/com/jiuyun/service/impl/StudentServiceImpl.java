package com.jiuyun.service.impl;

import com.jiuyun.dao.StudentDAO;
import com.jiuyun.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author cj
 * @create 2022年11月24日 20:23:39
 */
@Slf4j
@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDAO studentDAO;

    @Override
    public void save() {
        studentDAO.save();
    }
}
