package com.jy.dao;

import com.jy.entity.Product;
import com.jy.entity.ProductExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductMapper {

    //分页查询
    List<Product> findByPage(@Param("index") Integer index,@Param("count") Integer count);


    int countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Integer productid);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer productid);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);
}