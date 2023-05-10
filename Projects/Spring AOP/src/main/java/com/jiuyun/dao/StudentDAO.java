package com.jiuyun.dao;

import com.jiuyun.bean.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

@Repository
@Slf4j
public class StudentDAO {
    public void save(Student student){
        log.info("正在保存学生信息：" + student);
    }

    public void update(Student student){
        log.info("正在更新学生信息：" + student);
    }
}
