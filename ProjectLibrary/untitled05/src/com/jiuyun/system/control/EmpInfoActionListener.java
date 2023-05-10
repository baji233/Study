package com.jiuyun.system.control;

import com.jiuyun.system.model.EmpDao;
import com.jiuyun.system.view.AddEmpInfoFrame;
import com.jiuyun.system.view.MainFrame;
import com.jiuyun.system.vo.EmpInfo;
import jdk.nashorn.internal.scripts.JO;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * 雇员信息表动作监听器的实现类
 */
public class EmpInfoActionListener implements ActionListener {
    MainFrame mainFrame;
    //使用自己的构造方法获取MainFrame实例(注册监听器时需要将MainFrame对象作为参数传入)
    public EmpInfoActionListener(MainFrame mainFrame){
        this.mainFrame=mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btnStr=e.getActionCommand();
        if("add".equals(btnStr)){
            new AddEmpInfoFrame().setVisible(true);//显示添加雇员信息的对话窗口
            //获取装有新增雇员信息的向量数组,并取出信息
            Vector<EmpInfo> items=AddEmpActionListener.addEmps;
            for(EmpInfo empInfo:items){
                Vector<String> vector=new Vector<String>();
                vector.add(empInfo.getEmpId());
                vector.add(empInfo.getEmpName());
                vector.add(empInfo.getPay());
                vector.add(empInfo.getJob());
                vector.add(empInfo.getBirthday());
                vector.add(empInfo.getDeptId());
                //向主面板里的表模型结尾行添加新增雇员信息
                this.mainFrame.dtm.addRow(vector);
            }
            items.clear();
        }else if("delete".equals(btnStr)){
            //选中被选中行的索引
            int rowIndex02=this.mainFrame.empTab.getSelectedRow();
            if(rowIndex02==-1){
                JOptionPane.showMessageDialog(null,"请选中要修改的行!");
                return;
            }else{
                int i=JOptionPane.showConfirmDialog(null,"警告!!你将永远失去");
                if(i==JOptionPane.YES_OPTION){
                    //删除数据库信息
                    String empId=(String)this.mainFrame.dtm.getValueAt(rowIndex02,0);
                    boolean flag=EmpDao.deleteEmpById(empId);
                    if(flag==true){
                        //删除表模型信息
                        this.mainFrame.dtm.removeRow(rowIndex02);
                        JOptionPane.showMessageDialog(null,"删除成功");
                    }else{
                        JOptionPane.showMessageDialog(null,"删除失败");
                    }
                }
            }

        }else if("update".equals(btnStr)){
            int rowIndex01=this.mainFrame.empTab.getSelectedRow();
            if(rowIndex01==-1){//-1为未做出选择时的默认索引
                JOptionPane.showMessageDialog(null,"请选中要修改的行!");
                return;
            }else{
                //获取并打印选中且修改后的行的单元格值
                String empId=(String)this.mainFrame.dtm.getValueAt(rowIndex01,0);
                String empName=(String)this.mainFrame.dtm.getValueAt(rowIndex01,1);
                System.out.println("ID: "+empId+"姓名: "+empName);
            }
        }else if("query".equals(btnStr)){

        }
    }

}



















