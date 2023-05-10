package com.jiuyun.dao;

import com.jiuyun.bean.Order;
import com.jiuyun.bean.OrderItem;
import com.jiuyun.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cj
 * @create 2022年10月15日 16:23:16
 */
public class OrderDAO {
    /**
     * 保存订单的方法
     * @param order
     * @return
     */
    public boolean save(Order order) {
        boolean flag = false;
        String sql = "insert into t_order (order_id,user_id,address,order_price,remark) values(?,?,?,?,?)";
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, order.getOrderId());
            st.setInt(2, order.getUserId());
            st.setString(3, order.getAddress());
            st.setDouble(4, order.getOrderPrice());
            st.setString(5, order.getRemark());
            flag = st.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, st, null);
        }
        return flag;
    }

    /**
     * 事务实现保存订单
     * @param order
     * @param orderItemList
     * @return
     */
    public boolean saveOrder(Order order, List<OrderItem> orderItemList) throws SQLException {}
        boolean flag = false;
        Connection conn = null;
        Statement st = null;
        String sql = "";
        try {
            conn = DBUtil.getConnection();
            //设置该连接为自动提交，即打开事务
            conn.setAutoCommit(false);
            st = conn.createStatement();
            //存储订单的业务
            //先存订单
            sql = "insert into t_order values('" + order.getOrderId() + "'," + order.getUserId() + ",'" + order.getAddress() + "'," + order.getOrderPrice() + ",default,'" + order.getRemark() + "')";
            int count = st.executeUpdate(sql);
            //再存订单项
            sql = "insert into t_order_item (order_id, product_id, count) VALUES ";
            for (OrderItem orderItem : orderItemList) {
                sql += "('" + orderItem.getOrderId() + "', " + orderItem.getProductId() + ", " + orderItem.getCount() + "),";
            }
            sql = sql.substring(0, sql.length() - 1);
            count += st.executeUpdate(sql);
            //判断数据插入是否正确
            flag = count == (orderItemList.size() + 1);
            if(flag) {
                //提交事务
                conn.commit();
            } else {
                //回滚事务
                conn.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
            //回滚事务
            conn.rollback();
        } finally {
            DBUtil.closeAll(conn, st, null);
        }
        return flag;
    }

    /**
     * 删除订单的方法
     * @param orderId
     * @return
     */
    public boolean delete(String orderId) {
        boolean flag = false;
        String sql = "update t_order set state=0 where order_id=?";
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, orderId);
            flag = st.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, st, null);
        }
        return flag;
    }

    /**
     * 修改订单的方法
     * @param order
     * @return
     */
    public boolean update(Order order) {
        boolean flag = false;
        String sql = "update t_order set address=?,order_price=?,state=?,remark=? where order_id=?";
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.prepareStatement(sql);
            st.setString(1, order.getAddress());
            st.setDouble(2, order.getOrderPrice());
            st.setInt(3, order.getState());
            st.setString(4, order.getRemark());
            st.setString(5, order.getOrderId());
            flag = st.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, st, null);
        }
        return flag;
    }

    /**
     * 获取所有订单信息的方法
     * @return  订单信息集合
     */
    public List<Order> selectAll() {
        List<Order> orderList = new ArrayList<>();
        String sql = "select * from t_order";
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                Order order = new Order();
                order.setOrderId(rs.getString(1));
                order.setUserId(rs.getInt(2));
                order.setAddress(rs.getString(3));
                order.setOrderPrice(rs.getDouble(4));
                order.setState(rs.getInt(5));
                order.setRemark(rs.getString(6));
                orderList.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, st, rs);
        }
        return orderList;
    }

    /**
     * 根据ID获取订单信息的方法
     * @param orderId
     * @return
     */
    public Order selectById(String orderId) {
        Order order = null;
        String sql = "select * from t_order where order_id=" + orderId;
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while(rs.next()) {
                order = new Order();
                order.setOrderId(rs.getString(1));
                order.setUserId(rs.getInt(2));
                order.setAddress(rs.getString(3));
                order.setOrderPrice(rs.getDouble(4));
                order.setState(rs.getInt(5));
                order.setRemark(rs.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.closeAll(conn, st, rs);
        }
        return order;
    }

    public static void main(String[] args) {
        String sql = "fds,jk,lfd,";
        System.out.println();
    }
}
