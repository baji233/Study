package com.jiuyun.service;

import com.jiuyun.bean.Student;

/**
 * @author cj
 * @create 2022年10月26日 20:38:10
 */
public interface StudentService {
    boolean save(Student student) throws Exception;
    boolean delete(Integer stuId) throws Exception;
}
