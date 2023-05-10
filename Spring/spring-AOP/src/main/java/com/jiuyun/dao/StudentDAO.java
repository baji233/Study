package com.jiuyun.dao;

import com.jiuyun.bean.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author cj
 * @create 2022年11月22日 18:47:17
 */
@Slf4j
@Repository
public class StudentDAO {
    public void save(Student student) {
        log.info("正在保存的学员信息：" + student);
    }

    public void update(Student student) {
        log.info("正在修改的学员信息：" + student);
    }
}
