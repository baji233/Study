package com.jy.service.impl;

import com.jy.dao.ProductMapper;
import com.jy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper pm;
        @Override
        public Map findByPage(Integer page, Integer count) {
            Map map=new HashMap();
            map.put("count",pm.countByExample(null));//返回总条数
            map.put("products",pm.findByPage((page-1)*count,count));
            map.put("code",0);

            return map;
    }

    public int deleteById(Integer productid){
       return pm.deleteByPrimaryKey(productid);
    }
}
