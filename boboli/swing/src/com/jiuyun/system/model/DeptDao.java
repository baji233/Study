package com.jiuyun.system.model;

import java.util.ArrayList;
import java.util.List;

import com.jiuyun.system.util.CommonDao;
import com.jiuyun.system.vo.DeptInfoVO;

/**
 * ����deptinfo��
 * @author boboli
 *
 */
public class DeptDao {

	public static List<DeptInfoVO> queryAllDept()
	{
		
		String sql="select * from deptinfo";
		List lstDepts=CommonDao.queryInfo(sql, DeptInfoVO.class,null);
		return lstDepts;
	}
}
