package com.jiuyun.system.control;

import com.jiuyun.system.model.ReaderInfoDao;
import com.jiuyun.system.model.ReaderTypeDao;
import com.jiuyun.system.view.AddReaderView;
import com.jiuyun.system.view.ReaderInfoView;
import com.jiuyun.system.vo.ReTypeInfoVO;
import com.jiuyun.system.vo.ReaderInfoVO;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.Vector;

public class AddReaderAction implements ItemListener,ActionListener{
    AddReaderView addReaderView;
    //传入所监视的窗口
    public AddReaderAction(AddReaderView addReaderView){
        this.addReaderView=addReaderView;
    }
    @Override
    public void itemStateChanged(ItemEvent e) {
        Object selectedItem = addReaderView.cateCom.getSelectedItem();
        List<ReTypeInfoVO> data = ReaderTypeDao.queryReType();
        //一次改变事件调用了两次函数
        //Selected和当前事件的stateChanged去比较
        if(ItemEvent.SELECTED==e.getStateChange()){
            for(ReTypeInfoVO tmp:data){
                if(selectedItem.equals(tmp.getReTypename())){
                    //设置对应参数
                    addReaderView.boQuanContent.setText(tmp.getMaxBook());
                    addReaderView.boTimeContent.setText(tmp.getBorrowTime());
                    addReaderView.validTimeContent.setText(tmp.getValidTime());
                    break;
                }
            }
        }
//        System.out.println(ItemEvent.SELECTED+"-"+e.getStateChange()+"123");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btnName = e.getActionCommand();
        if("saveReader".equals(btnName)){
            //封装成vo对象
            ReaderInfoVO readerInfo=new ReaderInfoVO();
            readerInfo.setReaderId(addReaderView.arrayField[0].getText());
            readerInfo.setName(addReaderView.arrayField[1].getText());
            readerInfo.setAge(addReaderView.arrayField[2].getText());
            readerInfo.setSex(addReaderView.arrayField[3].getText());
            readerInfo.setIdCard(addReaderView.arrayField[4].getText());
            readerInfo.setWorkLocation(addReaderView.arrayField[5].getText());
            readerInfo.setPhone(addReaderView.arrayField[6].getText());
            readerInfo.setE_mail(addReaderView.arrayField[7].getText());
            readerInfo.setDepartment(addReaderView.arrayField[8].getText());

            readerInfo.setIsBorrow(addReaderView.isBorrowBtn.isSelected()?"是":"否");
            readerInfo.setLossState((String) addReaderView.stateLossCBox.getSelectedItem());
            readerInfo.setBirth(addReaderView.birthDatePicker.getText());
            readerInfo.setRegisterDate(addReaderView.registerDate.getText());

            //将新数据的读者类型名称与数据库里的读者类型名称做比较，将相同的那一项的读者类型id取出，并置入vo对象
            List<ReTypeInfoVO> reTypeInfoVO = ReaderTypeDao.queryReType();
            String reTypeId=null;
            //遍历集合，找到与选中的读者类型相同的读者类型编号
            for(ReTypeInfoVO tmp:reTypeInfoVO){
                if(addReaderView.cateCom.getSelectedItem().equals(tmp.getReTypename())){
                    reTypeId= tmp.getReTypeId();
                    break;
                }
            }
            readerInfo.setReTypeId(reTypeId);
            if(ReaderInfoDao.addReaderInfo(readerInfo)){
                JOptionPane.showMessageDialog(null,"保存成功");
                updateTableMethod(readerInfo);
            }else{
                JOptionPane.showMessageDialog(null,"保存失败");
            }
        }else if("exit".equals(btnName)){
            addReaderView.dispose();
        }
    }



    /**
     * 更新表格
     * @param readerInfo
     */
    public void updateTableMethod(ReaderInfoVO readerInfo){
        //获得该JDialog对象的owner使用者对象，并以此为桥梁得到需更新的表格模型
        ReaderInfoView owner = (ReaderInfoView) addReaderView.getOwner();
        Vector rowData=new Vector();
        //将新增加的读者按顺序依次添加到vector中
        rowData.add(readerInfo.getReaderId());
        rowData.add(readerInfo.getName());
        rowData.add(readerInfo.getBorrowNum());
        rowData.add(readerInfo.getIsBorrow());
        rowData.add(readerInfo.getSex());
        rowData.add(readerInfo.getAge());
        rowData.add(readerInfo.getBirth());
        //获取当前面板选中的读者类型
        rowData.add(addReaderView.cateCom.getSelectedItem());
        rowData.add(readerInfo.getRegisterDate());
        rowData.add(readerInfo.getExpireTime());
        rowData.add(readerInfo.getIdCard());
        rowData.add(readerInfo.getPhone());
        rowData.add(readerInfo.getE_mail());
        rowData.add(readerInfo.getWorkLocation());
        rowData.add(readerInfo.getDepartment());
        rowData.add(readerInfo.getLossState());
        rowData.add(readerInfo.getOperator());
        owner.readerInfoTbModel.addRow(rowData);
    }
}
