package com.jiuyun.system.model;

import java.util.List;

import com.jiuyun.system.vo.BorrowInfoVO;
import com.jiuyun.system.vo.ReaderInfoVO1;


public class ReaderDao {
	public static List<ReaderInfoVO1> queryAllReader()
	{
		
		String sql="select readerid,name,sex,age,birthday from readerinfotable";
		List<ReaderInfoVO1> lstReaders=CommonDao.queryInfo(sql, ReaderInfoVO1.class,"ReaderInfoVO.properties", null);
		return lstReaders;
	}
	public static void main(String[] args) {
		for (ReaderInfoVO1 string : queryAllReader()) {
			System.out.println(string);
		}
	}
}
