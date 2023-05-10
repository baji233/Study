/**
 * 
 */
package com.jiuyun.system.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import org.w3c.dom.ls.LSOutput;

import com.jiuyun.system.control.BorrowListener;
import com.jiuyun.system.model.BookInfoDao1;
import com.jiuyun.system.model.BorrowInfoDao;
import com.jiuyun.system.model.ReaderDao;
import com.jiuyun.system.vo.BookInfoVO;
import com.jiuyun.system.vo.BorrowInfoVO;
import com.jiuyun.system.vo.ReaderInfoVO1;

/**
 * @author GG
 * 借阅图书
 */
public class BorrowBook extends JFrame{
	
	JPanel main,up,center,southPanel;//上中下面板
	JLabel readerName;
	public JComboBox name;
	JLabel borrowBook;
	JLabel bookName,bookId,author,publish,pDate,price;
	public JTextField tName;
	public JTextField tId;
	public JTextField tAuthor;
	public JTextField tPublish;
	public JTextField tPDate;
	public JTextField tPrice;
	JButton borrowBtn;//借阅按钮
	
	JTable centerTable;//中部表格
	JButton checkButton;//查询按钮
	
	public BorrowBook() {
		// TODO Auto-generated constructor stub
		initialFrame();//
		initialMain();
	}
	/**
	 * 初始化窗口
	 */
	public void initialFrame() {
		// TODO Auto-generated method stub
		this.setTitle("借阅图书管理");
		this.setSize(800,600);
        this.setLocation(300,100);        
        this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

	}
	/**
	 * 初始化主面板
	 */
	public void initialMain() {
		main = new JPanel(new BorderLayout());
		initialUp();
		initialCenter();
//		JScrollPane sp = new JScrollPane(centerTable);
		JScrollPane sp = new JScrollPane();
		sp.getViewport().add(centerTable);
		//sp.setViewportView(centerTable);
		main.add(sp);
		initialSouth();
		this.add(main);
	}
	/**
	 * 初始化上部面板
	 */
	public void initialUp() {
		// TODO Auto-generated method stub
		up = new JPanel();
		readerName = new JLabel("读者姓名");
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		
		up.setLayout(gbl);
		//查询读者信息,加载
		List<ReaderInfoVO1> lstReader=ReaderDao.queryAllReader();
		Vector<String> names=new Vector<String>();
		for(ReaderInfoVO1 dept:lstReader)
		{
			names.add(dept.getReaderName());
		}
		name=new JComboBox(names);		
		up.add(readerName);
		up.add(name);
		main.add(up, BorderLayout.NORTH);;
	}
	
	static DefaultTableModel model=null;//表格模型
	/**
	 * 初始化中部面板
	 * @param 
	 */
	public void initialCenter() {
		// TODO Auto-generated method stub
		center = new JPanel();
		
		//字段名
		Vector<String>titles = new Vector<>();
		titles.add("图书名称");
		titles.add("图书id");
		titles.add("作者");
		titles.add("出版社");
		titles.add("出版日期");
		titles.add("单价");
		
		//字段值
		List<BookInfoVO>listBook = BookInfoDao1.queryAllBookInfo();
		Vector<Vector>field = new Vector<Vector>();
		for (BookInfoVO bookInfoVO : listBook) {
			Vector<String>r1 = new Vector<String>();
			r1.add(bookInfoVO.getBookName());
			r1.add(bookInfoVO.getBookId());
			r1.add(bookInfoVO.getAuthor());
			r1.add(bookInfoVO.getPublish());
			r1.add(bookInfoVO.getpDate());
			r1.add(bookInfoVO.getPrice());
			
			field.add(r1);
		}
		
		model = new DefaultTableModel(field,titles);
		centerTable = new JTable(model);
		//中部表格注册监听
		
		centerTable.addMouseListener(new TableH());
		//center.add(centerTable);
		//main.add(center,BorderLayout.CENTER);
	}
	class TableH extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
//		System.out.println("jjjj");
		int row ;
		row = centerTable.getSelectedRow();
//		System.out.println(row);
		String bookName,bookId,author,publish,pDate,price;
		bookName = (String)centerTable.getValueAt(row, 0);
		bookId = (String)centerTable.getValueAt(row, 1);
		author = (String)centerTable.getValueAt(row, 2);
		publish = (String)centerTable.getValueAt(row, 3);
		pDate = (String)centerTable.getValueAt(row, 4);
		price = (String)centerTable.getValueAt(row, 5);
		System.out.println(bookName);
		tName.setText(bookName);
		tId.setText(bookId);
		tAuthor.setText(author);
		tPublish.setText(publish);
		tPDate.setText(pDate);
		tPrice.setText(price);
		}
	}
	
	/**
	 * 初始化南部面板
	 */
	private void initialSouth() {
		// TODO Auto-generated method stub
		southPanel = new JPanel();
		GridBagLayout gbl = new GridBagLayout();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 5, 10, 5);
		southPanel.setLayout(gbl);
		borrowBook = new JLabel("借阅书籍");
		borrowBook.setForeground(Color.red);
		Font f = new Font("宋体",Font.BOLD,15);
		borrowBook.setFont(f);
		
		
		bookName = new JLabel("书名");
		bookId = new JLabel("id");
		author = new JLabel("作者");
		publish = new JLabel("出版社");
		pDate = new JLabel("出版日期");
		price = new JLabel("价格");
		tName = new JTextField(15);
		tId = new JTextField(15);
		tAuthor = new JTextField(15);
		tPublish = new JTextField(15);
		tPDate = new JTextField(15);
		tPrice = new JTextField(15);
		
		
		borrowBtn =new JButton("借阅");
		borrowBtn.addActionListener(new BorrowListener(this));
		
		addByConstraints(gbc, 0, 0, 2, 1, borrowBook);
		addByConstraints(gbc, 1, 0, 1, 1, bookName);
		addByConstraints(gbc, 1, 1, 1, 1, tName);
		addByConstraints(gbc, 2, 0, 1, 1, bookId);
		addByConstraints(gbc, 2, 1, 1, 1, tId);
		addByConstraints(gbc, 3, 0, 1, 1, author);
		addByConstraints(gbc, 3, 1, 1, 1, tAuthor);
		addByConstraints(gbc, 4, 0, 1, 1, publish);
		addByConstraints(gbc, 4, 1, 1, 1, tPublish);
		addByConstraints(gbc, 5, 0, 1, 1, pDate);
		addByConstraints(gbc, 5, 1, 1, 1, tPDate);
		addByConstraints(gbc, 6, 0, 1, 1, price);
		addByConstraints(gbc, 6, 1, 1, 1, tPrice);
		addByConstraints(gbc, 7, 0, 2, 1, borrowBtn);
		main.add(southPanel,BorderLayout.SOUTH);
		
	}
	private void addByConstraints(GridBagConstraints gbc,int row,int col,int width,int height,Component cmp)
	{
		gbc.gridx=col;
		gbc.gridy=row;
		gbc.gridwidth=width;
		gbc.gridheight=height;
		southPanel.add(cmp,gbc);
		
	}
	public static void main(String[] args) {
		new BorrowBook().setVisible(true);
		
	}
}
