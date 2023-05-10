package system.control;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import system.view.BookInfoFrame;
import system.view.MainFrame;

public class QuireListener implements MouseListener{
	
	MainFrame mainFrame;
	
	public QuireListener(MainFrame mainframe) {
		// TODO 自动生成的构造函数存根
		super();
		this.mainFrame=mainframe;
	}
	
	public QuireListener() {
		// TODO 自动生成的构造函数存根
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO 自动生成的方法存根
		JLabel event=new JLabel();
		event=(JLabel)e.getSource();
		if("bookq".equals(event.getName())){
			BookInfoFrame bookInfoFrame=new BookInfoFrame();
			bookInfoFrame.setVisible(true);
			System.out.println("you clicked label 10");
		}
		if ("readerq".equals(event.getName())) {
			System.out.println(2);
		}
		if ("borrowq".equals(event.getName())) {
			System.out.println(3);
		}
		if ("receiptq".equals(event.getName())) {
			System.out.println(4);
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO 自动生成的方法存根
		JLabel event=new JLabel();
		event=(JLabel)e.getSource();
		event.setForeground(Color.blue);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO 自动生成的方法存根
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO 自动生成的方法存根
		JLabel event=new JLabel();
		event=(JLabel)e.getSource();
		event.setForeground(Color.blue);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO 自动生成的方法存根
		JLabel event=new JLabel();
		event=(JLabel)e.getSource();
		event.setForeground(Color.black);
	}
	
}
