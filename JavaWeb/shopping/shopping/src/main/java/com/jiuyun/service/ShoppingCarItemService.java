package com.jiuyun.service;

import com.jiuyun.bean.ShoppingCarItem;
import com.jiuyun.vo.ShoppingCarItemVO;

import java.util.List;

/**
 * @author cj
 * @create 2022年10月15日 19:29:00
 */
public interface ShoppingCarItemService {
    boolean save(ShoppingCarItem shoppingCarItem);
    boolean delete(Integer userId, Integer productId);
    boolean clearShoppingCar(Integer userId);
    boolean update(ShoppingCarItem shoppingCarItem);
    List<ShoppingCarItemVO> selectAllByUserId(Integer userId);
}
