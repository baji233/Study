package com.jiuyun.dao;

import com.jiuyun.bean.Order;
import com.jiuyun.bean.OrderItem;
import com.jiuyun.util.CommonUtil;
import com.jiuyun.util.DBUtil;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class OrderDao {
    /**
     * 添加订单
     */
    public boolean orderAdd(Order order) {
        String sql = "insert into t_order (order_id,user_id,address,order_price,remark) values(?,?,?,?,?)";
        return CommonUtil.modify(sql,order.getOrderId(),order.getUserId(),order.getAddress(),order.getOrderPrice(),order.getRemark());
    }

    /**
     * 事务实现保存订单
     */
    public boolean orderSave(Order order, List<OrderItem> orderItemList) throws SQLException {
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
        } catch (Exception e){
            DBUtil.printLog(e);
            //回滚事务
            conn.rollback();
            DBUtil.close(conn,st,null);
        } finally {
            return flag;
        }
    }

    /**
     * 删除订单
     */
    public boolean orderDelete(String orderId) {
        String sql = "update t_order set state=0 where order_id=?";
        return CommonUtil.modify(sql,orderId);
    }

    /**
     * 修改订单
     */
    public boolean orderUpdate(Order order) {
        String sql = "update t_order set address=?,order_price=?,state=?,remark=? where order_id=?";
        return CommonUtil.modify(sql,order.getAddress(),order.getOrderPrice(),order.getState(),order.getRemark(),order.getOrderId());
    }

    /**
     * 获取所有订单信息
     */
    public List<Order> selectAll() {
        String sql = "select * from t_order";
        return CommonUtil.query(sql,Order.class,null);
    }

    /**
     * 根据ID获取订单信息
     */
    public List<Order> selectById(String orderId) {
        String sql = "select * from t_order where order_id=?";
        return CommonUtil.query(sql,Order.class,orderId);
    }
}
