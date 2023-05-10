package com.jiuyun.system.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.jiuyun.system.model.EmpInfoDao;
import com.jiuyun.system.util.CommonDao;
import com.jiuyun.system.view.AddEmpInfoFrame;
import com.jiuyun.system.vo.EmpinfoVO;

/**
 * ������������
 *
 */
public class AddEmpActionListener implements ActionListener{
	 private AddEmpInfoFrame addEmpFrame;
	 public static Vector<EmpinfoVO> addEmps=new Vector<EmpinfoVO>();
	 public AddEmpActionListener(AddEmpInfoFrame addEmpFrame) {
		this.addEmpFrame=addEmpFrame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String name=e.getActionCommand();
		if("����".equals(name))
		{
			//����������Ϣ
			String empno=addEmpFrame.txtEmpno.getText();
			String ename=addEmpFrame.txtName.getText();
			String job=addEmpFrame.txtJob.getText();
			String sal=addEmpFrame.txtSal.getText();
			String birth=addEmpFrame.txtBirth.getText();
			String deptInfo=(String)addEmpFrame.cb_Dept.getSelectedItem();
			String deptno=deptInfo.split("-")[0];
			EmpinfoVO emp=new EmpinfoVO(empno,ename,sal,job,birth,deptno);
			//����dao�����¼
			boolean f=EmpInfoDao.saveEmpInfo(emp);
			if(f)
			{
				JOptionPane.showMessageDialog(null, "����ɹ�!");
				addEmps.add(emp);
			}
		}else{
			addEmpFrame.dispose();
		}
	}

}
