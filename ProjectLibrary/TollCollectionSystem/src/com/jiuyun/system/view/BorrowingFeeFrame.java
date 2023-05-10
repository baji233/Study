package com.jiuyun.system.view;

import com.jiuyun.system.control.BorrowingFeeActionListener;
import com.jiuyun.system.model.BorrowingFeeDao;

import javax.swing.*;
import java.awt.*;

//TODO: 收费功能应该与还书功能对接(表),但由于我没有还书的表,所以做了一个book_return_info表来满足收费功能

/**
 * 结算借书费窗体
 * 规则: 约定日期内还书 || 提前还书->费用为10元/本, 逾期后->每天额外收费1元/本;
 * @author Tanjiawei
 */
public class BorrowingFeeFrame extends JFrame {
        public BorrowingFeeFrame() {
            initialBorrowingFeeFrame();
        }

    /**
     * 初始化此窗体
     */
    JLabel receivableLabel,receivedLabel,changeLabel;
    public JTextField receivableText,receivedText,changeText;
    JButton payButton,cancelButton;
    private void initialBorrowingFeeFrame(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("借书费用结算");
        this.setSize(400,250);
        this.setLocation(720,330);
        GridBagLayout gridBagLayout=new GridBagLayout();
        GridBagConstraints gridBagConstraints=new GridBagConstraints();
        gridBagConstraints.insets=new Insets(2,1,2,1);
        this.setLayout(gridBagLayout);

        receivableLabel=new JLabel("应 收 金 额 ￥");
        receivedLabel=new JLabel("实 收 金 额 ￥");
        changeLabel=new JLabel("找 零 金 额 ￥");
        receivableText=new JTextField(10);
        receivedText=new JTextField(10);
        changeText=new JTextField(10);
        //获取应收金额
        long payReceivable=BorrowingFeeDao.getReceivable();
        String str=String.valueOf(payReceivable);
        receivableText.setText(str);
        receivableText.setEditable(false);
        changeText.setEditable(false);
        payButton=new JButton("缴费");
        cancelButton=new JButton("取消");
        Font lblFont=new Font("宋体",Font.BOLD,30);
        Font txtFont=new Font("宋体",Font.BOLD,20);
        Font btnFont=new Font("宋体",Font.BOLD,15);
        receivableText.setBackground(new Color(182, 250, 249));
        changeText.setBackground(new Color(0xFFCCF0));
        receivableLabel.setFont(lblFont);
        receivedLabel.setFont(lblFont);
        changeLabel.setFont(lblFont);
        receivableText.setFont(txtFont);
        receivedText.setFont(txtFont);
        changeText.setFont(txtFont);
        payButton.setFont(btnFont);
        cancelButton.setFont(btnFont);
        receivableText.setHorizontalAlignment(JTextField.CENTER);
        receivedText.setHorizontalAlignment(JTextField.CENTER);
        changeText.setHorizontalAlignment(JTextField.CENTER);
        BorrowingFeeActionListener bfal=new BorrowingFeeActionListener(this);
        payButton.setActionCommand("pay");
        cancelButton.setActionCommand("cancel");
        payButton.addActionListener(bfal);
        cancelButton.addActionListener(bfal);

        addByConstraints(gridBagConstraints,0,0,1,1,receivableLabel);
        addByConstraints(gridBagConstraints,1,0,1,1,receivableText);
        addByConstraints(gridBagConstraints,0,2,1,1,receivedLabel);
        addByConstraints(gridBagConstraints,1,2,1,1,receivedText);
        addByConstraints(gridBagConstraints,0,4,1,1,changeLabel);
        addByConstraints(gridBagConstraints,1,4,1,1,changeText);
        addByConstraints(gridBagConstraints,0,6,1,1,payButton);
        addByConstraints(gridBagConstraints,1,6,1,1,cancelButton);

    }

    private void addByConstraints(GridBagConstraints gridBagConstraints,int row,int col,int width,int height,Component component) {
        gridBagConstraints.gridx=row;
        gridBagConstraints.gridy=col;
        gridBagConstraints.gridwidth=width;
        gridBagConstraints.gridheight=height;
        this.add(component,gridBagConstraints);
    }

    public static void main(String[] args){
        /**
         * 测试
         */
        new BorrowingFeeFrame().setVisible(true);
    }
}











