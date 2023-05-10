package com.jiuyun.system.control;

import com.jiuyun.system.model.BorrowingFeeDao;
import com.jiuyun.system.view.BorrowingFeeFrame;
import com.jiuyun.system.vo.BorrowInfoVO;
import com.jiuyun.system.vo.BorrowingFeeVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;

public class BorrowingFeeActionListener implements ActionListener {
    BorrowingFeeFrame bff;
    public BorrowingFeeActionListener(BorrowingFeeFrame bff){
        super();
        this.bff = bff;
    }
    public BorrowingFeeActionListener(){super();}

    @Override
    public void actionPerformed(ActionEvent e) {
        String btnName=e.getActionCommand();
        if("pay".equals(btnName)){
            if("".equals(bff.receivedText.getText())){
                JOptionPane.showMessageDialog(null, "没钱赚!", "警告提示框",JOptionPane.WARNING_MESSAGE);
            }else{
                //为找零文本框设置显示的值
                float change= BorrowingFeeDao.getChange(bff);
                String str=String.valueOf(change);
                bff.changeText.setText(str);
                //将新的收款记录插入collection_record表
                int i=bff.backBook.centerTable.getSelectedRow();
                List<BorrowInfoVO> list=BorrowingFeeDao.getAllBooksReturn(String.valueOf(bff.backBook.field.get(i).get(12)));
                Vector<Vector> allVectors=new Vector<>();
                for(BorrowInfoVO bfe : list){
                    Vector<String> vector=new Vector<>();
                    vector.add(bfe.getReaderId());//读者编号
                    vector.add(bfe.getReaderName());//读者姓名
                    Date date = new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    String stime =sdf.format(date);//获取当前时间(还书日期)
                    vector.add(stime);//归还日期(==收款时间)
                    allVectors.add(vector);//上面这三个字段的属性在此表中都是不变的
                }
                Vector<String> v=allVectors.get(0);
                String rId=v.get(0);
                String rName=v.get(1);
                String collectionTime=v.get(2);
                final String PAYMENT_TYPE="借书费";
                String amountReceivable=bff.receivableText.getText();
                String amountReceived=bff.receivedText.getText();
                //如果实收金额小于应收金额，则还书失败
                int receivable=Integer.parseInt(bff.receivableText.getText());
                int received=Integer.parseInt(bff.receivedText.getText());
                if (received<receivable) {
                    JOptionPane.showMessageDialog(null, "应收金额不够，还书失败!!!", "普通提示框",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    boolean isSuccess=BorrowingFeeDao.insertInfo(rId,amountReceivable,amountReceived,PAYMENT_TYPE,collectionTime);
                    if(isSuccess){
                        JOptionPane.showMessageDialog(null, "操作成功!", "普通提示框",JOptionPane.INFORMATION_MESSAGE);
                        //还书成功后更改状态
                        BorrowingFeeDao.changeState(bff);
                    }else{
                        JOptionPane.showMessageDialog(null, "操作失败!", "错误提示框",JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }else if("cancel".equals(btnName)){
            bff.setVisible(false);
        }
    }
}






















