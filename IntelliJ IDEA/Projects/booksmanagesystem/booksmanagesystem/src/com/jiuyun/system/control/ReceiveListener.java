package com.jiuyun.system.control;

import com.jiuyun.system.view.BackBook;
import com.jiuyun.system.view.BorrowingFeeFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceiveListener implements ActionListener {
    BackBook backBook;
    public ReceiveListener(BackBook backBook) {
        this.backBook=backBook;
    }
    public ReceiveListener() {
        super();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /**
         * 点击结账按钮后，先获取选中行的数据，根据其中returnstate是否归还来判断是否收款还书
         *
         */
            int r=backBook.centerTable.getSelectedRow();
        if("未归还".equals(backBook.field.get(r).get(9))){
            BorrowingFeeFrame borrowingFeeFrame=new BorrowingFeeFrame(backBook);
            borrowingFeeFrame.setVisible(true);
        }else if("已归还".equals(backBook.field.get(r).get(9))){
            JOptionPane.showMessageDialog(null, "这本书已经归还了!!", "警告",JOptionPane.WARNING_MESSAGE);
        }
    }
}