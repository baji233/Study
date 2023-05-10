package com.jiuyun.system.view;

import com.jiuyun.system.control.EmpInfoActionListener;
import com.jiuyun.system.model.EmpDao;
import com.jiuyun.system.vo.EmpInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.List;
import java.util.Vector;


/**
 * 雇员面板
 */
public class MainFrame extends JFrame {
    //主体结构
    JSplitPane mainPane;
    JPanel leftPanel;
    JTabbedPane rightPanel;
    //左边面板的组件
    JLabel jLabelTip;
    JTree deptTree;
    //右边面板的组件
    JPanel empJPanel,deptJPanel;
    //主框架
    public MainFrame(){
        initialMainPanel();
        this.setSize(500,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置默认关闭操作(关闭时退出)
    }

    //设计初始化窗体整体面板
    private void initialMainPanel(){
        mainPane=new JSplitPane();//分割面板
        mainPane.setLastDividerLocation(100);//设置最后一个分隔线位置
        initialLeftPanel();
        mainPane.setLeftComponent(leftPanel);//将组件设置在分隔线的左侧
        initialRightPanel();
        mainPane.setRightComponent(rightPanel);//右侧
        //将主面板添加到此容器
        this.add(mainPane);
    }
    //初始化树结构
    private void initialJTree(){
        DefaultMutableTreeNode root=new DefaultMutableTreeNode();//树数据结构中的通用节点
        deptTree=new JTree(root);
        deptTree.setRowHeight(30);//设置高度
    }

    //初始化左面板
    private void initialLeftPanel(){
        leftPanel=new JPanel();
        BorderLayout layout=new BorderLayout();//构造一个新的边框布局，组件之间没有间隙
        leftPanel.setLayout(layout);//为左面板设置边框
        jLabelTip=new JLabel("部门结构");//顶部标签
        //树结构
        initialJTree();
        JScrollPane jSplitPane=new JScrollPane(deptTree);//滚动面板(整树)
        jSplitPane.setViewportView(deptTree);//视口视图(树枝)
        //将标签和滚动面板添加到左面板
        leftPanel.add(jLabelTip,BorderLayout.NORTH);//类名.常量名调用
        leftPanel.add(jSplitPane,BorderLayout.CENTER);
    }

    //初始化右面板
    private void initialRightPanel(){
        this.rightPanel=new JTabbedPane();
        initialEmpInfoPanel();
        empJPanel.setForeground(Color.YELLOW);//设置前景
        this.deptJPanel=new JPanel();
        deptJPanel.setForeground(Color.RED);
        //将员工信息和部门信息添加到右面板
        rightPanel.add("员工信息",empJPanel);
        rightPanel.add("部门信息",deptJPanel);
    }
    //北面板
    JSplitPane empCenterPane;
    JPanel empQueryPanel,empDisplayPanel;
    //查询条件需要的组件
    JLabel lblQueryTitle;
    JRadioButton jrbByName,jrbByJob;
    ButtonGroup buttonGroup;
    public JTextField txtName,txtJob;
    public JTable empTab;
    //南面板
    JPanel empSouthPanel;
    JButton btnQuery,btnAdd,btnDelete,btnUpdate;
    //初始化雇员信息面板
    private void initialEmpInfoPanel(){
        this.empJPanel=new JPanel();
        empJPanel.setLayout(new BorderLayout());
        this.empCenterPane=new JSplitPane(JSplitPane.VERTICAL_SPLIT);//沿y轴垂直拆分
        empCenterPane.setDividerLocation(130);//分割线的位置
        //条件查询面板
        this.empQueryPanel=new JPanel();
        GridBagLayout gbl=new GridBagLayout();//创建一个网格包布局管理器
        GridBagConstraints gbc=new GridBagConstraints();//为使用GridBagLayout类布局的组件指定约束
        gbc.insets=new Insets(10,5,10,5);//使用指定的顶部、左侧、底部和右侧插入创建并初始化一个新的插图对象
        empQueryPanel.setLayout(gbl);
        //小组件
        this.lblQueryTitle=new JLabel("条件查询");
        Font f=new Font("宋体",Font.BOLD,15);
        lblQueryTitle.setFont(f);
        this.jrbByName=new JRadioButton("按姓名",true);//true:最初选择按钮
        jrbByName.setActionCommand("name");
        this.jrbByJob=new JRadioButton("按工作");
        jrbByJob.setActionCommand("job");
        this.buttonGroup=new ButtonGroup();//ButtonGroup对象创建一组按钮意味着“打开”其中一个按钮会关闭组中的所有其他按钮
        buttonGroup.add(jrbByName);
        buttonGroup.add(jrbByJob);
        this.txtName=new JTextField(15);
        this.txtJob=new JTextField(15);
        this.btnQuery=new JButton("查询");
        btnQuery.setActionCommand("query");

        //按约束添加小组件
        addByConstraints(gbc,0,0,5,1,lblQueryTitle);
        addByConstraints(gbc,1,0,1,1,jrbByName);
        addByConstraints(gbc,1,1,3,1,txtName);
        addByConstraints(gbc,2,0,1,1,jrbByJob);
        addByConstraints(gbc,2,1,3,1,txtJob);
        addByConstraints(gbc,2,4,1,1,btnQuery);
        //展示面板
        this.empDisplayPanel=new JPanel();
        empDisplayPanel.setLayout(new BorderLayout());
        //创建雇员信息表
        initialEmpTbl();
        JScrollPane jScrollPane=new JScrollPane(empTab);//显示JTable的无视口视图
        jScrollPane.setViewportView(empTab);//指定将在滚动窗格中显示的可滚动子项empTbl
        empDisplayPanel.add(jScrollPane);
        empCenterPane.setTopComponent(empQueryPanel);//设置顶部组件
        empCenterPane.setBottomComponent(empDisplayPanel);//设置底部组件
        empJPanel.add(empCenterPane);

        //南部操作按钮面板
        this.empSouthPanel=new JPanel();
        this.btnAdd=new JButton("添加");
        btnAdd.setActionCommand("add");
        this.btnDelete=new JButton("删除");
        btnAdd.setActionCommand("delete");
        this.btnUpdate=new JButton("修改");
        btnAdd.setActionCommand("update");
        this.empSouthPanel.add(btnAdd);
        this.empSouthPanel.add(btnDelete);
        this.empSouthPanel.add(btnUpdate);
        //注册动作监听器
        EmpInfoActionListener empInfoActionListener=new EmpInfoActionListener(this);
        this.btnQuery.addActionListener(empInfoActionListener);
        this.btnAdd.addActionListener(empInfoActionListener);
        this.btnDelete.addActionListener(empInfoActionListener);
        this.btnUpdate.addActionListener(empInfoActionListener);
        empJPanel.add(empSouthPanel,BorderLayout.SOUTH);
    }
    public DefaultTableModel dtm=null;//表模型
//JTable显示表(多种方法)
    private void initialEmpTbl(){
        //新列名称
        Vector<String> titles=new Vector<>();//选择用Vector来装数据是因为:DefaultTableModel的构造方法的参数类型
        titles.add("雇员编号");
        titles.add("姓名");
        titles.add("工资");
        titles.add("工作");
        titles.add("生日");
        titles.add("部门");

        //表中数据
        List<EmpInfo> lstEmp=EmpDao.queryAllEmp();//存放装有查询结果的对象
        Vector<Vector> allData=new Vector<>();//最大对象数组的容器
        for(EmpInfo empInfo :lstEmp){
            Vector<String>vector=new Vector<>();//存放empinfo表中查询的数据
            vector.add(empInfo.getEmpId());
            vector.add(empInfo.getEmpName());
            vector.add(empInfo.getPay());
            vector.add(empInfo.getJob());
            vector.add(empInfo.getBirthday());
            vector.add(empInfo.getDeptId());
            allData.add(vector);
        }

        dtm=new DefaultTableModel(allData,titles);//将两个Vector引用作为参数传给默认表模型
        empTab=new JTable(dtm);
        /**
         * 在JTable中显示MySQL表
         */

        /**
         * 构造方法JTable(Object[][] rowData, Object[] columnNames)值,列名
         *         String[] columnNames={"雇员编号","姓名","工资","工作","生日","部门"};
         *         String[][] rowData= {{"1","小王","3000.5","程序员","2001-8-8","101"},{"2","小朱","3500.9","会记","2003-2-23","203"}};
         *         empTab=new JTable(rowData,columnNames);
         */

        /**
         * 构造方法JTable(TableModel dm)数据模型,先使用Vector<>创建数据模型

        Vector<String> columnNames=new Vector<>();
        columnNames.add("雇员编号");
        columnNames.add("姓名");
        columnNames.add("工资");
        columnNames.add("工作");
        columnNames.add("生日");
        columnNames.add("部门");

        Vector<Vector> rowData=new Vector<>();
        Vector<String> emp01=new Vector<>();
        emp01.add("1");
        emp01.add("小王");
        emp01.add("3000.5");
        emp01.add("程序员");
        emp01.add("2001-8-8");
        emp01.add("101");
        Vector<String> emp02=new Vector<>();
        emp02.add("2");
        emp02.add("小朱");
        emp02.add("3500.9");
        emp02.add("会记");
        emp02.add("2003-2-23");
        emp02.add("203");
        rowData.add(emp01);
        rowData.add(emp02);
        dtm=new DefaultTableModel(rowData,columnNames);
        empTab=new JTable(dtm);
         */

    }
    //添加约束的方法
    private void addByConstraints(GridBagConstraints gbc,int row,int col,int width,int height,Component component){
        gbc.gridx=col;
        gbc.gridy=row;
        gbc.gridwidth=width;
        gbc.gridheight=height;
        empQueryPanel.add(component,gbc);
    }

    public static void main(String[] args){
        new MainFrame().setVisible(true);//使Window可见
    }
}















