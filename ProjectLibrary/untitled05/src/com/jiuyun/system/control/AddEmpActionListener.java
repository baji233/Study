package com.jiuyun.system.control;

import com.jiuyun.system.model.EmpDao;
import com.jiuyun.system.view.AddEmpInfoFrame;
import com.jiuyun.system.vo.EmpInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * 监听新增信息
 */
public class AddEmpActionListener implements ActionListener {
    private AddEmpInfoFrame addEmpInfoFrame;
    //用于存放输入新增的雇员信息的向量数组,大家都可以调用
    public static Vector<EmpInfo> addEmps=new Vector<EmpInfo>();
    //使用构造方法将添加雇员对话窗口的实例作为参数传入this.addEmpInfoFrame获得其引用(固定操作!)
    public AddEmpActionListener(AddEmpInfoFrame addEmpInfoFrame){
        this.addEmpInfoFrame=addEmpInfoFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name=e.getActionCommand();
        if("save".equals(name)){
            //获取输入的信息:txtEmpId,txtEmpName,txtPay,txtJob,txtBirthday;
            String empId=addEmpInfoFrame.txtEmpId.getText();
            String empName=addEmpInfoFrame.txtEmpName.getText();
            String pay=addEmpInfoFrame.txtPay.getText();
            String job=addEmpInfoFrame.txtJob.getText();
            String birthday=addEmpInfoFrame.txtBirthday.getText();
            String deptInfo=(String)addEmpInfoFrame.cbDept.getSelectedItem();//返回当前下拉框选定的项目(xxx-xxxxx)
            String deptId=deptInfo.split("-")[0];//围绕-拆分此字符串,以此来获取拆分后索引为0的deptId
            //将雇员信息存入EmpInfo
            EmpInfo empInfo=new EmpInfo(empId,empName,pay,job,birthday,deptId);
            //调用EmpDao保存雇员信息
            boolean isSuccess=EmpDao.saveEmpInfo(empInfo);
            if(isSuccess){
                JOptionPane.showMessageDialog(null,"成功!");//父组件为空
                addEmps.add(empInfo);
            }
        }else if("cancel".equals(name)){
            addEmpInfoFrame.dispose();//释放并销毁
        }
    }
}





















