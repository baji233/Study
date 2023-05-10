package com.jiuyun.system.control;

import com.jiuyun.system.model.EmpDao;
import com.jiuyun.system.view.AddEmpInfoFrame;
import com.jiuyun.system.vo.EmpInfo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

/**
 * ����������Ϣ
 */
public class AddEmpActionListener implements ActionListener {
    private AddEmpInfoFrame addEmpInfoFrame;
    //���ڴ�����������Ĺ�Ա��Ϣ����������,��Ҷ����Ե���
    public static Vector<EmpInfo> addEmps=new Vector<EmpInfo>();
    //ʹ�ù��췽������ӹ�Ա�Ի����ڵ�ʵ����Ϊ��������this.addEmpInfoFrame���������(�̶�����!)
    public AddEmpActionListener(AddEmpInfoFrame addEmpInfoFrame){
        this.addEmpInfoFrame=addEmpInfoFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name=e.getActionCommand();
        if("save".equals(name)){
            //��ȡ�������Ϣ:txtEmpId,txtEmpName,txtPay,txtJob,txtBirthday;
            String empId=addEmpInfoFrame.txtEmpId.getText();
            String empName=addEmpInfoFrame.txtEmpName.getText();
            String pay=addEmpInfoFrame.txtPay.getText();
            String job=addEmpInfoFrame.txtJob.getText();
            String birthday=addEmpInfoFrame.txtBirthday.getText();
            String deptInfo=(String)addEmpInfoFrame.cbDept.getSelectedItem();//���ص�ǰ������ѡ������Ŀ(xxx-xxxxx)
            String deptId=deptInfo.split("-")[0];//Χ��-��ִ��ַ���,�Դ�����ȡ��ֺ�����Ϊ0��deptId
            //����Ա��Ϣ����EmpInfo
            EmpInfo empInfo=new EmpInfo(empId,empName,pay,job,birthday,deptId);
            //����EmpDao�����Ա��Ϣ
            boolean isSuccess=EmpDao.saveEmpInfo(empInfo);
            if(isSuccess){
                JOptionPane.showMessageDialog(null,"�ɹ�!");//�����Ϊ��
                addEmps.add(empInfo);
            }
        }else if("cancel".equals(name)){
            addEmpInfoFrame.dispose();//�ͷŲ�����
        }
    }
}





















