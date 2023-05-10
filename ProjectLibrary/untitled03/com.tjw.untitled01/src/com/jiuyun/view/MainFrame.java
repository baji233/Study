package com.jiuyun.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 雇员信息主窗体
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
    //事件监听对象
    ButtonLister buttonLister;
    //主框架
    public MainFrame(){
        initialMainPanl();
        this.setSize(500,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置默认关闭操作(关闭时退出)
    }

    //设计初始化窗体整体面板
    private void initialMainPanl(){
        mainPane=new JSplitPane();//分割面板
        mainPane.setLastDividerLocation(100);//设置最后一个分隔线位置
        initialLeftPanl();
        mainPane.setLeftComponent(leftPanel);//将组件设置在分隔线的左侧
        initialRightPanl();
        mainPane.setRightComponent(rightPanel);//右侧
        //将主面板添加到此容器
        this.add(mainPane);
    }

    //初始化左面板
    private void initialLeftPanl(){
        leftPanel=new JPanel();
        BorderLayout layout=new BorderLayout();//构造一个新的边框布局，组件之间没有间隙
        leftPanel.setLayout(layout);//为左面板设置边框
        jLabelTip=new JLabel("部门结构");//顶部标签
        //树结构
        deptTree=new JTree();
        JScrollPane jSplitPane=new JScrollPane(deptTree);//滚动面板(整树)
        jSplitPane.setViewportView(deptTree);//视口视图(树枝)
        //将标签和滚动面板添加到左面板
        leftPanel.add(jLabelTip,BorderLayout.NORTH);//类名.常量名调用
        leftPanel.add(jSplitPane,BorderLayout.SOUTH);
    }

    //初始化右面板
    private void initialRightPanl(){
        this.rightPanel=new JTabbedPane();
        initialEmpinfoPanl();
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
    JTextField txtName,txtJob;
    JButton jbtQuery;
    //显示雇员信息需要的组件
    JTable empTbl;
    //南面板
    JPanel empSouthPanel;
    JButton btnAdd,btnDelete,btnUpdata;
    //初始化雇员信息面板
    private void initialEmpinfoPanl(){
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
        this.jrbByJob=new JRadioButton("按工作");
        this.buttonGroup=new ButtonGroup();//ButtonGroup对象创建一组按钮意味着“打开”其中一个按钮会关闭组中的所有其他按钮
        buttonGroup.add(jrbByName);
        buttonGroup.add(jrbByJob);
        txtName=new JTextField(15);
        txtJob=new JTextField(15);
        this.jbtQuery=new JButton("查询");
        jbtQuery.setActionCommand("query");
        this.buttonLister=new ButtonLister();//创建监听器
        jbtQuery.addActionListener(buttonLister);


        //按约束添加小组件
        addByConstraints(gbc,0,0,5,1,lblQueryTitle);
        addByConstraints(gbc,1,0,0,1,jrbByName);
        addByConstraints(gbc,1,1,3,1,txtName);
        addByConstraints(gbc,2,0,1,1,jrbByJob);
        addByConstraints(gbc,2,1,3,1,txtJob);
        addByConstraints(gbc,2,4,1,1,jbtQuery);
        //展示面板
        this.empDisplayPanel=new JPanel();
        empDisplayPanel.setLayout(new BorderLayout());
        this.empTbl=new JTable();
        JScrollPane jScrollPane=new JScrollPane(empTbl);//显示JTable的无视口视图
        jScrollPane.setViewportView(empTbl);//指定将在滚动窗格中显示的可滚动子项empTbl
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
        this.btnUpdata=new JButton("修改");
        btnAdd.setActionCommand("updata");
        btnAdd.addActionListener(buttonLister);//注册
        btnDelete.addActionListener(buttonLister);
        btnUpdata.addActionListener(buttonLister);
        this.empSouthPanel.add(btnAdd);
        this.empSouthPanel.add(btnDelete);
        this.empSouthPanel.add(btnUpdata);
        empJPanel.add(empSouthPanel,BorderLayout.SOUTH);
    }
    //添加约束的方法
    private void addByConstraints(GridBagConstraints gbc,int row,int col,int width,int height,Component component){
        gbc.gridx=col;
        gbc.gridy=row;
        gbc.gridwidth=width;
        gbc.gridheight=height;
    }

    public static void main(String[] args){
        new MainFrame().setVisible(true);//使Window可见
    }
}


//按钮事件处理实现类
class ButtonLister implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        String str=e.getActionCommand();
        if("query".equals(str)){

        }else if("add".equals(str)){

        }else if("delete".equals(str)){

        }else if("updata".equals(str)){

        }
    }
}





















