package com.jiuyun.system.model;

import com.jiuyun.system.util.CommonDao2;
import com.jiuyun.system.vo.CollectionRecordVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;
import java.util.Vector;

/**
 * 操作collection_record表
 */
public class CollectionRecordDao {
    /**
     * 增删改查表
     * @return 影响行数/查询结果集
     */
    public static List<CollectionRecordVO>selectALLRecord(){
        String sql="select * from collection_record";
        List<CollectionRecordVO> list= CommonDao2.query(sql, CollectionRecordVO.class,null);
        return list;
    }

    public static List<CollectionRecordVO>selectButton01(String sql,String typeText,String timeText){
        List<CollectionRecordVO> list= CommonDao2.query(sql, CollectionRecordVO.class,typeText,timeText);
        return list;
    }

    public static List<CollectionRecordVO> selectButton02(String sql,String timeText) {
        List<CollectionRecordVO> list= CommonDao2.query(sql, CollectionRecordVO.class,timeText);
        return list;
    }

    public static List<CollectionRecordVO> selectButton03(String sql,String typeText){
        List<CollectionRecordVO> list= CommonDao2.query(sql, CollectionRecordVO.class,typeText);
        return list;
    }

/**
* 获取收款记录表
* @return table
*/
    public static DefaultTableModel tableModel;
    public static JTable getTable(List<CollectionRecordVO> lists){
        //列名
        Vector<String> titles=new Vector<>();
        titles.add("读者编号");
        titles.add("应收金额");
        titles.add("实收金额");
        titles.add("收款类型");
        titles.add("收款时间");
        //数据
        Vector<Vector> allItems=new Vector<>();
        for(CollectionRecordVO crvo:lists){
            Vector<String> vector=new Vector<>();
            vector.add(crvo.getRId());
            vector.add(crvo.getAmountReceivable());
            vector.add(crvo.getAmountReceived());
            vector.add(crvo.getPaymentType());
            vector.add(crvo.getCollectionTime());
            allItems.add(vector);
        }
        tableModel=new DefaultTableModel(allItems,titles);
        JTable table=new JTable(tableModel);
        table.setEnabled(false);
        return table;
    }

/**
* 获取收款记录查询子面板
* @return frame
*/
    public static JFrame getFrame(JTable table){
        JFrame frame=new JFrame("查询结果");
        frame.setSize(520,500);
        frame.setLocation(600,250);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setLayout(new FlowLayout(FlowLayout.TRAILING));
        JScrollPane scrollPane=new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setViewportView(table);
        JPanel panel=new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        JLabel label=new JLabel("共"+tableModel.getRowCount()+"条记录");
        label.setFont(new Font("宋体",Font.BOLD,15));
        panel.add(label);
        frame.add(scrollPane);
        frame.add(panel);
        return frame;
    }

}















