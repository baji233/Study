package com.jiuyun.system.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

import com.jiuyun.system.view.BookInfoFrame;
import com.jiuyun.system.view.InputInfoFrame;
import com.jiuyun.system.vo.BookInfoVo0;
import com.jiuyun.system.vo.CategoryInfoVo;
import com.jiuyun.system.model.CategoryDao;
import com.jiuyun.system.model.CommonDao;



public class InputInfoListener implements ActionListener{
	InputInfoFrame infoFrame;
	
	public InputInfoListener(InputInfoFrame infoFrame) {
		super();
		this.infoFrame=infoFrame;
	}
	public InputInfoListener() {
		// TODO 自动生成的构造函数存根
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String ename=e.getActionCommand();
		if ("save".equals(ename)) {
			String []info=new String[6];
			for (int i = 0; i < 6; i++) {
				info[i]=infoFrame.txt[i].getText();
				System.out.println(info[i]);
			}
			String cateName=(String) infoFrame.BoxCategory.getSelectedItem();
			String sql1="insert into book values(?,?,?,?,?,?)";
			System.out.println(Arrays.toString(info));
			CommonDao.operModify(sql1, info);
			List lst=CategoryDao.queryAllCategory();
			System.out.println("执行了");
			int cateId=0;
			
			for (int i = 0; i < lst.size(); i++) {
				CategoryInfoVo cvo=(CategoryInfoVo) lst.get(i);
				String cname=cvo.getCateGoryName();
				System.out.println("开始了"+cname);
				cateId++;
				if (cateName.equals(cname)) {
					
					System.out.println("找到了");
					break;
				}
			}
			String[] items=new String[2];
			CategoryInfoVo cvo=(CategoryInfoVo)lst.get(cateId-1);
			items[0]=info[1];
			items[1]=cvo.getCateGoryId();
			System.out.println(lst);
			String sql2="insert into bookinfo values(?,?)";
			CommonDao.operModify(sql2, items);
			
			infoFrame.bookInfoFrame.content=tableInput();
			infoFrame.bookInfoFrame.tableModel.setDataVector(infoFrame.bookInfoFrame.content, infoFrame.bookInfoFrame.columnNames);
			infoFrame.dispose();
		}else if ("cancle".equals(ename)) {
			infoFrame.dispose();
		}
		
	}
	public Object[][] tableInput() {
		String sql="SELECT a.*,b.* FROM book a,category b,bookinfo c WHERE a.bookid=c.bookid AND b.categoryid=c.categoryid;";
		List lst=CommonDao.queryInfo(sql, BookInfoVo0.class,"bookinfo.properties", null);
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

}
