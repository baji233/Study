package com.jiuyun.service;

import com.jiuyun.bean.Type;

import java.util.List;

/**
 * @author cj
 * @create 2022年10月15日 19:41:48
 */
public interface TypeService {
    boolean save(Type type);
    boolean delete(Integer typeId);
    boolean update(Type type);
    Type selectById(Integer typeId);
    List<Type> selectAll();
}
