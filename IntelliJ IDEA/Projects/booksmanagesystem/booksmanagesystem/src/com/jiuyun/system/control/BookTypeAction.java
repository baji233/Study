package com.jiuyun.system.control;

import com.jiuyun.system.model.BookTypeDao;
import com.jiuyun.system.view.BookTypeInfoView;
import com.jiuyun.system.vo.CategoryInfoVo;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class BookTypeAction implements ActionListener {
    BookTypeInfoView bookTypeInfoView;
    JLabel labelBookTypeId;
    JLabel labelBookTypeName;
    JTextField txtBookTypeId;
    JTextField txtBookTypeName;
    public BookTypeAction(BookTypeInfoView bookTypeInfoView){
        this.bookTypeInfoView=bookTypeInfoView;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        DefaultMutableTreeNode parentNode = bookTypeInfoView.parentNode;
        DefaultMutableTreeNode selectNode = bookTypeInfoView.selectNode;
        String nameBtn = e.getActionCommand();
        if("deleteBookType".equals(nameBtn)){
            String userObject = (String) selectNode.getUserObject();
            String s = userObject.split("\\*")[0];
            if(!"".equals(s)&&JOptionPane.showConfirmDialog(bookTypeInfoView,"是否删除该结点及其下的所有子节点")==0) {
                CategoryInfoVo tmp=new CategoryInfoVo();
                tmp.setCateGoryStructure(s);
                if (BookTypeDao.remove(tmp)) {
                    JOptionPane.showMessageDialog(null, "删除成功");
                    parentNode.remove(selectNode);
                } else {
                    JOptionPane.showMessageDialog(null, "删除失败");
                }
            }
        } else if ("addSameCategoryBT".equals(nameBtn)) {
            if(addDialog()) {
                parentNode.add(new DefaultMutableTreeNode(txtBookTypeId.getText() + "*" + txtBookTypeName.getText()));
                JOptionPane.showMessageDialog(null,"添加成功");
                isSuccess=false;
            }
        }else if("addChildBookType".equals(nameBtn)){
            if(addDialog()) {
                selectNode.add(new DefaultMutableTreeNode(txtBookTypeId.getText() + "*" + txtBookTypeName.getText()));
                JOptionPane.showMessageDialog(null,"添加成功");
                isSuccess=false;
            }
        }else if("updateBookType".equals(nameBtn)){
            if(updateDialog()) {
                String userObject = (String) selectNode.getUserObject();
                String structure=userObject.split("\\*")[0];
                selectNode.setUserObject(structure+"*"+txtBookTypeName.getText());
                JOptionPane.showMessageDialog(null,"修改成功");
                isSuccess=false;
            }
        }
        //刷新树
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                bookTypeInfoView.bookTypeTree.updateUI();
            }
        });
    }

    boolean isSuccess;

    private boolean addDialog(){
        JDialog dialogAdd=new JDialog(bookTypeInfoView,"增加图书类别",true);
        dialogAdd.setBounds(300,240,200,200);
        //添加组件
        JPanel panelAdd;
        Box boxAdd;
        Box boxBookTypeId;
        Box boxBookTypeName;

        labelBookTypeId=new JLabel("类别编号");
        txtBookTypeId=new JTextField(10);
        boxBookTypeId=Box.createHorizontalBox();
        boxBookTypeId.add(labelBookTypeId);
        boxBookTypeId.add(txtBookTypeId);

        labelBookTypeName=new JLabel("类别名称");
        txtBookTypeName=new JTextField(10);
        boxBookTypeName=Box.createHorizontalBox();
        boxBookTypeName.add(labelBookTypeName);
        boxBookTypeName.add(txtBookTypeName);

        JButton btnSave = new JButton("保存");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //提交到数据库
                CategoryInfoVo tmp=new CategoryInfoVo();
                tmp.setCateGoryStructure(txtBookTypeId.getText());
                tmp.setCateGoryName(txtBookTypeName.getText());
                BookTypeAction.this.isSuccess = BookTypeDao.addBookType(tmp);
                //销毁窗体
                dialogAdd.dispose();
            }
        });

        boxAdd=Box.createVerticalBox();
        boxAdd.add(Box.createVerticalStrut(10));
        boxAdd.add(boxBookTypeId);
        boxAdd.add(Box.createVerticalStrut(10));
        boxAdd.add(boxBookTypeName);
        boxAdd.add(Box.createVerticalStrut(10));
        boxAdd.add(btnSave);

        panelAdd=new JPanel();
        panelAdd.add(boxAdd);
        dialogAdd.add(panelAdd);
        dialogAdd.pack();
        dialogAdd.setVisible(true);

        //添加至数据库
        return isSuccess;
    }

    CategoryInfoVo tmp;
    private boolean updateDialog(){
        JDialog dialogUpdate=new JDialog(bookTypeInfoView,"修改图书类别",true);
        dialogUpdate.setBounds(300,240,200,200);
        //添加组件
        JPanel panelAdd;
        Box boxAdd;
        Box boxBookTypeName;

        //新的类别名称
        labelBookTypeName=new JLabel("新类别名称");
        txtBookTypeName=new JTextField(10);
        boxBookTypeName=Box.createHorizontalBox();
        boxBookTypeName.add(labelBookTypeName);
        boxBookTypeName.add(txtBookTypeName);

        //旧的类别名称
        String userObject = (String) bookTypeInfoView.selectNode.getUserObject();
        tmp=new CategoryInfoVo();
        tmp.setCateGoryStructure(userObject.split("\\*")[0]);
        tmp.setCateGoryName(userObject.split("\\*")[1]);
        //刷新
        tmp=BookTypeDao.queryBookType(tmp);

        JButton btnSave = new JButton("保存");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //提交到数据库
                BookTypeAction.this.tmp.setCateGoryName(txtBookTypeName.getText());
                isSuccess = BookTypeDao.setBookType(tmp);
                tmp=null;
                dialogUpdate.dispose();
            }
        });

        boxAdd=Box.createVerticalBox();
        boxAdd.add(Box.createVerticalStrut(10));
        boxAdd.add(boxBookTypeName);
        boxAdd.add(Box.createVerticalStrut(10));
        boxAdd.add(btnSave);

        panelAdd=new JPanel();
        panelAdd.add(boxAdd);
        dialogUpdate.add(panelAdd);
        dialogUpdate.pack();
        dialogUpdate.setVisible(true);

        //添加至数据库
        return isSuccess;
    }
}
