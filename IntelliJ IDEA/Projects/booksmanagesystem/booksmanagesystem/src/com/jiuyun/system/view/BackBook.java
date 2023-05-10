package com.jiuyun.system.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.jiuyun.system.control.ReceiveListener;
import com.jiuyun.system.model.BorrowInfoDao;
import com.jiuyun.system.model.CommonDao;
import com.jiuyun.system.vo.BorrowInfoVO;

public class BackBook extends JFrame{
	
	JPanel northPanel,centerPanel,southPanel;//北部,中间面板
	
	public BackBook() {
		// TODO Auto-generated constructor stub
		initialFrame();
		initialNorth();
		initialCenter();
		initialSouth();
	}
	private void initialFrame() {
		// TODO Auto-generated method stub
		this.setTitle("退还图书管理");
		this.setSize(800,600);
        this.setLocation(300,100);        
        this.setLayout(new BorderLayout());//窗口设置为边缘布局
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

	}
	/**
	 * 北部布局
	 */
	private void initialNorth() {
		// TODO Auto-generated method stub
		northPanel  = new JPanel();
		JLabel borrowInfo = new JLabel("借阅信息");
		northPanel.add(borrowInfo);
		
		this.add(northPanel,BorderLayout.NORTH);
	}
	
	public DefaultTableModel model = null;
	public JTable centerTable ;
	public Vector<Vector>field;
	public List<BorrowInfoVO>listBorrow;
	/**
	 * 中部布局
	 */
	public Vector<String>titles;
	private void initialCenter() {
		// TODO Auto-generated method stub
		centerPanel = new JPanel(new BorderLayout());
		
		//字段名
		titles = new Vector<>();
		titles.add("读者编号");
		titles.add("读者姓名");
		titles.add("读者性别");
		titles.add("图书编号");
		titles.add("图书名称");
		titles.add("出版社");
		titles.add("单价");
		titles.add("借出时间");
		titles.add("应还时间");
		titles.add("是否归还");
		titles.add("还书时间");
		titles.add("备注");
		titles.add("借阅id");
		getTable();
		model = new DefaultTableModel(field,titles);
		centerTable = new JTable(model);
		
		JScrollPane jsp = new JScrollPane(centerTable);
		centerPanel.add(jsp);
//		centerPanel.add(borrowInfo,BorderLayout.NORTH);
		this.add(centerPanel,BorderLayout.CENTER);
	}
	/**
	 * 获取借阅表
	 */
	public void getTable() {
		// TODO Auto-generated method stub
		//字段值
		listBorrow = BorrowInfoDao.queryAllBorrowInfo();
		field = new Vector<Vector>();
		for (BorrowInfoVO borrowInfoVO : listBorrow) {
			Vector<String>r1 = new Vector<String>();
			r1.add(borrowInfoVO.getReaderId());
			r1.add(borrowInfoVO.getReaderName());
			r1.add(borrowInfoVO.getReaderSex());
			r1.add(borrowInfoVO.getBookId());
			r1.add(borrowInfoVO.getBookName());
			r1.add(borrowInfoVO.getBookPublish());
			r1.add(borrowInfoVO.getBookPrice());
			r1.add(borrowInfoVO.getOutOfTime());
			r1.add(borrowInfoVO.getShouldReturnDate());
			r1.add(borrowInfoVO.getReturnState());//归还状态，索引9
			r1.add(borrowInfoVO.getReturnTime());
			r1.add(borrowInfoVO.getComment());
			r1.add(borrowInfoVO.getBorrowId());
			field.add(r1);
		}
	}
	public JButton backBookBtn;
	private void initialSouth() {
		// TODO Auto-generated method stub
		backBookBtn = new JButton("结账");
		backBookBtn.addActionListener(new ReceiveListener(this) {
			

		});
		southPanel = new JPanel();
		southPanel.add(backBookBtn);
		this.add(southPanel,BorderLayout.SOUTH);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BackBook().setVisible(true);;
	}

}
