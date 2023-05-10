package com.jiuyun.system.model;

import com.jiuyun.system.util.CommonDao;
import com.jiuyun.system.vo.CategoryInfoVo;

import java.util.ArrayList;
import java.util.List;

public class BookTypeDao {

    public static List<CategoryInfoVo> queryAllBookType(){
        String sql="select * from category";
        List<CategoryInfoVo> CategoryInfoVoList = CommonDao.queryTable(sql, CategoryInfoVo.class, "booktypeinfo.properties", null);
        return CategoryInfoVoList;
    }

    public static CategoryInfoVo queryBookType(CategoryInfoVo tmp){
        String sql="select categoryid from category where categorystructure=? and categoryname=?";
        Object[] params=new Object[]{tmp.getCateGoryStructure(),tmp.getCateGoryName()};
        List<CategoryInfoVo> list=CommonDao.queryTable(sql, CategoryInfoVo.class, "booktypeinfo.properties", params);
        return list.get(0);
    }

    public static boolean remove(CategoryInfoVo CategoryInfoVo){
        List<CategoryInfoVo> CategoryInfoVoList = queryChildNode(CategoryInfoVo);
        boolean isSuccess=true;
        for(CategoryInfoVo tmp:CategoryInfoVoList){
            //需要保证每一个子节点都删除成功
            if(!removeBookType(tmp)){
                isSuccess=false;
            }
        }
        return isSuccess;
    }

    public static boolean removeBookType(CategoryInfoVo CategoryInfoVo){
        String sql="delete from category where categorystructure=?";
        Object[] params=new Object[]{CategoryInfoVo.getCateGoryStructure()};
        return CommonDao.updateTable(sql,params);
    }

    //查询某节点的所有子节点
    public static List<CategoryInfoVo> queryChildNode(CategoryInfoVo CategoryInfoVo){
        String cateGoryStructure = CategoryInfoVo.getCateGoryStructure();
        List<CategoryInfoVo> CategoryInfoVoList = queryAllBookType();
        List<CategoryInfoVo> childList=new ArrayList<>();
        for(CategoryInfoVo tmp:CategoryInfoVoList){
            if(tmp.getCateGoryStructure().startsWith(cateGoryStructure)){
                childList.add(tmp);
            }
        }
        return childList;
    }

    public static boolean addBookType(CategoryInfoVo CategoryInfoVo){
        String sql="insert into category(categorystructure,categoryname) values(?,?)";
        Object[] params=new Object[]{CategoryInfoVo.getCateGoryStructure(),CategoryInfoVo.getCateGoryName()};
        return CommonDao.updateTable(sql,params);
    }

    public static boolean setBookType(CategoryInfoVo tmp){
        String sql="update category set categoryname=? where categoryid=?";
        Object[] params=new Object[]{tmp.getCateGoryName(),tmp.getCateGoryId()};
        return CommonDao.updateTable(sql,params);
    }
}
