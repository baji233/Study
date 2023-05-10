package com.jy.service.impl;

import com.jy.dao.ProductMapper;
import com.jy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper pm;
        @Override
        public List findByPage(Integer page, Integer count) {

            return  pm.findByPage((page-1)*count,count);
    }
}
