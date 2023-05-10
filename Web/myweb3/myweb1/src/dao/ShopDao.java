package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Shop;
import entity.Type;
import entity.User;

public class ShopDao {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	//根据id查询商品的详细信息
		public Shop findShopById(int shopId) {
			try {
				con=UtilDao.getConnection();
				ps=con.prepareStatement("select * from shop where shopId=?");
				ps.setInt(1,shopId);
				rs=ps.executeQuery();
				
				if(rs.next()) {
					Shop s=new Shop();
					s.setShopId(rs.getInt(1));
					s.setShopName(rs.getString(2));
					s.setPrice(rs.getDouble(3));
					s.setImg(rs.getString(4));
					s.setContent(rs.getString(5));
					s.setTypeId(rs.getInt(6));
					return s;
				}else {
					return null;
				}
				
			}catch(Exception e) {
				e.printStackTrace();
				return null;
			}
		}
		
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
	
	//查询首页推荐的商品
	public List findShopSyt() {
		try {
			con=UtilDao.getConnection();
			ps=con.prepareStatement("select * from shop where syt=1");
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
				s.setSyt(rs.getInt(7));
				list.add(s);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	
	//查询首页分类
	public List findTypeSyt() {
		try {
			con=UtilDao.getConnection();
			ps=con.prepareStatement("select * from type where syt=1");
			rs=ps.executeQuery();
			List list=new ArrayList();
			while(rs.next()) {
				Type t=new Type();
				t.setTypeId(rs.getInt(1));
				t.setTypeName(rs.getString(2));
				t.setSyt(rs.getInt(3));
				list.add(t);
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
