package com.jiuyun.service.impl;

import com.jiuyun.dao.CatDao;
import com.jiuyun.main.DemoMain;
import com.jiuyun.service.CatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("catService") //@Service("catService")：把CatServiceImpl交给容器管理并自定义命名为catService
public class CatServiceImpl implements CatService {
    private static final Logger log = LoggerFactory.getLogger(DemoMain.class);

    @Autowired //自动装配,可省去set方法
    private CatDao catDao;

    @Autowired //自动装配
    public void setCatDao(){
        this.catDao = catDao;
    }

    public void miao() {
        log.info("喵喵喵");
    }
}
