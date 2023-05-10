package com.jiuyun.system.view;

import com.jiuyun.system.control.ReaderInfoAction;
import com.jiuyun.system.model.ReaderInfoDao;
import com.jiuyun.system.model.ReaderTypeDao;
import com.jiuyun.system.vo.ReTypeInfoVO;
import com.jiuyun.system.vo.ReaderInfoVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.io.Serializable;
import java.util.List;
import java.util.Vector;


//读者维护
public class ReaderInfoView extends JFrame {
    JSplitPane mainPane;
    public JTable readerInfoTable;
    //表的原始数据,表在查询过程中数据发生减少，需要通过原始数据还原
    public DefaultTableModel readerInfoTbModel;
    JPanel btnPanel;

    JSplitPane northPane;
    JPanel southPane;

    public JScrollPane jScrollPane;
    JPanel queryPanel;
    public JTextField txtQuery;
    public JButton queryBtn;
    public JComboBox queryCondition;
    public JButton addReaderBtn;
    public JButton deleteReaderBtn;
    public JButton updateReaderBtn;

    public ReaderInfoView() {
        initialStyle();
        initialView();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }

    public void initialStyle() {
        /*Container contentPane = this.getContentPane();
        contentPane.setBackground(Color.CYAN);*/
        this.setBounds(300, 100, 1000, 500);
        this.setTitle("读 者 信 息 维 护");
        
    }


    public void initialView() {
        //设置为垂直布局
        mainPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        //分割线位置
        mainPane.setDividerLocation(100);
        //分割线大小
        mainPane.setDividerSize(10);
        initialNorthPane();
        initialSouthPanel();
        mainPane.setTopComponent(northPane);
        mainPane.setBottomComponent(southPane);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        this.add(mainPane);
    }

    public void initialNorthPane() {
        northPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        northPane.setSize(1000,200);
        //按钮块
        btnPanel = new JPanel();
        //流式布局
        btnPanel.setLayout(new FlowLayout());
        btnPanel.setBackground(Color.CYAN);
        ReaderInfoAction readerInfoAction=new ReaderInfoAction(this);
        addReaderBtn = new JButton("添加");
        addReaderBtn.setActionCommand("addReaderInfo");
        addReaderBtn.addActionListener(readerInfoAction);
        deleteReaderBtn = new JButton("删除");
        deleteReaderBtn.setActionCommand("deleteReaderInfo");
        deleteReaderBtn.addActionListener(readerInfoAction);
        updateReaderBtn = new JButton("修改");
        updateReaderBtn.setActionCommand("updateReaderInfo");
        updateReaderBtn.addActionListener(readerInfoAction);
        btnPanel.add(addReaderBtn);
        btnPanel.add(deleteReaderBtn);
        btnPanel.add(updateReaderBtn);

        //查询面板
        queryPanel = new JPanel();
        queryPanel.setLayout(new FlowLayout());
        queryPanel.setBackground(Color.lightGray);

        //下拉框
        Vector<String> vector = new Vector<>();
        vector.add("任意条件");
        vector.add("通过读者编号");
        vector.add("通过读者姓名");

        queryCondition = new JComboBox(vector);


        //文本框

        txtQuery = new JTextField(15);
        queryBtn = new JButton("查询");
        queryBtn.setActionCommand("query");
        queryBtn.addActionListener(readerInfoAction);
        //增加条件
        queryPanel.add(queryCondition, BorderLayout.WEST);
        queryPanel.add(txtQuery, BorderLayout.CENTER);
        queryPanel.add(queryBtn, BorderLayout.EAST);
        northPane.setTopComponent(btnPanel);
        northPane.setBottomComponent(queryPanel);
    }

    //南部面板
    public void initialSouthPanel() {
        southPane = new JPanel();
        southPane.setLayout(new BorderLayout(0, 0));

        Vector<String> titles = new Vector<>();
        titles.add("编号");
        titles.add("姓名");
        titles.add("借阅次数");
        titles.add("可借阅");
        titles.add("性别");
        titles.add("年龄");
        titles.add("生日");
        titles.add("读者类型");
        titles.add("注册日期");
        titles.add("到期日期");
        titles.add("身份证号码");
        titles.add("电话");
        titles.add("邮箱");
        titles.add("工作单位");
        titles.add("部门");
        titles.add("是否挂失");
        titles.add("操作员");

        List<ReaderInfoVO> list = ReaderInfoDao.queryReaderInfo();
        Vector<Vector> allItems = new Vector<>();
        for (ReaderInfoVO temp : list) {
            Vector v1 = new Vector();
            v1.add(temp.getReaderId());
            v1.add(temp.getName());
            v1.add(temp.getBorrowNum());
            v1.add(temp.getIsBorrow());
            v1.add(temp.getSex());
            v1.add(temp.getAge());
            v1.add(temp.getBirth());
            List<ReTypeInfoVO> data = ReaderTypeDao.queryReType();
            for (ReTypeInfoVO tmp : data) {
                if (temp.getReTypeId().equals(tmp.getReTypeId())) {
                    v1.add(tmp.getReTypename());
                    break;
                }
            }
            v1.add(temp.getRegisterDate());
            v1.add(temp.getExpireTime());
            v1.add(temp.getIdCard());
            v1.add(temp.getPhone());
            v1.add(temp.getE_mail());
            v1.add(temp.getWorkLocation());
            v1.add(temp.getDepartment());
            v1.add(temp.getLossState());
            v1.add(temp.getOperator());
            allItems.add(v1);
        }
        readerInfoTbModel = new DefaultTableModel(allItems, titles);

        readerInfoTable = new JTable(readerInfoTbModel){
            //重写该方法，使所有的单元格不能被编辑
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        //identifier：标识符
        for(int i=0;i<readerInfoTable.getColumnCount();i++){
            String columnName = readerInfoTable.getColumnName(i);
            readerInfoTable.getColumn(columnName).setPreferredWidth(40);
        }
        TableColumn c1 = readerInfoTable.getColumn("生日");
        c1.setPreferredWidth(70);
        TableColumn c2 = readerInfoTable.getColumn("到期日期");
        c2.setPreferredWidth(70);
        TableColumn c3 = readerInfoTable.getColumn("注册日期");
        c3.setPreferredWidth(70);

        //加入滚动面板才能显现出来
        jScrollPane = new JScrollPane();
        jScrollPane.setViewportView(readerInfoTable);
        readerInfoTable.setBackground(Color.YELLOW);
        southPane.add(jScrollPane, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        new ReaderInfoView();
    }
}
