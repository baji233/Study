package com.jiuyun.system.model;

import java.util.List;

import com.jiuyun.system.util.CommonDao;
import com.jiuyun.system.vo.EmpinfoVO;

/**
 * 操作empinfo表
 *
 */
public class EmpInfoDao {

	public static List<EmpinfoVO> queryAllEmp()
	{
		String sql="select a.empno,a.ename,a.sal,a.job,a.bithday,b.deptname from empinfo a,deptinfo b where a.deptno=b.deptno";
		List<EmpinfoVO> lstEmps=CommonDao.queryInfo(sql,EmpinfoVO.class,null);
		return lstEmps;
	}
	
	public static boolean deleteEmpByID(String empno)
	{
		String sql="delete from empinfo where empno=?";
		Object []params={Integer.parseInt(empno)};
		return CommonDao.operModify(sql, params);
	}
	//保存雇员信息
	public static boolean saveEmpInfo(EmpinfoVO emp)
	{
		String sql="insert into empinfo values(?,?,?,?,?,?)";
		Object []params={Integer.parseInt(emp.getEmpNo()),emp.getEname(),Float.parseFloat(emp.getSalary()),emp.getJob(),emp.getBirthday(),Integer.parseInt(emp.getDname())};
		return CommonDao.operModify(sql, params);
	}
}
