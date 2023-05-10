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
 * ��Ա��Ϣ������������ʵ����
 */
public class EmpInfoActionListener implements ActionListener {
    MainFrame mainFrame;
    //ʹ���Լ��Ĺ��췽����ȡMainFrameʵ��(ע�������ʱ��Ҫ��MainFrame������Ϊ��������)
    public EmpInfoActionListener(MainFrame mainFrame){
        this.mainFrame=mainFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String btnStr=e.getActionCommand();
        if("add".equals(btnStr)){
            new AddEmpInfoFrame().setVisible(true);//��ʾ��ӹ�Ա��Ϣ�ĶԻ�����
            //��ȡװ��������Ա��Ϣ����������,��ȡ����Ϣ
            Vector<EmpInfo> items=AddEmpActionListener.addEmps;
            for(EmpInfo empInfo:items){
                Vector<String> vector=new Vector<String>();
                vector.add(empInfo.getEmpId());
                vector.add(empInfo.getEmpName());
                vector.add(empInfo.getPay());
                vector.add(empInfo.getJob());
                vector.add(empInfo.getBirthday());
                vector.add(empInfo.getDeptId());
                //���������ı�ģ�ͽ�β�����������Ա��Ϣ
                this.mainFrame.dtm.addRow(vector);
            }
            items.clear();
        }else if("delete".equals(btnStr)){
            //ѡ�б�ѡ���е�����
            int rowIndex02=this.mainFrame.empTab.getSelectedRow();
            if(rowIndex02==-1){
                JOptionPane.showMessageDialog(null,"��ѡ��Ҫ�޸ĵ���!");
                return;
            }else{
                int i=JOptionPane.showConfirmDialog(null,"����!!�㽫��Զʧȥ");
                if(i==JOptionPane.YES_OPTION){
                    //ɾ�����ݿ���Ϣ
                    String empId=(String)this.mainFrame.dtm.getValueAt(rowIndex02,0);
                    boolean flag=EmpDao.deleteEmpById(empId);
                    if(flag==true){
                        //ɾ����ģ����Ϣ
                        this.mainFrame.dtm.removeRow(rowIndex02);
                        JOptionPane.showMessageDialog(null,"ɾ���ɹ�");
                    }else{
                        JOptionPane.showMessageDialog(null,"ɾ��ʧ��");
                    }
                }
            }

        }else if("update".equals(btnStr)){
            int rowIndex01=this.mainFrame.empTab.getSelectedRow();
            if(rowIndex01==-1){//-1Ϊδ����ѡ��ʱ��Ĭ������
                JOptionPane.showMessageDialog(null,"��ѡ��Ҫ�޸ĵ���!");
                return;
            }else{
                //��ȡ����ӡѡ�����޸ĺ���еĵ�Ԫ��ֵ
                String empId=(String)this.mainFrame.dtm.getValueAt(rowIndex01,0);
                String empName=(String)this.mainFrame.dtm.getValueAt(rowIndex01,1);
                System.out.println("ID: "+empId+"����: "+empName);
            }
        }else if("query".equals(btnStr)){

        }
    }

}



















