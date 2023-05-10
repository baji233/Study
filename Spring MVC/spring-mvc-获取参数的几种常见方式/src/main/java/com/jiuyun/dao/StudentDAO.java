package com.jiuyun.dao;

import com.jiuyun.bean.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

/**
 * @author cj
 * @create 2022年11月25日 18:58:51
 */
@Slf4j
@Repository
public class StudentDAO {
    public void save(Student student) {
        log.info("保存的学员信息为：" + student);
    }
}
