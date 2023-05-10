package com.jiuyun.service.impl;

import com.jiuyun.bean.ShoppingCarItem;
import com.jiuyun.dao.ProductDAO;
import com.jiuyun.dao.ShoppingCarItemDAO;
import com.jiuyun.service.ShoppingCarItemService;
import com.jiuyun.vo.ShoppingCarItemVO;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cj
 * @create 2022年10月15日 19:31:13
 */
public class ShoppingCarItemServiceImpl implements ShoppingCarItemService {
    private ShoppingCarItemDAO shoppingCarItemDAO;
    private ProductDAO productDAO;

    @Override
    public boolean save(ShoppingCarItem shoppingCarItem) {
        shoppingCarItemDAO = new ShoppingCarItemDAO();
        return shoppingCarItemDAO.save(shoppingCarItem);
    }

    @Override
    public boolean delete(Integer userId, Integer productId) {
        shoppingCarItemDAO = new ShoppingCarItemDAO();
        return shoppingCarItemDAO.delete(userId, productId);
    }

    @Override
    public boolean clearShoppingCar(Integer userId) {
        shoppingCarItemDAO = new ShoppingCarItemDAO();
        return shoppingCarItemDAO.clearShoppingCar(userId);
    }

    @Override
    public boolean update(ShoppingCarItem shoppingCarItem) {
        shoppingCarItemDAO = new ShoppingCarItemDAO();
        return shoppingCarItemDAO.update(shoppingCarItem);
    }

    @Override
    public List<ShoppingCarItemVO> selectAllByUserId(Integer userId) {
        shoppingCarItemDAO = new ShoppingCarItemDAO();
        productDAO = new ProductDAO();
        List<ShoppingCarItem> shoppingCarItemList = shoppingCarItemDAO.selectAllByUserId(userId);
        List<ShoppingCarItemVO> shoppingCarItemVOList = new ArrayList<>();
        for (ShoppingCarItem item : shoppingCarItemList) {
            shoppingCarItemVOList.add(new ShoppingCarItemVO(item, productDAO.selectById(item.getProductId())));
        }
        return shoppingCarItemVOList;
    }
}









