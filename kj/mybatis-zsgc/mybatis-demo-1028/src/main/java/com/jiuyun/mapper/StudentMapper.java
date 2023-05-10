package com.jiuyun.mapper;

import com.jiuyun.bean.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author cj
 * @create 2022年10月28日 15:04:40
 */
public interface StudentMapper {
    List<Student> selectAll();
    Student selectById(Integer stuId);
    List<Student> selectSortByColumnName(@Param("columnName") String columnName);
    List<Student> selectByColumnName(@Param("columnName")String columnName,@Param("value")Object value);
    List<Student> selectByName(@Param("stuName") String stuName);
    void save(Student student);
    void batchSave(@Param("students") List<Student> students);
    void delete(Integer stuId);
    void update(Student student);
}
