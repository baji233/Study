package com.jiuyun.system.control;

import com.jiuyun.system.model.CollectionRecordDao;
import com.jiuyun.system.view.CollectionRecordFrame;
import com.jiuyun.system.vo.CollectionRecordVO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CollectionRecordActionListener implements ActionListener {
    CollectionRecordFrame crf;
    public CollectionRecordActionListener(CollectionRecordFrame  collectionRecordFrame){
        super();
        this.crf=collectionRecordFrame;
    }
    public CollectionRecordActionListener(){
        super();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btnName=e.getActionCommand();
        if("select".equals(btnName)){
            String typeText=crf.typeTextField.getText();
            String timeText=crf.timeTextField.getText();
            String item=(String)crf.typeComboBox.getSelectedItem();
            if(!"".equals(typeText) && !"".equals(timeText)){
                if("读者编号".equals(item)){
                    String sql01="select * from collection_record where rid=? and collectiontime=?";
                    List<CollectionRecordVO> lists=CollectionRecordDao.selectButton01(sql01,typeText,timeText);
                    if(lists!=null){
                        CollectionRecordDao.getFrame(CollectionRecordDao.getTable(lists)).setVisible(true);
                    }
                }else if("读者姓名".equals(item)){
                    String sql02="select * from collection_record where rname=? and collectiontime=?";
                    List<CollectionRecordVO> lists=CollectionRecordDao.selectButton01(sql02,typeText,timeText);
                    if(lists!=null){
                        CollectionRecordDao.getFrame(CollectionRecordDao.getTable(lists)).setVisible(true);
                    }
                }
            }else if("".equals(typeText) && !"".equals(timeText)){
                String sql03="select * from collection_record where collectiontime=?";
                List<CollectionRecordVO> lists=CollectionRecordDao.selectButton02(sql03,timeText);
                if(lists!=null){
                    CollectionRecordDao.getFrame(CollectionRecordDao.getTable(lists)).setVisible(true);
                }
//                JOptionPane.showMessageDialog(null, "读者的编号或姓名不能为空!", "警告",JOptionPane.WARNING_MESSAGE);
            }else if("".equals(timeText) && !"".equals(typeText)){
                if("读者编号".equals(item)) {
                    String sql04 = "select * from collection_record where rid=?";
                    List<CollectionRecordVO> lists=CollectionRecordDao.selectButton03(sql04,typeText);
                    if(lists!=null){
                        CollectionRecordDao.getFrame(CollectionRecordDao.getTable(lists)).setVisible(true);
                    }
                }else if("读者姓名".equals(item)) {
                    String sql05 = "select * from collection_record where rname=?";
                    List<CollectionRecordVO> lists=CollectionRecordDao.selectButton03(sql05,typeText);
                    if(lists!=null){
                        CollectionRecordDao.getFrame(CollectionRecordDao.getTable(lists)).setVisible(true);
                    }
                }
//                JOptionPane.showMessageDialog(null, "收款日期不能为空!", "警告",JOptionPane.WARNING_MESSAGE);
            }else if("".equals(typeText) && "".equals(timeText)){
                JOptionPane.showMessageDialog(null, "请输入信息!!", "警告",JOptionPane.WARNING_MESSAGE);
                return;
            }else{
                JOptionPane.showMessageDialog(null, "^-^滚", "错误",JOptionPane.ERROR_MESSAGE);
                crf.setVisible(false);
            }
        }
    }
}
