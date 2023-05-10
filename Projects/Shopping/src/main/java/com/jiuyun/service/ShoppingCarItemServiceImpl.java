package com.jiuyun.service;

import com.jiuyun.bean.ShoppingCarItem;
import com.jiuyun.dao.ShoppingCarItemDao;
import com.jiuyun.service.interf.ShoppingCarItemService;

import java.util.List;

public class ShoppingCarItemServiceImpl implements ShoppingCarItemService {

    ShoppingCarItemDao shoppingCarItemDao = new ShoppingCarItemDao();


    @Override
    public boolean shoppingCarItemAdd(ShoppingCarItem shoppingCarItem) {
        return shoppingCarItemDao.shoppingCarItemAdd(shoppingCarItem);
    }

    @Override
    public boolean shoppingCarItemDelete(Integer userId, Integer productId) {
        return shoppingCarItemDao.shoppingCarItemDelete(userId, productId);
    }

    @Override
    public boolean clearShoppingCar(Integer userId) {
        return shoppingCarItemDao.clearShoppingCar(userId);
    }

    @Override
    public boolean shoppingCarItemUpdate(ShoppingCarItem shoppingCarItem) {
        return shoppingCarItemDao.shoppingCarItemUpdate(shoppingCarItem);
    }

    @Override
    public List<ShoppingCarItem> selectAllByUserId(Integer userId) {
        return shoppingCarItemDao.selectAllByUserId(userId);
    }
}
