package com.jiuyun.system.view;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.jiuyun.system.control.InputInfoListener;
import com.jiuyun.system.model.CategoryDao;
import com.jiuyun.system.vo.CategoryInfoVo;

public class InputInfoFrame extends JFrame{
	public BookInfoFrame bookInfoFrame=new BookInfoFrame();
	
	public InputInfoFrame(BookInfoFrame bookInfoFrame) {
		this.bookInfoFrame=bookInfoFrame;
		initial();
		initialInfo();
	}
	public InputInfoFrame() {
		// TODO 自动生成的构造函数存根
	}
	int width=500;
	
	JLabel[] lbl;
	public JTextField[] txt;
	JButton btnSave,btnCancle;
	public JComboBox<String> BoxCategory;
	
	public void initialInfo() {
		lbl=new JLabel[7];
		txt=new JTextField[6];
		for (int i = 0; i < txt.length; i++) {
			txt[i]=new JTextField(15);
		}
		lbl[0]=new JLabel("书名");
		lbl[1]=new JLabel("图书编号");
		lbl[2]=new JLabel("作者");
		lbl[3]=new JLabel("出版社");
		lbl[4]=new JLabel("出版日期");
		lbl[5]=new JLabel("单价");
		lbl[6]=new JLabel("图书类型");
		btnSave=new JButton("保存");
		btnCancle=new JButton("取消");
		btnSave.setActionCommand("save");
		btnCancle.setActionCommand("cancle");
		InputInfoListener inpuLis=new InputInfoListener(this);
		btnSave.addActionListener(inpuLis);
		btnCancle.addActionListener(inpuLis);
		
		GridBagLayout gbl=new GridBagLayout();
		this.setLayout(gbl);
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.insets=new Insets(5, 5, 5, 5);
		addByConstrants(gbc, 0, 0, 1, 1, lbl[0]);
		addByConstrants(gbc, 0, 1, 2, 1, txt[0]);
		addByConstrants(gbc, 1, 0, 1, 1, lbl[1]);
		addByConstrants(gbc, 1, 1, 2, 1, txt[1]);
		addByConstrants(gbc, 2, 0, 1, 1, lbl[2]);
		addByConstrants(gbc, 2, 1, 2, 1, txt[2]);
		addByConstrants(gbc, 3, 0, 1, 1, lbl[3]);
		addByConstrants(gbc, 3, 1, 2, 1, txt[3]);
		addByConstrants(gbc, 4, 0, 1, 1, lbl[4]);
		addByConstrants(gbc, 4, 1, 2, 1, txt[4]);
		addByConstrants(gbc, 5, 0, 1, 1, lbl[5]);
		addByConstrants(gbc, 5, 1, 2, 1, txt[5]);
		Vector<String> items=new Vector<String>();
		List lst=CategoryDao.queryAllCategory();
		for (int i = 0; i < lst.size(); i++) {
			CategoryInfoVo categoryInfoVo=(CategoryInfoVo) lst.get(i);
			items.add(categoryInfoVo.getCateGoryName());
		}
		BoxCategory=new JComboBox<String>(items);
		addByConstrants(gbc, 7, 0, 1, 1, lbl[6]);
		addByConstrants(gbc, 7, 1, 2, 1, BoxCategory);
		addByConstrants(gbc, 8, 1, 1, 1, btnSave);
		addByConstrants(gbc, 8, 2, 1, 1, btnCancle);
		
		
	}
	
	private void addByConstrants(GridBagConstraints gbc,int row,int col,int width,int heitght,Component cmp) {
		gbc.gridx=col;
		gbc.gridy=row;
		gbc.gridheight=heitght;
		gbc.gridwidth=width;
		this.add(cmp,gbc);
	}
	
	public void initial(){
        this.setSize(width,600);
        this.setLocation(500,100);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	public static void main(String[] args) {
		new InputInfoFrame().setVisible(true);
	}
}
