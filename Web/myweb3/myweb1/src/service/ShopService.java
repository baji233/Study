package service;

import dao.ShopDao;
import entity.Shop;

public class ShopService {
	ShopDao sd=new ShopDao();
	
	public Shop findShopById(int shopId) {
		return sd.findShopById(shopId);
	}
		
}
