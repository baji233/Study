package com.jiuyun.service;

import com.jiuyun.bean.Type;
import com.jiuyun.dao.TypeDao;
import com.jiuyun.service.interf.TypeService;

import java.util.List;

public class TypeServiceImpl implements TypeService {
    private TypeDao typeDao;

    @Override
    public boolean save(Type type) {
        typeDao=new TypeDao();
        return typeDao.save(type);
    }

    @Override
    public boolean delete(Integer typeId) {
        typeDao=new TypeDao();
        return typeDao.delete(typeId);
    }

    @Override
    public boolean update(Type type) {
        typeDao=new TypeDao();
        return typeDao.update(type);
    }

    @Override
    public List<Type> selectAll() {
        typeDao=new TypeDao();
        return typeDao.selectAll();
    }

    @Override
    public List<Type> selectById(Integer type_id) {
        typeDao=new TypeDao();
        return typeDao.selectById(type_id);
    }
}
