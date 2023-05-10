package com.jiuyun.mapper;

import com.jiuyun.bean.Student;

import java.util.List;

/**
 * @author cj
 * @create 2022年10月28日 15:04:40
 */
public interface StudentMapper {
    List<Student> selectAll();
}
