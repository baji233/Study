package com.jiuyun.system.control;

import com.jiuyun.system.model.BorrowingFeeDao;
import com.jiuyun.system.view.BorrowingFeeFrame;
import com.jiuyun.system.vo.BorrowingFeeVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
                List<BorrowingFeeVO> list=BorrowingFeeDao.getAllBooksReturn();
                Vector<Vector> allVectors=new Vector<>();
                for(BorrowingFeeVO bfe : list){
                    Vector<String> vector=new Vector<>();
                    vector.add(bfe.getRId());//读者编号
                    vector.add(bfe.getRName());//读者姓名
                    vector.add(bfe.getReturnDate());//归还日期(==收款时间)
                    allVectors.add(vector);//上面这三个字段的属性在此表中都是不变的
                }
                Vector<String> v=allVectors.get(0);
                String rId=v.get(0);
                String rName=v.get(1);
                String collectionTime=v.get(2);
                String amountReceivable=bff.receivableText.getText();
                String amountReceived=bff.receivedText.getText();
                final String PAYMENT_TYPE="借书费";
                boolean isSuccess=BorrowingFeeDao.insertInfo(rId,rName,amountReceivable,amountReceived,PAYMENT_TYPE,collectionTime);
                if(isSuccess){
                    JOptionPane.showMessageDialog(null, "操作成功!", "普通提示框",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, "操作失败!", "错误提示框",JOptionPane.ERROR_MESSAGE);
                }
            }
        }else if("cancel".equals(btnName)){
            bff.setVisible(false);
        }
    }
}






















