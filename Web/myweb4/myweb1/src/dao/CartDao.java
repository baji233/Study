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
			}
		}
		
	
}
