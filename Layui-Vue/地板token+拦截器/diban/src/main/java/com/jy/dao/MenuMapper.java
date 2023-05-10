package com.jy.dao;

import com.jy.entity.Menu;
import com.jy.entity.MenuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MenuMapper {
    public List<Menu> findMenu(Integer roleId);

    int countByExample(MenuExample example);

    int deleteByExample(MenuExample example);

    int deleteByPrimaryKey(Integer menuId);

    int insert(Menu record);

    int insertSelective(Menu record);

    List<Menu> selectByExample(MenuExample example);

    Menu selectByPrimaryKey(Integer menuId);

    int updateByExampleSelective(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByExample(@Param("record") Menu record, @Param("example") MenuExample example);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
}