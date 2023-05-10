package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.Cart;
import entity.Shop;
import entity.Type;
import entity.User;

public class CartDao {
	Connection con=null;
	PreparedStatement ps=null;
	ResultSet rs=null;
	//根据id查询商品的详细信息
		public int addCart(Cart c) {
			try {
				con=UtilDao.getConnection();
				ps=con.prepareStatement("insert into cart (cUserId,cShopId,number) values(?,?,?)");
				ps.setInt(1,c.getcUserId());
				ps.setInt(2,c.getcShopId());
				ps.setInt(3,c.getNumber());
				return ps.executeUpdate();
			}catch(Exception e) {
				e.printStackTrace();
				return 0;
			}finally {
				UtilDao.close(con, ps, rs);
			}
		}
	//查询指定用户的购物车信息
		public List findByUserId(Integer userId) {
			
			try {
				con=UtilDao.getConnection();
				ps=con.prepareStatement("select * from cart where cUserId=?");
				ps.setInt(1,userId);
				rs=ps.executeQuery();
				List list=new ArrayList();
				while(rs.next()) {
					Cart c=new Cart();
					c.setCartId(rs.getInt(1));
					c.setcUserId(rs.getInt(2));
					c.setcShopId(rs.getInt(3));
					//根据商品ID，填充商品详细信息
					ps=con.prepareStatement("select * from shop where shopId=?");
					ps.setInt(1,c.getcShopId());
					ResultSet item=ps.executeQuery();
					if(item.next()) {
						//商品信息填充
						Shop s=new Shop();
						s.setShopId(item.getInt(1));
						s.setShopName(item.getString(2));
						s.setPrice(item.getDouble(3));
						s.setImg(item.getString(4));
						s.setContent(item.getString(5));
						s.setTypeId(item.getInt(6));
						c.setS(s);
					}
				
					c.setNumber(rs.getInt(4));
					list.add(c);
				}
				return list;
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				UtilDao.close(con, ps, rs);
			}
			return null;
		}
	
}
