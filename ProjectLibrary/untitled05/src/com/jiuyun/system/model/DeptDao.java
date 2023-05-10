package com.jiuyun.system.model;

import com.jiuyun.system.util.CommonDao;
import com.jiuyun.system.vo.DeptInfoVO;

import java.util.List;

/**
 * 操作部门表
 */
public class DeptDao {
    public static List<DeptInfoVO> queryDept(){
        String sql="select * from deptinfo";
        List<DeptInfoVO> listDepts= CommonDao.queryInfo(sql,DeptInfoVO.class,null);
        return listDepts;
    }
}


























