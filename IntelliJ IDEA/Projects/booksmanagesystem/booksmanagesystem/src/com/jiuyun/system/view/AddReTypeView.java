package com.jiuyun.system.view;

import com.jiuyun.system.model.ReaderTypeDao;
import com.jiuyun.system.vo.ReTypeInfoVO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//增加读者类型信息的窗口
public class AddReTypeView extends JDialog {
    JLabel labelReaderGrade;
    //可借最大本数
    JLabel labelBorrowQuantity;
    //一本书能借的最大时长
    JLabel labelBorrowTime;
    //证件有效时长
    JLabel labelValidTime;
    JLabel labelReTypeId;

    JTextField txtReaderGrade;
    JTextField txtBorrowQuantity;
    JTextField txtBorrowTime;
    JTextField txtValidTime;
    JTextField txtReTypeId;
    Box mainBox;
    JButton saveBtn;

    public AddReTypeView(JDialog dialog,String title,boolean modal){
        super(dialog,title,modal);
        initialStyle();
        JPanel mainPanel=new JPanel();
        initialMainPanel();
        mainPanel.add(mainBox);
        mainPanel.setBackground(Color.white);
        this.setSize(400,400);
        this.add(mainPanel);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    }

    public void initialStyle(){
        this.setLocation(200,100);
    }



    public void initialMainPanel() {
        mainBox = Box.createVerticalBox();
        Box boxReTypeID = Box.createHorizontalBox();
        labelReTypeId = new JLabel("类型编号");
        txtReTypeId = new JTextField(10);
        boxReTypeID.add(labelReTypeId);
        boxReTypeID.add(txtReTypeId);

        Box boxReaderGrade = Box.createHorizontalBox();
        labelReaderGrade = new JLabel("读者类型");
        txtReaderGrade = new JTextField(10);
        boxReaderGrade.add(labelReaderGrade);
        boxReaderGrade.add(txtReaderGrade);

        Box boxBorrowQuantity = Box.createHorizontalBox();
        labelBorrowQuantity=new JLabel("可借数量");
        txtBorrowQuantity=new JTextField(10);
        boxBorrowQuantity.add(labelBorrowQuantity);
        boxBorrowQuantity.add(txtBorrowQuantity);

        Box boxBorrowTime=Box.createHorizontalBox();
        labelBorrowTime=new JLabel("持书时间");
        txtBorrowTime=new JTextField(10);
        boxBorrowTime.add(labelBorrowTime);
        boxBorrowTime.add(txtBorrowTime);

        Box boxValidTime=Box.createHorizontalBox();
        labelValidTime=new JLabel("有效时间");
        txtValidTime=new JTextField(10);
        boxValidTime.add(labelValidTime);
        boxValidTime.add(txtValidTime);

        mainBox.add(Box.createVerticalStrut(50));
        mainBox.add(boxReTypeID);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(boxReaderGrade);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(boxBorrowQuantity);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(boxBorrowTime);
        mainBox.add(Box.createVerticalStrut(10));
        mainBox.add(boxValidTime);
        mainBox.add(Box.createVerticalStrut(10));


        saveBtn=new JButton("保存");
        mainBox.add(saveBtn);
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ReTypeInfoVO tmpReType=new ReTypeInfoVO();
                tmpReType.setReTypeId(txtReTypeId.getText());
                tmpReType.setReTypename(txtReaderGrade.getText());
                tmpReType.setBorrowTime(txtBorrowTime.getText());
                tmpReType.setMaxBook(txtBorrowQuantity.getText());
                tmpReType.setValidTime(txtValidTime.getText());
                if(ReaderTypeDao.insertReType(tmpReType)){
                    JOptionPane.showMessageDialog(null,"保存成功");
                    //得到传入的父窗口对象
                    AddReaderView owner = (AddReaderView) AddReTypeView.this.getOwner();
                    //通过父窗口对象获取到类型选择下拉框
                    owner.cateCom.addItem(txtReaderGrade.getText());
                }else{
                    JOptionPane.showMessageDialog(null,"保存失败");
                }
            }
        });
    }

    public static void main(String[] args) {
        new AddReTypeView(null,"读者等级维护",true);
    }
}
