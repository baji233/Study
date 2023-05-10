package com.jiuyun.service.interf;

import com.jiuyun.bean.ShoppingCarItem;
import com.jiuyun.vo.ShoppingCarItemVO;

import java.util.List;

public interface ShoppingCarItemService {
    boolean save(ShoppingCarItem shoppingCarItem);
    boolean deleteCarItem(ShoppingCarItem shoppingCarItem);
    boolean deleteCar(Integer userId);
    boolean update(ShoppingCarItem shoppingCarItem);
    List<ShoppingCarItemVO> selectAllById(Integer userId);
}
