package com.jiuyun.mapper;

import com.jiuyun.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cj
 * @create 2022年10月29日 09:19:07
 */
public interface StudentMapper {
    List<Student> selectAll();
    List<Student> selectByIds(@Param("ids") List<Integer> ids);
    List<Student> selectByParams(Student params);
    void update(Student student);
}
