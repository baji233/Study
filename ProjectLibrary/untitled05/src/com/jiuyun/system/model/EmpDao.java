package com.jiuyun.system.model;

import com.jiuyun.system.util.CommonDao;
import com.jiuyun.system.vo.EmpInfo;

import java.util.List;

public class EmpDao {
    //��ѯ���й�Ա��Ϣ
    public static List<EmpInfo> queryAllEmp(){
        String sql="select a.empName,a.pay,a.job,a.birthday,b.deptId from empinfo a,deptinfo b where a.deptId=b.deptId";
        List<EmpInfo> lstEmps= CommonDao.queryInfo(sql, EmpInfo.class,null);
        return lstEmps;
    }

    //ͨ����Աid��ɾ����
    public static boolean deleteEmpById(String empId){
        String sql="delete from empinfo where empId=?";
        Object[] param= {Integer.parseInt(empId)};//���ַ�����������Ϊ�з���ʮ��������
        return CommonDao.operMoper(sql,param);
    }

    //�����Ա��Ϣ
    public static boolean saveEmpInfo(EmpInfo vo){
        String sql="insert into empinfo values (?,?,?,?,?,?)";
        Object[] param={Integer.parseInt(vo.getEmpId()),vo.getEmpName(),Float.parseFloat(vo.getPay()),vo.getJob(),vo.getBirthday(),Integer.parseInt(vo.getDeptId())};
        return CommonDao.operMoper(sql,param);
    }
}





















