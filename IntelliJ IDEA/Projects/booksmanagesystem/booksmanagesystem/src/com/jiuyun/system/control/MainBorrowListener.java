package com.jiuyun.system.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.jiuyun.system.view.BackBook;
import com.jiuyun.system.view.BorrowBook;
import com.jiuyun.system.view.BorrowInfoFrame;
import com.jiuyun.system.view.CollectionRecordFrame;
import com.jiuyun.system.vo.CollectionRecordVO;

public class MainBorrowListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		String name=e.getActionCommand();
		if ("borrow".equals(name)) {
			BorrowBook borrowBook=new BorrowBook();
			borrowBook.setVisible(true);
		}else if ("back".equals(name)) {
			BackBook backBook=new BackBook();
			backBook.setVisible(true);
		}else if ("borrowq".equals(name)) {
			BorrowInfoFrame borrowInfoFrame=new BorrowInfoFrame();
			borrowInfoFrame.setVisible(true);
		}
	}
}
