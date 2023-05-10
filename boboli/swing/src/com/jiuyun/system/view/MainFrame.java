package com.jiuyun.system.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;

import org.jvnet.substance.SubstanceLookAndFeel;
import org.jvnet.substance.skin.OfficeBlue2007Skin;

import com.jiuyun.system.control.EmpInfoActionListener;
import com.jiuyun.system.model.DeptDao;
import com.jiuyun.system.model.EmpInfoDao;
import com.jiuyun.system.vo.DeptInfoVO;
import com.jiuyun.system.vo.EmpinfoVO;

/**
 * 雇员信息主窗体
 * @author boboli
 *
 */
public class MainFrame extends JFrame{
	//主体结构
	JSplitPane mainPane;
	JPanel leftPanel;
	JTabbedPane rightPanel;
	//左边面板的组件
	JLabel lblDeptTip;
	JTree deptInfoTree;
	//右边面板的组件
	JPanel empInfoPnl,deptInfoPnl;
	
	public MainFrame()
	{
		initialMainPanl();
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//设计窗体整体结构
	private void initialMainPanl()
	{
		mainPane=new JSplitPane();
		mainPane.setDividerLocation(100);
		initialLeftPanl();
		mainPane.setLeftComponent(leftPanel);
		intialRightPanl();
		mainPane.setRightComponent(rightPanel);
		
		this.add(mainPane);
	}
	/**
	 * 
	 * JTree的使用
	 * 资源库
	 *    电影(key)
	 *      --喜剧片
	 *      --恐怖片
	 *    音乐
	 *     --刘德华
	 *     --周杰伦
	 *    
	 */
	
	private void initialTree()
	{
		/*
		Hashtable<String, String[]> nodes=new Hashtable<String, String[]>();
		nodes.put("电影", new String[]{"喜剧片","恐怖片"});
		nodes.put("音乐", new String[]{"刘德华","周杰伦"});
		deptInfoTree=new JTree(nodes);
		*/
		/*
		 * TreeNode--表示树的节点 DefualtMutableTreeNode默认实现
		 */
		DefaultMutableTreeNode root=new DefaultMutableTreeNode("部门信息");
		//查询部门信息
		List<DeptInfoVO> lstDept=DeptDao.queryAllDept();
		DefaultTreeModel dtm=new DefaultTreeModel(root);
		for(DeptInfoVO dept:lstDept)
		{
			String nodeInfo=dept.getDeptNo()+"-"+dept.getDeptName();
			DefaultMutableTreeNode deptNode=new DefaultMutableTreeNode(nodeInfo);
			root.add(deptNode);
		}
		deptInfoTree=new JTree(root);
		
		//设置jtree的外观
		//设置树的每一层级的高度
		deptInfoTree.setRowHeight(30);
		//渲染器
		DefaultTreeCellRenderer dcr=(DefaultTreeCellRenderer)deptInfoTree.getCellRenderer();
		//设置被选中的背景色
		//dcr.setBackgroundSelectionColor(Color.PINK);
		//没有被选中的背景色
		//dcr.setBackgroundNonSelectionColor(Color.GRAY);
		//设置叶子节点的图片
		dcr.setLeafIcon(new ImageIcon("tree\\book.gif"));
		//设置枝节点打开时的图片
		dcr.setOpenIcon(new ImageIcon("tree\\folderOpen.gif"));
		//设置枝节点关闭式的图片
		dcr.setClosedIcon(new ImageIcon("tree\\folderClosed.gif"));
		
	}
	//左边面板
	private void initialLeftPanl()
	{
		leftPanel=new JPanel();
		BorderLayout layout=new BorderLayout();
		leftPanel.setLayout(layout);
		lblDeptTip=new JLabel("部门结构");
		//树结构
		initialTree();
		//使用滚动面板
		JScrollPane scrollPnl=new JScrollPane(deptInfoTree);
		scrollPnl.setViewportView(deptInfoTree);
		
		leftPanel.add(lblDeptTip,BorderLayout.NORTH);
		leftPanel.add(scrollPnl,BorderLayout.CENTER);
	}
	//右边面板
	private void intialRightPanl()
	{
		this.rightPanel=new JTabbedPane();
		
		intialEmpinfoPnl();
		empInfoPnl.setForeground(Color.YELLOW);
		this.deptInfoPnl=new JPanel();
		deptInfoPnl.setForeground(Color.RED);
		
		rightPanel.add("雇员信息",empInfoPnl);
		rightPanel.add("部门信息",deptInfoPnl);
	}
	
	JSplitPane empCenterPnl;
	JPanel empQueryPnl,empDisplayPnl;
	//查询条件需要的组件
	JLabel lblQueryTitle;
	JRadioButton jrbByName,jrbByJob;
	ButtonGroup queryGroup;
	JTextField txtName,txtJob;
	JButton btnQuery;
	//显示雇员信息需要的组件
	public JTable empTbl;
	
	JPanel empSouthPnl;
	JButton btnAdd,btnUpdate,btnDelete;
	
	//初始化雇员信息面板
	private void intialEmpinfoPnl()
	{
		this.empInfoPnl=new JPanel();
		this.empInfoPnl.setLayout(new BorderLayout());
		
		empCenterPnl=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		empCenterPnl.setDividerLocation(130);
		//条件查询面板
		empQueryPnl=new JPanel();
		GridBagLayout gbl=new GridBagLayout();
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.insets=new Insets(10, 5, 10, 5);
		empQueryPnl.setLayout(gbl);
		
		lblQueryTitle=new JLabel("条件查询");
		Font f=new Font("宋体",Font.BOLD,15);
		lblQueryTitle.setFont(f);
		this.jrbByName=new JRadioButton("按姓名",true);
		this.jrbByJob=new JRadioButton("按工作");
		this.queryGroup=new ButtonGroup();
		queryGroup.add(jrbByName);
		queryGroup.add(jrbByJob);
		txtName=new JTextField(15);
		txtJob=new JTextField(15);
		btnQuery=new JButton("查询");
		
		addByConstraints(gbc, 0, 0, 5, 1, lblQueryTitle);
		addByConstraints(gbc, 1, 0, 1, 1, jrbByName);
		addByConstraints(gbc, 1, 1, 3, 1, txtName);
		addByConstraints(gbc, 2, 0, 1, 1,jrbByJob);
		addByConstraints(gbc, 2, 1, 3, 1, txtJob);
		addByConstraints(gbc, 2, 4, 1, 1, btnQuery);
		//============
		empDisplayPnl =new JPanel();
		empDisplayPnl.setLayout(new BorderLayout());
		//创建表格
		initialEmpTbl();
		JScrollPane sp=new JScrollPane(empTbl);
		sp.setViewportView(empTbl);
		empDisplayPnl.add(sp);
		
		empCenterPnl.setTopComponent(empQueryPnl);
		empCenterPnl.setBottomComponent(empDisplayPnl);
		
		empInfoPnl.add(empCenterPnl);
		
		//操作按钮面板
		this.empSouthPnl=new JPanel();
		this.btnAdd=new JButton("添加");
		this.btnUpdate=new JButton("修改");
		this.btnDelete=new JButton("删除");
		this.empSouthPnl.add(btnAdd);
		this.empSouthPnl.add(btnUpdate);
		this.empSouthPnl.add(btnDelete);
		//注册监听器
		EmpInfoActionListener empLisener=new EmpInfoActionListener(this);
		this.btnAdd.addActionListener(empLisener);
		this.btnUpdate.addActionListener(empLisener);
		this.btnDelete.addActionListener(empLisener);
		
		
		empInfoPnl.add(empSouthPnl,BorderLayout.SOUTH);
	}
	
	//表模型
	public DefaultTableModel dtm=null;
	//表格的使用
	private void initialEmpTbl()
	{
		//字段名信息
		/*String []columnNames={"雇员编号","姓名","薪水","工作","生日","部门"};
		String [][]datas={{"7210","张三","6000","销售员","1988-12-12","开发部"},{"7215","李四","10000","销售员","1988-12-5","测试部"}};
		empTbl=new JTable(datas,columnNames);
		//定义列
		Vector<String> titles=new Vector<String>();
		titles.add("雇员编号");
		titles.add("姓名");
		titles.add("薪水");
		titles.add("工作");
		titles.add("生日");
		titles.add("部门");
		//定义数据部分
		Vector<Vector> datas=new Vector<Vector>();
		Vector<String> r1=new Vector<String>();
		r1.add("3369");
		r1.add("1");
		r1.add("1");
		r1.add("1");
		r1.add("1");
		r1.add("1");
		Vector<String> r2=new Vector<String>();
		r2.add("3369");
		r2.add("2");
		r2.add("2");
		r2.add("2");
		r2.add("2");
		r2.add("2");
		datas.add(r1);
		datas.add(r2);*/
		//empTbl=new JTable(dates, titles);
		Vector<String> titles=new Vector<String>();
		titles.add("雇员编号");
		titles.add("姓名");
		titles.add("薪水");
		titles.add("工作");
		titles.add("生日");
		titles.add("部门");
		
		List<EmpinfoVO> lstEmps=EmpInfoDao.queryAllEmp();
		Vector<Vector> allItems=new Vector<Vector>();
		for(EmpinfoVO empvo:lstEmps)
		{
			Vector<String> r1=new Vector<String>();
			r1.add(empvo.getEmpNo());
			r1.add(empvo.getEname());
			r1.add(empvo.getSalary());
			r1.add(empvo.getJob());
			r1.add(empvo.getBirthday());
			r1.add(empvo.getDname());
			allItems.add(r1);
		}
		dtm=new DefaultTableModel(allItems,titles);
		empTbl=new JTable(dtm);
	}
	private void addByConstraints(GridBagConstraints gbc,int row,int col,int width,int height,Component cmp)
	{
		gbc.gridx=col;
		gbc.gridy=row;
		gbc.gridwidth=width;
		gbc.gridheight=height;
		empQueryPnl.add(cmp,gbc);
		
	}
	public static void main(String[] args) {
		new MainFrame().setVisible(true);
		SubstanceLookAndFeel.setSkin(new OfficeBlue2007Skin());
	}
}
