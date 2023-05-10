package com.jiuyun.service.interf;

import com.jiuyun.bean.Type;

import java.util.List;

public interface TypeService {
    boolean save(Type type);
    boolean delete(Integer typeId);
    boolean update(Type type);
    List<Type> selectAll();
    List<Type> selectById(Integer type_id);
}
