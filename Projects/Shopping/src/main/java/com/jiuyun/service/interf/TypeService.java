package com.jiuyun.service.interf;

import com.jiuyun.bean.Type;

import java.util.List;

public interface TypeService {

    boolean typeAdd(String typeName);
    boolean typeDelete(Integer typeId);
    boolean typeUpdate(Type type);
    List<Type> selectAll();
    List<Type> selectById(Integer typeId);

}
