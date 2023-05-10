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
 * ��Ա��Ϣ������
 * @author boboli
 *
 */
public class MainFrame extends JFrame{
	//����ṹ
	JSplitPane mainPane;
	JPanel leftPanel;
	JTabbedPane rightPanel;
	//����������
	JLabel lblDeptTip;
	JTree deptInfoTree;
	//�ұ��������
	JPanel empInfoPnl,deptInfoPnl;
	
	public MainFrame()
	{
		initialMainPanl();
		this.setSize(500,400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	//��ƴ�������ṹ
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
	 * JTree��ʹ��
	 * ��Դ��
	 *    ��Ӱ(key)
	 *      --ϲ��Ƭ
	 *      --�ֲ�Ƭ
	 *    ����
	 *     --���»�
	 *     --�ܽ���
	 *    
	 */
	
	private void initialTree()
	{
		/*
		Hashtable<String, String[]> nodes=new Hashtable<String, String[]>();
		nodes.put("��Ӱ", new String[]{"ϲ��Ƭ","�ֲ�Ƭ"});
		nodes.put("����", new String[]{"���»�","�ܽ���"});
		deptInfoTree=new JTree(nodes);
		*/
		/*
		 * TreeNode--��ʾ���Ľڵ� DefualtMutableTreeNodeĬ��ʵ��
		 */
		DefaultMutableTreeNode root=new DefaultMutableTreeNode("������Ϣ");
		//��ѯ������Ϣ
		List<DeptInfoVO> lstDept=DeptDao.queryAllDept();
		DefaultTreeModel dtm=new DefaultTreeModel(root);
		for(DeptInfoVO dept:lstDept)
		{
			String nodeInfo=dept.getDeptNo()+"-"+dept.getDeptName();
			DefaultMutableTreeNode deptNode=new DefaultMutableTreeNode(nodeInfo);
			root.add(deptNode);
		}
		deptInfoTree=new JTree(root);
		
		//����jtree�����
		//��������ÿһ�㼶�ĸ߶�
		deptInfoTree.setRowHeight(30);
		//��Ⱦ��
		DefaultTreeCellRenderer dcr=(DefaultTreeCellRenderer)deptInfoTree.getCellRenderer();
		//���ñ�ѡ�еı���ɫ
		//dcr.setBackgroundSelectionColor(Color.PINK);
		//û�б�ѡ�еı���ɫ
		//dcr.setBackgroundNonSelectionColor(Color.GRAY);
		//����Ҷ�ӽڵ��ͼƬ
		dcr.setLeafIcon(new ImageIcon("tree\\book.gif"));
		//����֦�ڵ��ʱ��ͼƬ
		dcr.setOpenIcon(new ImageIcon("tree\\folderOpen.gif"));
		//����֦�ڵ�ر�ʽ��ͼƬ
		dcr.setClosedIcon(new ImageIcon("tree\\folderClosed.gif"));
		
	}
	//������
	private void initialLeftPanl()
	{
		leftPanel=new JPanel();
		BorderLayout layout=new BorderLayout();
		leftPanel.setLayout(layout);
		lblDeptTip=new JLabel("���Žṹ");
		//���ṹ
		initialTree();
		//ʹ�ù������
		JScrollPane scrollPnl=new JScrollPane(deptInfoTree);
		scrollPnl.setViewportView(deptInfoTree);
		
		leftPanel.add(lblDeptTip,BorderLayout.NORTH);
		leftPanel.add(scrollPnl,BorderLayout.CENTER);
	}
	//�ұ����
	private void intialRightPanl()
	{
		this.rightPanel=new JTabbedPane();
		
		intialEmpinfoPnl();
		empInfoPnl.setForeground(Color.YELLOW);
		this.deptInfoPnl=new JPanel();
		deptInfoPnl.setForeground(Color.RED);
		
		rightPanel.add("��Ա��Ϣ",empInfoPnl);
		rightPanel.add("������Ϣ",deptInfoPnl);
	}
	
	JSplitPane empCenterPnl;
	JPanel empQueryPnl,empDisplayPnl;
	//��ѯ������Ҫ�����
	JLabel lblQueryTitle;
	JRadioButton jrbByName,jrbByJob;
	ButtonGroup queryGroup;
	JTextField txtName,txtJob;
	JButton btnQuery;
	//��ʾ��Ա��Ϣ��Ҫ�����
	public JTable empTbl;
	
	JPanel empSouthPnl;
	JButton btnAdd,btnUpdate,btnDelete;
	
	//��ʼ����Ա��Ϣ���
	private void intialEmpinfoPnl()
	{
		this.empInfoPnl=new JPanel();
		this.empInfoPnl.setLayout(new BorderLayout());
		
		empCenterPnl=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		empCenterPnl.setDividerLocation(130);
		//������ѯ���
		empQueryPnl=new JPanel();
		GridBagLayout gbl=new GridBagLayout();
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.insets=new Insets(10, 5, 10, 5);
		empQueryPnl.setLayout(gbl);
		
		lblQueryTitle=new JLabel("������ѯ");
		Font f=new Font("����",Font.BOLD,15);
		lblQueryTitle.setFont(f);
		this.jrbByName=new JRadioButton("������",true);
		this.jrbByJob=new JRadioButton("������");
		this.queryGroup=new ButtonGroup();
		queryGroup.add(jrbByName);
		queryGroup.add(jrbByJob);
		txtName=new JTextField(15);
		txtJob=new JTextField(15);
		btnQuery=new JButton("��ѯ");
		
		addByConstraints(gbc, 0, 0, 5, 1, lblQueryTitle);
		addByConstraints(gbc, 1, 0, 1, 1, jrbByName);
		addByConstraints(gbc, 1, 1, 3, 1, txtName);
		addByConstraints(gbc, 2, 0, 1, 1,jrbByJob);
		addByConstraints(gbc, 2, 1, 3, 1, txtJob);
		addByConstraints(gbc, 2, 4, 1, 1, btnQuery);
		//============
		empDisplayPnl =new JPanel();
		empDisplayPnl.setLayout(new BorderLayout());
		//�������
		initialEmpTbl();
		JScrollPane sp=new JScrollPane(empTbl);
		sp.setViewportView(empTbl);
		empDisplayPnl.add(sp);
		
		empCenterPnl.setTopComponent(empQueryPnl);
		empCenterPnl.setBottomComponent(empDisplayPnl);
		
		empInfoPnl.add(empCenterPnl);
		
		//������ť���
		this.empSouthPnl=new JPanel();
		this.btnAdd=new JButton("���");
		this.btnUpdate=new JButton("�޸�");
		this.btnDelete=new JButton("ɾ��");
		this.empSouthPnl.add(btnAdd);
		this.empSouthPnl.add(btnUpdate);
		this.empSouthPnl.add(btnDelete);
		//ע�������
		EmpInfoActionListener empLisener=new EmpInfoActionListener(this);
		this.btnAdd.addActionListener(empLisener);
		this.btnUpdate.addActionListener(empLisener);
		this.btnDelete.addActionListener(empLisener);
		
		
		empInfoPnl.add(empSouthPnl,BorderLayout.SOUTH);
	}
	
	//��ģ��
	public DefaultTableModel dtm=null;
	//����ʹ��
	private void initialEmpTbl()
	{
		//�ֶ�����Ϣ
		/*String []columnNames={"��Ա���","����","нˮ","����","����","����"};
		String [][]datas={{"7210","����","6000","����Ա","1988-12-12","������"},{"7215","����","10000","����Ա","1988-12-5","���Բ�"}};
		empTbl=new JTable(datas,columnNames);
		//������
		Vector<String> titles=new Vector<String>();
		titles.add("��Ա���");
		titles.add("����");
		titles.add("нˮ");
		titles.add("����");
		titles.add("����");
		titles.add("����");
		//�������ݲ���
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
		titles.add("��Ա���");
		titles.add("����");
		titles.add("нˮ");
		titles.add("����");
		titles.add("����");
		titles.add("����");
		
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
