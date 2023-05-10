package com.jiuyun.service;

import com.jiuyun.bean.Product;
import com.jiuyun.bean.ShoppingCarItem;
import com.jiuyun.dao.ProductDao;
import com.jiuyun.dao.ShoppingCarItemDao;
import com.jiuyun.service.interf.ShoppingCarItemService;
import com.jiuyun.vo.ShoppingCarItemVO;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCarItemServiceImpl implements ShoppingCarItemService {
    private ShoppingCarItemDao shoppingCarItemDao=new ShoppingCarItemDao();
    @Override
    public boolean save(ShoppingCarItem shoppingCarItem) {
        return shoppingCarItemDao.save(shoppingCarItem);
    }

    @Override
    public boolean deleteCarItem(ShoppingCarItem shoppingCarItem) {
        return shoppingCarItemDao.deleteCarItem(shoppingCarItem);
    }

    @Override
    public boolean deleteCar(Integer userId) {
        return shoppingCarItemDao.deleteCar(userId);
    }

    @Override
    public boolean update(ShoppingCarItem shoppingCarItem) {
        return shoppingCarItemDao.update(shoppingCarItem);
    }

    /**
     * BO-->VO
     * @param userId
     * @return
     */
    @Override
    public List<ShoppingCarItemVO> selectAllById(Integer userId) {
        ProductDao productDao=new ProductDao();
        List<ShoppingCarItemVO> sciVOList=new ArrayList();
        Product product=null;
        List<ShoppingCarItem> sciList = shoppingCarItemDao.selectAllById(userId); //TODO: sciList.size() == 0
        //根据购物车项中的
        for(ShoppingCarItem sci : sciList){
            List<Product> byProductId=productDao.selectById(sci.getProduct_id());
            for(Product p : byProductId){
                product=new Product(p.getProduct_id(),p.getProduct_name(),p.getType_id(),p.getDescription(),p.getPrice(),p.getPicture(),p.getState(),p.getRemark());
            }
            sciVOList.add(new ShoppingCarItemVO(sci,product));
        }
        return sciVOList;
    }
}




















