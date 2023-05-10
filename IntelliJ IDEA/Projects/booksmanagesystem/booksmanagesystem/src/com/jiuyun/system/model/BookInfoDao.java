package com.jiuyun.system.model;
import java.util.List;

import com.jiuyun.system.vo.*;

public class BookInfoDao {
	
	public static List queryAllBook()
	{
		String sql="SELECT a.*,b.* FROM book a,category b,bookinfo c WHERE a.bookid=c.bookid AND b.categoryid=c.categoryid;";
		List lstBooks=CommonDao.queryInfo(sql,BookInfoVo0.class,"bookinfo.properties",null);
		return lstBooks;
	}
	
	public static boolean deleteBookByID(String bookid)
	{
		String sql="delete from book where bookid=?";
		Object []params={Integer.parseInt(bookid)};
		return CommonDao.operModify(sql, params);
	}
	
	public static boolean saveBookInfo(BookInfoVo0 bookInfo)
	{
		String sql1="insert into book values(?,?,?,?,?,?)";;
		Object []params={bookInfo.getBName(),bookInfo.getBId(),bookInfo.getAuthor(),bookInfo.getPublish(),bookInfo.getPDate(),bookInfo.getPrice(),bookInfo.getCategoryId(),bookInfo.getCategoryName(),bookInfo.getExplain()};
		return CommonDao.operModify(sql1, params);
	}

}
