package com.jiuyun.system.view;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jiuyun.system.control.AddEmpActionListener;
import com.jiuyun.system.model.DeptDao;
import com.jiuyun.system.vo.DeptInfoVO;

public class AddEmpInfoFrame extends JDialog{
	JLabel lblTitle,lblEmpno,lblName,lblJob,lblSal,lblBirth,lblDept;
	public JTextField txtEmpno,txtName,txtJob,txtSal,txtBirth;
	public JComboBox cb_Dept;
	JButton btnSave,btnCancel;
	public AddEmpInfoFrame()
	{
		this.setSize(300,400);
		
		intitalComponents();
		this.setModal(true);
	}
	
	private void intitalComponents()
	{
		lblTitle=new JLabel("添加雇员信息");
		lblEmpno=new JLabel("雇员编号");
		lblName=new JLabel("姓名");
		lblJob=new JLabel("工作");
		lblSal=new JLabel("薪水");
		lblBirth=new JLabel("生日");
		lblDept=new JLabel("所在部门");
		txtEmpno=new JTextField(10);
		txtName=new JTextField(10);
		txtJob=new JTextField(10);
		txtSal=new JTextField(10);
		txtBirth=new JTextField(10);
		//查询部门信息,加载
		List<DeptInfoVO> lstDept=DeptDao.queryAllDept();
		Vector<String> dnames=new Vector<String>();
		for(DeptInfoVO dept:lstDept)
		{
			dnames.add(dept.getDeptNo()+"-"+dept.getDeptName());
		}
		cb_Dept=new JComboBox(dnames);
		
		btnSave=new JButton("保存");
		btnCancel=new JButton("取消");
		
		//注册监听器
		AddEmpActionListener addEmpLis=new AddEmpActionListener(this);
		btnSave.addActionListener(addEmpLis);
		btnCancel.addActionListener(addEmpLis);
		
		GridBagLayout gbl=new GridBagLayout();
		GridBagConstraints gbc=new GridBagConstraints();
		this.setLayout(gbl);
		gbc.insets=new Insets(8, 5, 8, 5);
		addByConstraints(gbc,0,0,3,1,lblTitle);
		addByConstraints(gbc,1,0,1,1,lblEmpno);
		addByConstraints(gbc,1,1,2,1,txtEmpno);
		addByConstraints(gbc,2,0,1,1,lblName);
		addByConstraints(gbc,2,1,2,1,txtName);
		addByConstraints(gbc,3,0,1,1,lblJob);
		addByConstraints(gbc,3,1,2,1,txtJob);
		addByConstraints(gbc,4,0,1,1,lblSal);
		addByConstraints(gbc,4,1,2,1,txtSal);
		addByConstraints(gbc,5,0,1,1,lblBirth);
		addByConstraints(gbc,5,1,2,1,txtBirth);
		addByConstraints(gbc,6,0,1,1,lblDept);
		addByConstraints(gbc,6,1,2,1,cb_Dept);
		addByConstraints(gbc,7,0,1,1,btnSave);
		addByConstraints(gbc,7,2,1,1,btnCancel);
	}
	
	private void addByConstraints(GridBagConstraints gbc,int row,int col,int width,int height,Component cmp)
	{
		gbc.gridx=col;
		gbc.gridy=row;
		gbc.gridwidth=width;
		gbc.gridheight=height;
		this.add(cmp,gbc);
		
	}
	
}
