package com.jiuyun.system.view;

import com.jiuyun.system.control.AddEmpActionListener;
import com.jiuyun.system.model.DeptDao;
import com.jiuyun.system.vo.DeptInfoVO;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Vector;

/**
 * ��ӹ�Ա��Ϣ�ĶԻ�����
 */
public class AddEmpInfoFrame extends JDialog {
    JLabel lblTitle,lblEmpId,lblEmpName,lblPay,lblJob,lblBirthday,lblDEptId;
    public JTextField txtEmpId,txtEmpName,txtPay,txtJob,txtBirthday;
    public JComboBox cbDept;
    public JButton btnSave,btnCancel;

    //�޲ι��췽���е��ô˶Ի�����
    public AddEmpInfoFrame(){
        this.setSize(300,400);
        initialComponents();
        this.setModal(true);//ָ���˶Ի���Ӧ����ģ̬��(�Ի�������ʾʱ��ֹ���뵽��������)
    }

    //��ʼ�������
    public void initialComponents(){
        lblTitle=new JLabel("��ӹ�Ա�Ի�����");
        lblEmpId=new JLabel("��ԱID");
        lblEmpName=new JLabel("����");
        lblPay=new JLabel("����");
        lblJob=new JLabel("����");
        lblBirthday=new JLabel("����");
        lblDEptId=new JLabel("����ID");
        txtEmpId=new JTextField(10);
        txtEmpName=new JTextField(10);
        txtPay=new JTextField(10);
        txtJob=new JTextField(10);
        txtBirthday=new JTextField(10);

        //��ѯdeptinfo���в���ID������
        List<DeptInfoVO> lstDept=DeptDao.queryDept();
        Vector<String> deptNames=new Vector<>();
        for(DeptInfoVO deptInfoVO:lstDept){
            deptNames.add(deptInfoVO.getDeptId()+"-"+deptInfoVO.getDeptId());//�Ѳ���ID��������ӵ���������,��������ӵ�������
        }
        cbDept=new JComboBox(deptNames);

        //ע�������
        btnSave=new JButton("����");
        btnSave.setActionCommand("save");
        btnCancel=new JButton("ȡ��");
        btnCancel.setActionCommand("cancel");
        AddEmpActionListener addEmpActionListener=new AddEmpActionListener(this);
        btnSave.addActionListener(addEmpActionListener);
        btnCancel.addActionListener(addEmpActionListener);

        //���������
        GridBagLayout gridBagLayout=new GridBagLayout();
        //�����Լ��
        GridBagConstraints gridBagConstraints=new GridBagConstraints();
        this.setLayout(gridBagLayout);
        //��ͼ: ��������ֵ��������Һ������������С���,����������Ĵ�С
        gridBagConstraints.insets=new Insets(8,5,8,5);
        //������������Լ������,�����������������
        /**
         *      lblTitle,lblEmpId,lblEmpName,lblPay,lblJob,lblBirthday,lblDEptId;
         *      txtEmpId,txtEmpName,txtPay,txtJob,txtBirthday;
         *      cbDept;
         *      btnSave,btnCancel;
         */
        addConstraints(gridBagConstraints,0,0,3,1,lblTitle);
        addConstraints(gridBagConstraints,1,0,1,1,lblEmpId);
        addConstraints(gridBagConstraints,1,1,2,1,txtEmpId);
        addConstraints(gridBagConstraints,2,0,1,1,lblEmpName);
        addConstraints(gridBagConstraints,2,1,2,1,txtEmpName);
        addConstraints(gridBagConstraints,3,0,1,1,lblPay);
        addConstraints(gridBagConstraints,3,1,2,1,txtPay);
        addConstraints(gridBagConstraints,4,0,1,1,lblJob);
        addConstraints(gridBagConstraints,4,1,2,1,txtJob);
        addConstraints(gridBagConstraints,5,0,1,1,lblBirthday);
        addConstraints(gridBagConstraints,5,1,2,1,txtBirthday);
        addConstraints(gridBagConstraints,6,0,1,1,lblDEptId);
        addConstraints(gridBagConstraints,6,1,2,1,cbDept);
        addConstraints(gridBagConstraints,7,0,1,1,btnSave);
        addConstraints(gridBagConstraints,7,2,1,1,btnSave);
    }

    //��������Լ��:
    public void addConstraints(GridBagConstraints gridBagConstraints,int row,int col,int width,int  height,Component component){
        gridBagConstraints.gridx=col;//������
        gridBagConstraints.gridy=row;//������
        gridBagConstraints.gridwidth=width;//������
        gridBagConstraints.gridheight=height;//���񳤶�
        this.add(component,gridBagConstraints);
    }
}




























