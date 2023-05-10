package com.jiuyun.service;

import com.jiuyun.bean.Type;
import com.jiuyun.dao.TypeDao;
import com.jiuyun.service.interf.TypeService;

import java.util.List;

public class TypeServiceImpl implements TypeService {

    TypeDao typeDao = new TypeDao();

    @Override
    public boolean typeAdd(String typeName) {
        return typeDao.typeAdd(typeName);
    }

    @Override
    public boolean typeDelete(Integer typeId) {
        return typeDao.typeDelete(typeId);
    }

    @Override
    public boolean typeUpdate(Type type) {
        return typeDao.typeUpdate(type);
    }

    @Override
    public List<Type> selectAll() {
        return typeDao.selectAll();
    }

    @Override
    public List<Type> selectById(Integer typeId) {
        return typeDao.selectById(typeId);
    }
}
