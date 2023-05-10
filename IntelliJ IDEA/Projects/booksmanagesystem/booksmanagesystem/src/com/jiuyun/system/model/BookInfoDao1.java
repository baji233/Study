package com.jiuyun.system.model;

import java.util.List;

import com.jiuyun.system.vo.BookInfoVO;

public class BookInfoDao1 {
	public static List<BookInfoVO> queryAllBookInfo() {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM book";
		List<BookInfoVO>listBook =CommonDao.queryInfo(sql, BookInfoVO.class,"BookInfoVO.properties", null);
		return listBook;
	}
	public static void main(String[] args) {
//		System.out.println("1");
//		for (BookInfoVO string : queryAllBookInfo()) {
//			System.out.println(string);
//		}
	}
}
