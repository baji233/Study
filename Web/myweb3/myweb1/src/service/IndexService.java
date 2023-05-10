package service;

import java.util.HashMap;
import java.util.Map;

import dao.ShopDao;

public class IndexService {

	ShopDao sd=new ShopDao();
	//查询首页的所有信息
	public Map findIndex() {
		Map map=new HashMap();
		map.put("shops", sd.findShopSyt());//首页推荐的商品
		map.put("types",sd.findTypeSyt());//首页推荐的分类
		return map;
	}
}
