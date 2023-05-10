package system.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Vector;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class BookInfoFrame extends JFrame {
	

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
		FlowLayout f=new FlowLayout(0);
		f.setHgap(20);
		NavPnl.setLayout(f);
		NavPnl.add(addBtn);
		NavPnl.add(modifyBtn);
		NavPnl.add(delBtn);
	}
    
    JPanel queryPnl;
    JLabel lblmethod,lblInfo;
    JButton queryBtn;
    JComboBox<String> bookInfoBox;
    JTextField txtInfo;
    
    public void initialQuery() {
    	queryPnl=new JPanel();
		lblmethod=new JLabel("选择查询方式");
		Vector<String> items=new Vector<String>();
		items.add("图书名称");
		bookInfoBox=new JComboBox<>(items);
		lblInfo=new JLabel("输入图书信息查询:");
		txtInfo=new JTextField(15);
		queryBtn=new JButton("查询");
		FlowLayout f= new FlowLayout(0);
		f.setHgap(20);
		queryPnl.setLayout(f);
		queryPnl.add(lblmethod);
		queryPnl.add(bookInfoBox);
		queryPnl.add(lblInfo);
		queryPnl.add(txtInfo);
		queryPnl.add(queryBtn);
		queryPnl.setBackground(Color.WHITE);
		
	}

    JTable bookInfo;
    JScrollPane tbSc;
    JPanel bookInfoPnl;
    public void initialBookInfo(){
    	bookInfoPnl=new JPanel();
    	bookInfo=new JTable();
    	tbSc=new JScrollPane(bookInfo);
    	bookInfoPnl.add(tbSc);
    }
    
    

    public void initial(){
    	initialNav();
    	initialQuery();
    	initialBookInfo();
        this.setSize(800,600);
        this.setLocation(300,100);
        this.setLayout(new BorderLayout());
        this.add(NavPnl,BorderLayout.NORTH);
        this.add(queryPnl,BorderLayout.CENTER);
        this.add(bookInfoPnl,BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new BookInfoFrame().setVisible(true);

    }
}
