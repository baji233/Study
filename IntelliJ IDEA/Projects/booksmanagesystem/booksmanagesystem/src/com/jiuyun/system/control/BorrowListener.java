package com.jiuyun.system.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.jiuyun.system.model.CommonDao;
import com.jiuyun.system.vo.BorrowInfoVO;
import com.jiuyun.system.vo.ReaderInfoVO;
import com.jiuyun.system.view.BorrowBook;

public class BorrowListener implements ActionListener{
	public BorrowListener() {
		// TODO Auto-generated constructor stub
	}
	BorrowBook borrowBook;
	public BorrowListener(BorrowBook borrowBook) {
		// TODO Auto-generated constructor stub
		this.borrowBook=borrowBook;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub3
		String id= borrowBook.tId.getText();
		String name=(String) borrowBook.name.getSelectedItem();
//		System.out.println(name);
		String[]s=new String[8];
		s[1]=id;//书id
		
		String sql0 = "select readerid from readerinfotable where name='"+name+"'";
		
		List<ReaderInfoVO> lst= CommonDao.queryInfo(sql0, ReaderInfoVO.class,"ReaderInfoVO.properties", null);
//		System.out.println(lst.size());
		s[0]=lst.get(0).getReaderId();//读者id
		String rid= lst.get(0).getReaderId();
		
		//获取系统时间
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String time =sdf.format(date);
		s[2] = time;
		//获取延迟后时间
		Calendar curr = Calendar.getInstance();
		curr.set(Calendar.MONTH,curr.get(Calendar.MONTH)+2);
		Date date1=curr.getTime();
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
		String time1 = sdf1.format(date1);
		s[3]=time1;
//		System.out.println(sdf+"\t"+sdf1);
		s[4]="未归还";
		s[5]=null;
		s[6]=null;
		String sql2 ="select * from borrowinfo";
		List<BorrowInfoVO> lst1 =CommonDao.queryInfo(sql2, BorrowInfoVO.class,"BorrowInfoVO.properties", null);
		int i= lst1.size()+1;
		System.out.println(i);
		System.out.println("bbbbbb"+Integer.toString(i));
		s[7]=Integer.toString(i);
		String a= "INSERT INTO borrowinfo VALUES (?,?,?,?,?,?,?,?)";
		for (int j = 0; j < s.length; j++) {
			System.out.println(s[j]+"\t");
		}
		CommonDao.operModify(a, s);
	}
	
}
