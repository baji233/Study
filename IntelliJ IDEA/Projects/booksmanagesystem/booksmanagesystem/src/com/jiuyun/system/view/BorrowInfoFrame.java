package com.jiuyun.system.view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.jiuyun.system.model.BorrowInfoDao;
import com.jiuyun.system.vo.BorrowInfoVO;

public class BorrowInfoFrame extends JFrame {
	JPanel main,northPanel,centerPanel;//主面板,北部面白,中部面板
	JTable centerTable;//中部表格
	JLabel keyLabel;//关键字标签
	JTextField keyField;//关键字文本框
	JButton keyButton ;//关键字搜索
	
	public BorrowInfoFrame() {
		// TODO Auto-generated constructor stub
		initialFrame();
		initialMainPanel();
	}
	/**
	 * 初始化窗体
	 * @param 
	 */
	private void initialFrame() {
		// TODO Auto-generated method stub
		this.setTitle("图书借阅历史查询");
		this.setLocation(500, 300);
		this.setSize(800, 500);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	private void initialMainPanel() {
		// TODO Auto-generated method stub
		main = new JPanel(new BorderLayout());//初始化主面板
		
		initialNorth();
		initialCenter();
		JScrollPane sp = new JScrollPane(centerTable);
		sp.setViewportView(centerTable);
		main.add(sp);
		this.add(main);
	}
	/**
	 * 初始化北部面板
	 */
	private void initialNorth() {
		// TODO Auto-generated method stub
		northPanel = new JPanel();
		keyField = new JTextField(16);
		keyLabel = new JLabel("关键字");
		keyButton = new JButton("搜索");
		northPanel.add(keyLabel);
		northPanel.add(keyField);
		northPanel.add(keyButton);
		main.add(northPanel,BorderLayout.NORTH);
	}
	public DefaultTableModel model=null;//表格模型
	/**
	 * 初始化中部面板
	 * @param 
	 */
	private void initialCenter() {
		// TODO Auto-generated method stub
		centerPanel = new JPanel();
		//字段名
		Vector<String>titles = new Vector<>();
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
		//字段值
		List<BorrowInfoVO>listBorrow = BorrowInfoDao.queryAllBorrowInfo();
		Vector<Vector>field = new Vector<Vector>();
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
			r1.add(borrowInfoVO.getReturnState());
			r1.add(borrowInfoVO.getReturnTime());
			r1.add(borrowInfoVO.getComment());
			field.add(r1);
		}
		
		model = new DefaultTableModel(field,titles);
		centerTable = new JTable(model);
		centerPanel.add(centerTable);
		main.add(centerPanel,BorderLayout.CENTER);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new BorrowInfoFrame().setVisible(true);
	}

}
