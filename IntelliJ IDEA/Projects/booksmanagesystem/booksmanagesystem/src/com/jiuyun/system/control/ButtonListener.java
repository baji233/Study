package com.jiuyun.system.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

import com.jiuyun.system.view.BookInfoFrame;
import com.jiuyun.system.view.InputInfoFrame;
import com.jiuyun.system.view.ModifyInfoFrame;
import com.jiuyun.system.vo.BookInfoVo0;
import com.jiuyun.system.model.BookInfoDao;

import com.jiuyun.system.model.CommonDao;

public class ButtonListener implements ActionListener{
	BookInfoFrame bookInfoFrame;
	
	public ButtonListener(BookInfoFrame bokBookInfoFrame) {
		this.bookInfoFrame=bokBookInfoFrame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String ename=e.getActionCommand();
		if ("modify".equals(ename)) {
			ModifyInfoFrame infoFrame=new ModifyInfoFrame(bookInfoFrame);
			infoFrame.setVisible(true);
			int row=bookInfoFrame.bookInfo.getSelectedRow();
			System.out.println(row);
			for (int i = 0; i < bookInfoFrame.content[row].length-3; i++) {
				infoFrame.txt[i].setText((String) bookInfoFrame.content[row][i]);;
			}
			infoFrame.BoxCategory.setSelectedItem(bookInfoFrame.content[row][7]);
			System.out.println(Arrays.toString (bookInfoFrame.content[row]));
			
		}else if ("delete".equals(ename)) {
			Object[][] obj=bookInfoFrame.tableInput();
			int r=bookInfoFrame.bookInfo.getSelectedRow();
			String bookId=(String) obj[r][1];
			String cateId=(String) obj[r][6];
			bookInfoFrame.tableModel.removeRow(r);
			String sql2="delete from bookinfo where bookid=?";
			CommonDao.operModify(sql2, bookId);
			String sql1="delete from book where bookid=?";
			CommonDao.operModify(sql1, bookId);
			
			
		}else if ("add".equals(ename)) {
			new InputInfoFrame(bookInfoFrame).setVisible(true);
		}else if ("query".equals(ename)) {
			String field=props.getProperty((String) bookInfoFrame.bookInfoBox.getSelectedItem());
			String value=bookInfoFrame.txtInfo.getText();
			if ("1".equals(field)) {
				value="1";
			}
			String sql="SELECT a.*,b.* FROM book a,category b,bookinfo c WHERE a.bookid=c.bookid AND b.categoryid=c.categoryid AND "+field+"=?;";
			List<BookInfoVo0> lst=CommonDao.queryInfo(sql, BookInfoVo0.class,"bookinfo.properties", value);
			String[][] content= new String[lst.size()][9];
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
			
			bookInfoFrame.content=content;
			bookInfoFrame.tableModel.setDataVector(bookInfoFrame.content, bookInfoFrame.columnNames);
		}
	}
	
	public static Properties props=null;

    static {
        props = loadProps();
    }

    public static Properties loadProps() {
        Properties props=null;
        try {
            FileInputStream fis=new FileInputStream("bookinfo.properties");
            props=new Properties();
            props.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return props;
    }
    public static void main(String[] args) {
		
	}
}
