package com.jiuyun.system.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.jiuyun.system.model.EmpInfoDao;
import com.jiuyun.system.view.AddEmpInfoFrame;
import com.jiuyun.system.view.MainFrame;
import com.jiuyun.system.vo.EmpinfoVO;

public class EmpInfoActionListener implements ActionListener{
	MainFrame mainFrame;
	public EmpInfoActionListener(MainFrame mainFrame) {
		this.mainFrame=mainFrame;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String btnName=e.getActionCommand();
		if("???".equals(btnName))
		{
			//???????????????????
			new AddEmpInfoFrame().setVisible(true);
			Vector<EmpinfoVO> items=AddEmpActionListener.addEmps;
			//???????????,???????
			for(EmpinfoVO emp:items)
			{
				Vector<String> r1=new Vector<String>();
				r1.add(emp.getEmpNo());
				r1.add(emp.getEname());
				r1.add(emp.getSalary());
				r1.add(emp.getJob());
				r1.add(emp.getBirthday());
				r1.add(emp.getDname());
				this.mainFrame.dtm.addRow(r1);
			}
			items.clear();
		}else if("???".equals(btnName)){
			
			
			//?????§Ö???????
			int rowIndex=mainFrame.empTbl.getSelectedRow();
			if(rowIndex==-1)
			{
				JOptionPane.showMessageDialog(null, "????????????");
				return;
			}
			//???????§Ö??????
			String empId=(String)this.mainFrame.dtm.getValueAt(rowIndex, 0);
			String ename=(String)this.mainFrame.dtm.getValueAt(rowIndex, 1);
			System.out.println(empId+" "+ename);
		}else if("???".equals(btnName)){
			//?????§Ö???
			int rowIndex=mainFrame.empTbl.getSelectedRow();
			if(rowIndex==-1)
			{
				JOptionPane.showMessageDialog(null, "?????????????");
				return;
			}
			int value=JOptionPane.showConfirmDialog(null, "????????");
			if(value==JOptionPane.YES_OPTION)
			{
				//??????????
				String eno=(String)mainFrame.dtm.getValueAt(rowIndex, 0);
				boolean flag=EmpInfoDao.deleteEmpByID(eno);
				if(flag==true)
				{
					//??????
					mainFrame.dtm.removeRow(rowIndex);
					JOptionPane.showMessageDialog(null, "??????");
				}else{
					JOptionPane.showMessageDialog(null, "??????");
				}
			}
		}else if("???".equals(btnName)){
			
		}
	}

}
