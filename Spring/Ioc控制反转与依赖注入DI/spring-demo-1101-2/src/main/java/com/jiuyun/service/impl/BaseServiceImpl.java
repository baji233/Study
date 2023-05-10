package com.jiuyun.service.impl;

import com.jiuyun.dao.BaseDAO;
import com.jiuyun.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author cj
 * @create 2022年11月01日 19:37:03
 */
@Service("baseService")
public class BaseServiceImpl implements BaseService {
    @Autowired
    @Qualifier("userDAO")
    private BaseDAO baseDAO;

    public void save() {
        baseDAO.save();
    }
}
