package com.jiuyun.system.model;

import com.jiuyun.system.util.CommonDao;
import com.jiuyun.system.vo.ReaderInfoVO;

import java.util.List;

//
public class ReaderInfoDao {
    public static List<ReaderInfoVO> queryReaderInfo(){
        List<ReaderInfoVO> list=null;
        String sql="select * from readerinfotable";
        list = CommonDao.queryTable(sql, ReaderInfoVO.class, "readerinfo.properties", null);
        return list;
    }

    public static boolean addReaderInfo(ReaderInfoVO vo){
        String sql="insert into readerinfotable values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        Object[] params=new Object[]{vo.getReaderId(),vo.getReTypeId(),vo.getName(),0,vo.getIsBorrow(),vo.getSex(),vo.getAge(),vo.getIdCard(),vo.getPhone(),vo.getE_mail(),vo.getBirth(),vo.getRegisterDate(),"1919-3-4",vo.getWorkLocation(),vo.getDepartment(),vo.getLossState(),"admin"};
        boolean b = CommonDao.updateTable(sql, params);
        return b;
    }

    public static boolean deleteReaderById(String id){
        String sql="delete from readerinfotable where readerid=?";
        Object[] params=new Object[]{id};
        return CommonDao.updateTable(sql,params);
    }

    /**
     *
     * @param tmp  修改后的数据
     * @return 是否成功
     */
    public static boolean updateReaderInfo(ReaderInfoVO tmp){
        String sql="update readerinfotable set name=?,age=?,sex=?,phone=?,e_mail=?," +
                "workunits=?,department=?,borrownumber=?,registratdate=?,birthday=?,reportLossState=?," +
                "idnumber=? where readerid=?";
        Object[] params=new Object[]{tmp.getName(),tmp.getAge(),tmp.getSex(),tmp.getPhone(),
        tmp.getE_mail(),tmp.getWorkLocation(),tmp.getDepartment(),tmp.getBorrowNum(),tmp.getRegisterDate(),
        tmp.getBirth(),tmp.getLossState(),tmp.getIdCard(),tmp.getReaderId()};
        return CommonDao.updateTable(sql,params);
    }
}
