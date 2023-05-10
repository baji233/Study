package system.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

import system.control.QuireListener;

public class MainFrame extends JFrame{
	JTabbedPane jtp;
	JPanel leftPnl,northPnl,bookPnl,readerPnl,borrowPnl,quirePnl;
	JTabbedPane southPnl;
	JSplitPane splitPane1,splitPane2;
	JButton leftBtn[],rightBtn[];
	JLabel lblbook,lblreader,lblborrow,lblinquire;
	
	/*
	 * 主页面调用初始化各个panel的方法初始化页面
	 */
	public MainFrame() {
		initial();
		initialLeftPnl();
		initialRightPnl();
		System.out.println(lblReaderq.getName());
	}
	
	
	/*
	 * 用分割面板splitPane1将整体分割成左边和右边两部分，左边是一个leftPnl右边又是一个分割面板splitPane2
	 * 左边用分割面板分割成两个部分也就是splitPane2面板被分为northPnl和southPnl
	 * leftPnl添加两个按钮“换班登录”和“退出系统”
	 * 
	 */
	
	public void initialLeftPnl() {
		leftPnl=new JPanel();
		splitPane1=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane2=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		splitPane2.setDividerLocation(300);
		splitPane1.setDividerLocation(100);
		splitPane1.setDividerSize(3);
		splitPane1.setEnabled(false);
		leftBtn=new JButton[2];
		
		leftBtn[0]=new JButton("换班登录");
		leftBtn[1]=new JButton("退出系统");
		for (int i = 0; i < leftBtn.length; i++) {
			leftBtn[i].setSize(100, 30);
		}
		
		FlowLayout f=new FlowLayout();
		f.setVgap(30);
		leftPnl.setLayout(f);
		for (int i = 0; i < leftBtn.length; i++) {
			leftPnl.add(leftBtn[i]);
		}
		
		splitPane1.setLeftComponent(leftPnl);
		splitPane1.setRightComponent(splitPane2);
		
		this.setLayout(new BorderLayout());
		this.add(splitPane1);
	}
	
	public void initialRightPnl() {
		northPnl=new JPanel();
		bookPnl=new JPanel();
		borrowPnl=new JPanel();
		quirePnl=new JPanel();
		readerPnl=new JPanel();
		southPnl=new JTabbedPane(JTabbedPane.NORTH);
		rightBtn=new JButton[4];
		rightBtn[0]=new JButton("借阅图书");
		rightBtn[1]=new JButton("归还图书");
		rightBtn[2]=new JButton("续借图书");
		rightBtn[3]=new JButton("借阅查询");
		for (int i = 0; i < rightBtn.length; i++) {
			rightBtn[i].setBounds(0, 0, 50, 50);
		}
		northPnl.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.insets=new Insets(10, 5, 10, 5);
		addByConstraints(northPnl,gbc, 0, 0, 1, 1, rightBtn[0]);
		addByConstraints(northPnl,gbc, 0, 2, 1, 1, rightBtn[1]);
		addByConstraints(northPnl,gbc, 1, 1, 1, 1, rightBtn[2]);
		addByConstraints(northPnl,gbc, 1, 3, 1, 1, rightBtn[3]);
		
		
		southPnl.add("查询管理",quirePnl);
		southPnl.add("图书管理",bookPnl);
		southPnl.add("读者管理",readerPnl);
		southPnl.add("借阅查询",borrowPnl);
		initialQuirePnl();
		splitPane2.setTopComponent(northPnl);
		splitPane2.setBottomComponent(southPnl);
	}
	
	public JLabel lblBookq,lblReaderq,lblBorrowq,lblReceiptq,lblInfo[];
	
	public void initialQuirePnl() {
		lblBookq=new JLabel("图书信息查询",JLabel.LEFT);
		lblReaderq=new JLabel("读者信息查询",JLabel.LEFT);
		lblBorrowq=new JLabel("借阅查询",JLabel.LEFT);
		lblReceiptq=new JLabel("收款记录查询",JLabel.LEFT);
		lblBookq.addMouseListener(new QuireListener(this));
		lblReaderq.addMouseListener(new QuireListener(this));
		lblBorrowq.addMouseListener(new QuireListener(this));
		lblReceiptq.addMouseListener(new QuireListener(this));
		lblInfo=new JLabel[4];
		lblBookq.setName("bookq");
		lblReaderq.setName("readerq");
		lblBorrowq.setName("borrowq");
		lblReceiptq.setName("receiptq");
		lblInfo[0]=new JLabel("详细信息");
		lblInfo[1]=new JLabel("详细信息");
		lblInfo[2]=new JLabel("详细信息");
		lblInfo[3]=new JLabel("详细信息");
		GridBagConstraints gbc=new GridBagConstraints();
		gbc.insets=new Insets(10, 5, 10, 50);
		quirePnl.setLayout(new GridBagLayout());
		
		addByConstraints(quirePnl, gbc, 0, 0, 2, 1, lblBookq);
		addByConstraints(quirePnl, gbc, 0, 2, 4, 1, lblInfo[0]);
		addByConstraints(quirePnl, gbc, 1, 0, 2, 1, lblReaderq);
		addByConstraints(quirePnl, gbc, 1, 2, 4, 1, lblInfo[1]);
		addByConstraints(quirePnl, gbc, 2, 0, 2, 1, lblBorrowq);
		addByConstraints(quirePnl, gbc, 2, 2, 4, 1, lblInfo[2]);
		addByConstraints(quirePnl, gbc, 3, 0, 2, 1, lblReceiptq);
		addByConstraints(quirePnl, gbc, 3, 2, 4, 1, lblInfo[3]);
		
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
        this.setSize(800,600);
        this.setLocation(300,100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
	public static void main(String[] args) {
		new MainFrame().setVisible(true);
		
	}
	
}
