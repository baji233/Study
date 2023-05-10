package com.jiuyun.mapper;

import com.jiuyun.bean.Company;

/**
 * @author cj
 * @create 2022年10月29日 10:46:48
 */
public interface CompanyMapper {
    Company selectById(Integer companyId);
}
