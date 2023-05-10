package com.jiuyun.vo;

import com.jiuyun.bean.Product;
import com.jiuyun.bean.ShoppingCarItem;

/**
 * @author cj
 * @create 2022年10月18日 15:19:00
 * 购物项的VO（View Object）对象
 */
public class ShoppingCarItemVO {
    private ShoppingCarItem shoppingCarItem;
    private Product product;

    public ShoppingCarItemVO() {
    }

    public ShoppingCarItemVO(ShoppingCarItem shoppingCarItem, Product product) {
        this.shoppingCarItem = shoppingCarItem;
        this.product = product;
    }

    public ShoppingCarItem getShoppingCarItem() {
        return shoppingCarItem;
    }

    public void setShoppingCarItem(ShoppingCarItem shoppingCarItem) {
        this.shoppingCarItem = shoppingCarItem;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ShoppingCarItemVO{" +
                "shoppingCarItem=" + shoppingCarItem +
                ", product=" + product +
                '}';
    }
}
