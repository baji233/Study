package com.jiuyun.system.model;

import com.jiuyun.system.util.CommonDao;
import com.jiuyun.system.vo.ReTypeInfoVO;

import java.util.List;

public class ReaderTypeDao {

    //通用的查询
    public static List<ReTypeInfoVO> queryReType(){
        String sql="select * from readertype";
        List<ReTypeInfoVO> list = CommonDao.queryTable(sql, ReTypeInfoVO.class, "readertype.properties", null);
        return list;
    }

    public static boolean insertReType(ReTypeInfoVO tmpReType){
        String sql="insert into readertype(retypeid,readergrade,borrowquantity,borrowtime,validtime) values(?,?,?,?,?)";
        Object[] params=new Object[]{tmpReType.getReTypeId(),tmpReType.getReTypename(),tmpReType.getMaxBook(),
        tmpReType.getBorrowTime(),tmpReType.getValidTime()};
        return CommonDao.updateTable(sql,params);
    }
}
