package com.jiuyun.system.model;

import java.util.List;

import com.jiuyun.system.vo.BorrowInfoVO;

public class BorrowInfoDao {
	public static List<BorrowInfoVO> queryAllBorrowInfo() {
		// TODO Auto-generated method stub
		String sql = "SELECT readerinfotable.readerid,readerinfotable.name,readerinfotable.sex,book.bookid,book.bookname,book.publish,book.price,borrowinfo.outoftime,borrowinfo.shouldreturndate,borrowinfo.returnstate,borrowinfo.returntime,borrowinfo.`comment`,borrowinfo.borrowid FROM book ,readerinfotable ,borrowinfo  WHERE book.bookid=borrowinfo.bookid AND readerinfotable.readerid=borrowinfo.readerid";
		List<BorrowInfoVO>listBorrow =CommonDao.queryInfo(sql, BorrowInfoVO.class,"BorrowInfoVO.properties",null);
		return listBorrow;
	}
	public static void main(String[] args) {
//		System.out.println("1");
//		for (BorrowInfoVO string : queryAllBorrowInfo()) {
//			System.out.println(string);
//		}
	}
}
