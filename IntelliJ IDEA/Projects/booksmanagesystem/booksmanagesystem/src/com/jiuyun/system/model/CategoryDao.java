package com.jiuyun.system.model;

import java.util.List;

import com.jiuyun.system.vo.BookInfoVo0;
import com.jiuyun.system.vo.CategoryInfoVo;

public class CategoryDao {
	public static List queryAllCategory()
	{
		String sql="SELECT * FROM category;";
		List lstCategory=CommonDao.queryInfo(sql,CategoryInfoVo.class,"bookinfo.properties",null);
		return lstCategory;
	}
	
	public static void main(String[] args) {
		System.out.println(queryAllCategory());
	}
}
