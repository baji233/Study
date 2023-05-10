package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Shop;
import entity.User;

public class ShopDao {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	//查询全部商品 
	public List findAll() {
		try {
			con=UtilDao.getConnection();
			ps=con.prepareStatement("select * from shop");
			rs=ps.executeQuery();
			List list=new ArrayList();
			while(rs.next()) {
				Shop s=new Shop();
				s.setShopId(rs.getInt(1));
				s.setShopName(rs.getString(2));
				s.setPrice(rs.getDouble(3));
				s.setImg(rs.getString(4));
				s.setContent(rs.getString(5));
				s.setTypeId(rs.getInt(6));
				list.add(s);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
