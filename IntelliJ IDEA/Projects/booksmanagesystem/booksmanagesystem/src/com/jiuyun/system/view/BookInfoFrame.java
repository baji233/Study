package com.jiuyun.system.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.jiuyun.system.control.ButtonListener;
import com.jiuyun.system.model.BookInfoDao;
import com.jiuyun.system.model.CategoryDao;
import com.jiuyun.system.model.CommonDao;
import com.jiuyun.system.vo.BookInfoVo0;






public class BookInfoFrame extends JFrame {
	
	int width=800;

    public BookInfoFrame() {
       initial();
    }
    
    JButton addBtn,modifyBtn,delBtn;
    JPanel NavPnl;
    
    public void initialNav() {
    	NavPnl=new JPanel();
		addBtn=new JButton("添加");
		modifyBtn=new JButton("修改");
		delBtn=new JButton("删除");
		addBtn.setActionCommand("add");
		modifyBtn.setActionCommand("modify");
		delBtn.setActionCommand("delete");
		ButtonListener btnLis=new ButtonListener(this);
		addBtn.addActionListener(btnLis);
		modifyBtn.addActionListener(btnLis);
		delBtn.addActionListener(btnLis);
		FlowLayout f=new FlowLayout(0);
		f.setHgap(20);
		NavPnl.setLayout(f);
		NavPnl.add(addBtn);
		NavPnl.add(modifyBtn);
		NavPnl.add(delBtn);
		NavPnl.setPreferredSize(new Dimension(width,40));
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
    
    JPanel queryPnl;
    JLabel lblmethod,lblInfo;
    JButton queryBtn;
    public JComboBox<String> bookInfoBox;
    public JTextField txtInfo;
    public String[] columnNames= {"书名","图书编号","作者","出版社","出版日期","单价","种类id","图书类别","备注"};
    
    public void initialQuery() {
    	queryPnl=new JPanel(new GridBagLayout());
		lblmethod=new JLabel("选择查询方式");
		Vector<String> items=new Vector<String>();
		items.add("全部");
		for (String col : columnNames) {
			items.add(col);
		}
		//items.add("图书名称");
		
		bookInfoBox=new JComboBox<>(items);
		lblInfo=new JLabel("输入图书信息查询:");
		txtInfo=new JTextField(15);
		queryBtn=new JButton("查询");
		queryBtn.setActionCommand("query");
		ButtonListener btnLst =new ButtonListener(this);
		queryBtn.addActionListener(btnLst);
		GridBagConstraints gbc=new GridBagConstraints();
        gbc.fill=GridBagConstraints.BOTH;
		gbc.insets=new Insets(10, 5, 10, 5);
		queryPnl.setBorder(new LineBorder(Color.gray,2));
		queryPnl.setPreferredSize(new Dimension(width,60));
		addByConstraints(queryPnl, gbc, 0, 0, 1, 1, lblmethod);
		addByConstraints(queryPnl, gbc, 0, 1, 1, 1, bookInfoBox);
		addByConstraints(queryPnl, gbc, 0, 2, 1, 1, lblInfo);
		addByConstraints(queryPnl, gbc, 0, 3, 1, 1, txtInfo);
		addByConstraints(queryPnl, gbc, 0, 5, 1, 1, queryBtn);
	}
    

    public JTable bookInfo;
    JScrollPane tbSc;
    JPanel bookInfoPnl;
    public DefaultTableModel tableModel;
    public Object[][] content;
    public void initialBookInfo(){
    	bookInfoPnl=new JPanel();
    	content= tableInput();
    	String sql="SELECT a.*,b.* FROM book a,category b,bookinfo c WHERE a.bookid=c.bookid AND b.categoryid=c.categoryid;";
    	tableModel=new DefaultTableModel(content,columnNames);
    	bookInfo=new JTable(tableModel);
    	tbSc=new JScrollPane(bookInfo);
    	tbSc.setPreferredSize(new Dimension(width,500));
    	bookInfoPnl.add(tbSc);
    }
    
    public static Object[][] tableInput() {
		String sql="SELECT a.*,b.* FROM book a,category b,bookinfo c WHERE a.bookid=c.bookid AND b.categoryid=c.categoryid;";
		List lst=CommonDao.queryInfo(sql, BookInfoVo0.class, "bookinfo.properties",null);
		Object[][] content=new String[lst.size()][9];
		Object o=new Object();
		for (int i = 0; i < lst.size(); i++) {
			BookInfoVo0 binfo=new BookInfoVo0();
			binfo=(BookInfoVo0) lst.get(i);
			content[i][0]=binfo.getBName();
			content[i][1]=binfo.getBId();
			content[i][2]=binfo.getAuthor();
			content[i][3]=binfo.getPublish();
			content[i][4]=binfo.getPDate();
			content[i][5]=binfo.getPrice();
			content[i][6]=binfo.getCategoryId();
			content[i][7]=binfo.getCategoryName();
			content[i][8]=binfo.getExplain();
	
		}
		return content;
	}
    
    private void addByConstraints(JPanel Pnl,GridBagConstraints gbc,int row,int col,int width,int height,Component cmp)
	{
		gbc.gridx=col;
		gbc.gridy=row;
		gbc.gridwidth=width;
		gbc.gridheight=height;
		Pnl.add(cmp,gbc);
	}
    
    

    public void initial(){
    	initialNav();
    	initialQuery();
    	initialBookInfo();
        this.setSize(width+50,600);
        this.setLocation(300,100);
        this.setLayout(new FlowLayout());
        this.add(NavPnl);
        this.add(queryPnl);
        this.add(bookInfoPnl);
    }

    public static void main(String[] args) {
//    	BookInfoVo bv=new BookInfoVo();
//    	System.out.println(bv);
    	//List lst=CategoryDao.queryAllCategory();
    	//System.out.println(lst.get(0).getClass());
        new BookInfoFrame().setVisible(true);
        
    }
}
