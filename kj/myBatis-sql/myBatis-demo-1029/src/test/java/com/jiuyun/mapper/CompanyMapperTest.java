package com.jiuyun.mapper;

import com.jiuyun.bean.Company;
import com.jiuyun.util.SqlSessionUtil;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;

/**
 * @author cj
 * @create 2022年10月29日 10:51:36
 */
public class CompanyMapperTest {
    private static final Logger log = LoggerFactory.getLogger(CompanyMapperTest.class);
    private CompanyMapper companyMapper;

    @Before
    public void before() {
        companyMapper = (CompanyMapper) SqlSessionUtil.getMapper(CompanyMapper.class);
    }

    @Test
    public void selectById() {
        log.info("查询结果：" + companyMapper.selectById(1));
    }
}