package com.jiuyun.system.view;

import com.jiuyun.system.control.AddEmpActionListener;
import com.jiuyun.system.model.DeptDao;
import com.jiuyun.system.vo.DeptInfoVO;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Vector;

/**
 * 添加雇员信息的对话窗口
 */
public class AddEmpInfoFrame extends JDialog {
    JLabel lblTitle,lblEmpId,lblEmpName,lblPay,lblJob,lblBirthday,lblDEptId;
    public JTextField txtEmpId,txtEmpName,txtPay,txtJob,txtBirthday;
    public JComboBox cbDept;
    public JButton btnSave,btnCancel;

    //无参构造方法中调用此对话窗口
    public AddEmpInfoFrame(){
        this.setSize(300,400);
        initialComponents();
        this.setModal(true);//指定此对话框应该是模态的(对话框在显示时阻止输入到其他窗口)
    }

    //初始化总组件
    public void initialComponents(){
        lblTitle=new JLabel("添加雇员对话窗口");
        lblEmpId=new JLabel("雇员ID");
        lblEmpName=new JLabel("名字");
        lblPay=new JLabel("工资");
        lblJob=new JLabel("工作");
        lblBirthday=new JLabel("生日");
        lblDEptId=new JLabel("部门ID");
        txtEmpId=new JTextField(10);
        txtEmpName=new JTextField(10);
        txtPay=new JTextField(10);
        txtJob=new JTextField(10);
        txtBirthday=new JTextField(10);

        //查询deptinfo表中部门ID和名字
        List<DeptInfoVO> lstDept=DeptDao.queryDept();
        Vector<String> deptNames=new Vector<>();
        for(DeptInfoVO deptInfoVO:lstDept){
            deptNames.add(deptInfoVO.getDeptId()+"-"+deptInfoVO.getDeptId());//把部门ID和名字添加到向量数组,并将其添加到下拉框
        }
        cbDept=new JComboBox(deptNames);

        //注册监听器
        btnSave=new JButton("保存");
        btnSave.setActionCommand("save");
        btnCancel=new JButton("取消");
        btnCancel.setActionCommand("cancel");
        AddEmpActionListener addEmpActionListener=new AddEmpActionListener(this);
        btnSave.addActionListener(addEmpActionListener);
        btnCancel.addActionListener(addEmpActionListener);

        //网格袋布局
        GridBagLayout gridBagLayout=new GridBagLayout();
        //网格袋约束
        GridBagConstraints gridBagConstraints=new GridBagConstraints();
        this.setLayout(gridBagLayout);
        //插图: 网格袋布局的上左下右和相邻组件的最小间隔,来控制组件的大小
        gridBagConstraints.insets=new Insets(8,5,8,5);
        //调用添加网格袋约束方法,往网格带布局添加组件
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

    //添加网格袋约束:
    public void addConstraints(GridBagConstraints gridBagConstraints,int row,int col,int width,int  height,Component component){
        gridBagConstraints.gridx=col;//横坐标
        gridBagConstraints.gridy=row;//纵坐标
        gridBagConstraints.gridwidth=width;//网格宽度
        gridBagConstraints.gridheight=height;//网格长度
        this.add(component,gridBagConstraints);
    }
}




























