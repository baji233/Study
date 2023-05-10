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
	//根据ID删除购物车
	public int deleteById(Integer cartId) {
		return cd.deleteById(cartId);
	}
	
	//添加购物车的操作
	public  void addCart(Cart c) {
		Cart item=cd.findByUserIdShopId(c.getcUserId(),c.getcShopId());
		//如果通过用户ID和商品ID在购物车表里没查到信息，就新增一条购物车。。。。
		if(item==null) {
			cd.addCart(c);
		}else {
			//否则，用购物车原来的数量加1
			cd.updateNumberByCartId(item.getCartId(),item.getNumber()+1);
		}
		
	}
}
