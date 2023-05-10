package service;

import java.util.List;

import dao.CartDao;
import dao.ShopDao;
import entity.Cart;

public class CartService {
	CartDao cd=new CartDao();
	ShopDao sd=new ShopDao();
	
	//查询当前登录用户的购物车信息
	public List findByUserId(Integer userId) {
	
		return cd.findByUserId(userId);
	}

}
