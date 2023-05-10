package com.jiuyun.service.impl;

import com.jiuyun.bean.Type;
import com.jiuyun.dao.TypeDAO;
import com.jiuyun.service.TypeService;

import java.util.List;

/**
 * @author cj
 * @create 2022年10月15日 19:43:14
 */
public class TypeServiceImpl implements TypeService {
    private TypeDAO typeDAO;

    @Override
    public boolean save(Type type) {
        typeDAO = new TypeDAO();
        return typeDAO.save(type);
    }

    @Override
    public boolean delete(Integer typeId) {
        typeDAO = new TypeDAO();
        return typeDAO.delete(typeId);
    }

    @Override
    public boolean update(Type type) {
        typeDAO = new TypeDAO();
        return typeDAO.update(type);
    }

    @Override
    public Type selectById(Integer typeId) {
        typeDAO = new TypeDAO();
        return typeDAO.selectById(typeId);
    }

    @Override
    public List<Type> selectAll() {
        typeDAO = new TypeDAO();
        return typeDAO.selectAll();
    }
}
