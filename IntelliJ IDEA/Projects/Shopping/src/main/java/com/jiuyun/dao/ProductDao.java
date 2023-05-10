package com.jiuyun.dao;

import com.jiuyun.bean.Product;
import com.jiuyun.util.CommonDaoUtil;

import java.util.List;

public class ProductDao {

    /**
     * 查询所有商品
     * @return 所有商品的结果集
     */
    public List<Product> selectAllProduct(){
        String sql="select * from t_product";
        List<Product> productList= CommonDaoUtil.query(sql,Product.class,null);
        return productList;
    }

    /**
     * 根据商品id查询该商品详情
     * @param product_id 商品编号
     * @return 相关商品结果集
     */
    public List<Product> selectById(Integer product_id){
        String sql="select * from t_product where product_id=?";
        List<Product> productsById=CommonDaoUtil.query(sql, ProductDao.class,product_id);
        return productsById;
    }

    /**
     * 添加商品
     */
    public boolean save(Product product){
        String sql="insert into t_product (product_name,type_id,description,price,picture,remark) values (?,?,?,?,?,?)";
        String product_name=product.getProduct_name();
        Integer type_id= product.getType_id();
        String description=product.getDescription();
        Double price=product.getPrice();
        String picture=product.getPicture();
        String remark=product.getRemark();
        boolean isSuccess=CommonDaoUtil.modify(sql,product_name,type_id,description,price,picture,remark);
        return isSuccess;
    }

    /**
     * 删除商品
     */
    public boolean delete(Integer product_id){
        String sql="update t_product set state=0 where product_id=?";
        boolean isSuccess=CommonDaoUtil.modify(sql,product_id);
        return isSuccess;
    }

    /**
     * 修改商品
     */
    public boolean update(Product product){
        String sql="update t_product set product_name=?,type_id=?,description=?,price=?,picture=?,remark=? values (?,?,?,?,?,?)";
        String product_name=product.getProduct_name();
        Integer type_id= product.getType_id();
        String description=product.getDescription();
        Double price=product.getPrice();
        String picture=product.getPicture();
        String remark=product.getRemark();
        boolean isSuccess=CommonDaoUtil.modify(sql,product_name,type_id,description,price,picture,remark);
        return isSuccess;
    }

    /**
     * 根据商品名称以及商品描述搜索商品
     */
    public List<Product> searchByName(String product_name){
        String sql="select * from t_product where product_name like '%"+product_name+"%' or description like '%"+product_name+"%'";
        List<Product> listByName=CommonDaoUtil.query(sql,Product.class,product_name);
        return listByName;
    }

    /**
     * 多种条件搜索商品(商品名称，商品描述，商品价格，商品类型ID)
     */
    public List<Product> searchByParams(Product params){
        String sql="select * from t_product where 1=1 ";
        if(params.getProduct_name()!=null){
            sql+="and product_name like '%"+params.getProduct_name()+"%'";
        }else if(params.getDescription()!=null){
            sql+="and product_name like '%"+params.getDescription()+"%'";
        }else if(params.getPrice()!=null){
            sql+="and price >"+params.getPrice();
        }else if(params.getType_id()!=null){
            sql+="and Type_id ="+params.getType_id();
        }
        List<Product> listByParams=CommonDaoUtil.query(sql,Product.class,null);
        return listByParams;
    }
}

























