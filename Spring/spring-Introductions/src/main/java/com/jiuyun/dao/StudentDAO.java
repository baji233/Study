package com.jiuyun.dao;

import com.jiuyun.bean.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author cj
 * @create 2022年11月23日 18:44:29
 */
@Slf4j
@Repository
public class StudentDAO {

    public void save(Student student) {
        log.info("保存的学员信息为：" + student);
    }

    public void update(Student student) {
        log.info("修改的学员信息为：" + student);
    }

    public void selectByParams(Student student) {
        log.info("查询的学员条件为：" + student);
    }
}
