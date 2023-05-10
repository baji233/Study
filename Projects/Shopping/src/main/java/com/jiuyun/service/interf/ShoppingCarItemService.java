package com.jiuyun.service.interf;

import com.jiuyun.bean.ShoppingCarItem;

import java.util.List;

public interface ShoppingCarItemService {

    boolean shoppingCarItemAdd(ShoppingCarItem shoppingCarItem);
    boolean shoppingCarItemDelete(Integer userId, Integer productId);
    boolean clearShoppingCar(Integer userId);
    boolean shoppingCarItemUpdate(ShoppingCarItem shoppingCarItem);
    List<ShoppingCarItem> selectAllByUserId(Integer userId);


}
