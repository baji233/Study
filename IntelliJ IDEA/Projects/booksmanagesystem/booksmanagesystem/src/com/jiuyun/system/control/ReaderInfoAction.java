package com.jiuyun.system.control;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.eltima.components.ui.DatePicker;
import com.jiuyun.system.model.ReaderInfoDao;
import com.jiuyun.system.model.ReaderTypeDao;
import com.jiuyun.system.view.AddReaderView;
import com.jiuyun.system.view.ReaderInfoView;
import com.jiuyun.system.vo.ReTypeInfoVO;
import com.jiuyun.system.vo.ReaderInfoVO;

public class ReaderInfoAction implements ActionListener{
	ReaderInfoView readerInfoView;
    public ReaderInfoAction(ReaderInfoView readerInfoView){
        this.readerInfoView=readerInfoView;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO 自动生成的方法存根
		
		String nameBtn = e.getActionCommand();
        if("query".equals(nameBtn)){
            queryReaderMethod();
        } else if ("addReaderInfo".equals(nameBtn)) {
            new AddReaderView(readerInfoView,"添加读者信息",true);
        }else if("deleteReaderInfo".equals(nameBtn)){
            if(JOptionPane.showConfirmDialog(null,"是否删除当前选中的信息")==JOptionPane.OK_OPTION){
                if(deleteReaderMethod()){
                    JOptionPane.showMessageDialog(null,"删除成功");
                }else{
                    JOptionPane.showMessageDialog(null,"删除失败");
                }
            }
        }else if("updateReaderInfo".equals(nameBtn)){
            updateReaderInfo();
        }
	}
	
	public void queryReaderMethod(){
        int index = readerInfoView.queryCondition.getSelectedIndex();
        String text = readerInfoView.txtQuery.getText();
        DefaultTableModel tempModel = readerInfoView.readerInfoTbModel;
        //如果文本框为空，则将表数据重置为原始数据。
        if("".equals(text)){
            readerInfoView.readerInfoTable.setModel(readerInfoView.readerInfoTbModel);
            setTableStyle();
            return;
        }

        int count = tempModel.getColumnCount();
        //将列标识符导出
        Vector<String> titlesVector=new Vector<>();
        for(int i=0;i<count;i++){
            titlesVector.add(tempModel.getColumnName(i));
        }

        if(index==1){
            //将符合匹配的数据导出
            Vector<Vector> newReadInfoData=new Vector<>();
            Vector<Vector> dataVector = tempModel.getDataVector();
            for(Vector tmp:dataVector){
                if(text.equals(tmp.get(0))){
                    newReadInfoData.add(tmp);
                    break;
                }
            }
            //生成所查询数据的表模型,并且调用表的setModel方法，使表呈现新数据，同时没有改变表的原始数据
            DefaultTableModel newModel=new DefaultTableModel(newReadInfoData,titlesVector);
            readerInfoView.readerInfoTable.setModel(newModel);
        }else if(index==2){
            //将符合匹配的数据导出
            Vector<Vector> newReadInfoData=new Vector<>();
            Vector<Vector> dataVector = tempModel.getDataVector();
            for(Vector tmp:dataVector){
                if(text.equals(tmp.get(1))){
                    newReadInfoData.add(tmp);
                }
            }
            DefaultTableModel newModel=new DefaultTableModel(newReadInfoData,titlesVector);
            readerInfoView.readerInfoTable.setModel(newModel);
        }else if(index==0){
            Vector<Vector> newReadInfoData=new Vector<>();
            Vector<Vector> dataVector = tempModel.getDataVector();
            for(Vector tmp:dataVector){
                if(text.equals(tmp.get(1))||text.equals(tmp.get(0))||text.equals(tmp.get(4))){
                    newReadInfoData.add(tmp);
                }
            }
            DefaultTableModel newModel=new DefaultTableModel(newReadInfoData,titlesVector);
            readerInfoView.readerInfoTable.setModel(newModel);
        }
        setTableStyle();
    }

    public void setTableStyle(){
        for(int i=0;i<readerInfoView.readerInfoTable.getColumnCount();i++){
            String columnName = readerInfoView.readerInfoTable.getColumnName(i);
            readerInfoView.readerInfoTable.getColumn(columnName).setPreferredWidth(40);
        }

        TableColumn c1 = readerInfoView.readerInfoTable.getColumn("生日");
        c1.setPreferredWidth(70);
        TableColumn c2 = readerInfoView.readerInfoTable.getColumn("到期日期");
        c2.setPreferredWidth(70);
        TableColumn c3 = readerInfoView.readerInfoTable.getColumn("注册日期");
        c3.setPreferredWidth(70);
    }

    //删除当前选中的行
    public boolean deleteReaderMethod(){
        //捕获当前JTable的model模型中的选中行
        JTable tempTable = readerInfoView.readerInfoTable;
        int selectedRow = tempTable.getSelectedRow();
        DefaultTableModel tempModel = (DefaultTableModel)tempTable.getModel();
        String id =  (String) tempModel.getValueAt(selectedRow, 0);
        tempModel.removeRow(selectedRow);
        //同时删除表的初始数据
        deleteOriginalData(id);
        //提交到数据库
        return ReaderInfoDao.deleteReaderById(id);
    }

    /**
     * 删除表的原始数据
     */
    public void deleteOriginalData(String id){
        DefaultTableModel tempModel = readerInfoView.readerInfoTbModel;
        Vector<Vector> dataVector = tempModel.getDataVector();
        int index=0;
        for(Vector tmp:dataVector){
            if(id.equals( tmp.get(0))){
                int selectedRow=index;
                tempModel.removeRow(selectedRow);
                break;
            }
            index++;
        }
    }

    public void updateReaderInfo(){
        JDialog updateDialog=new JDialog(readerInfoView,"修改读者信息",true);
        Box updateBox=Box.createVerticalBox();

        JLabel labelId=new JLabel("需修改的读者编号");
//        JLabel labelReType=new JLabel("选择读者类型");
        JLabel labelName=new JLabel("姓名");
        JLabel labelBorNum=new JLabel("借阅次数");
//        JLabel labelIsBor=new JLabel("可预借");
        JLabel labelSex=new JLabel("性别");
        JLabel labelAge=new JLabel("年龄");
        JLabel labelIdNum=new JLabel("身份证号");
        JLabel labelPhone=new JLabel("电话");
        JLabel labelE_mail=new JLabel("电子邮箱");
        JLabel labelBirth=new JLabel("出生日期");
        JLabel labelRegisterDate=new JLabel("注册日期");
//        有待商榷
//        JLabel labelExpireDate;
        JLabel labelWorkLoc=new JLabel("工作单位");
        JLabel labelDep=new JLabel("部门");
        JLabel labelLossState=new JLabel("挂失状态");
        setLabelStyle(labelId);
        setLabelStyle(labelName);
        setLabelStyle(labelBorNum);
        setLabelStyle(labelSex);
        setLabelStyle(labelAge);
        setLabelStyle(labelIdNum);
        setLabelStyle(labelPhone);
        setLabelStyle(labelBirth);
        setLabelStyle(labelE_mail);
        setLabelStyle(labelRegisterDate);
        setLabelStyle(labelWorkLoc);
        setLabelStyle(labelDep);
        setLabelStyle(labelLossState);

        JLabel txtId=new JLabel();
        JTextField txtName=new JTextField();
        JTextField txtBorNum=new JTextField();
        Vector<String> sexVector=new Vector<>();
        sexVector.add("男");
        sexVector.add("女");
        sexVector.add("保密");
        JComboBox comSex=new JComboBox(sexVector);
        comSex.setPreferredSize(new Dimension(20,20));
        JTextField txtAge=new JTextField();
        JTextField txtIdNum=new JTextField();
        JTextField txtPhone=new JTextField();
        JTextField txtE_mail=new JTextField();
        DatePicker datePickerRegister=new DatePicker();
        DatePicker datePickerBirth=new DatePicker();
        JTextField txtWorkLoc=new JTextField();
        JTextField txtDep=new JTextField();
        Vector<String> stateVector=new Vector<>();
        stateVector.add("正常");
        stateVector.add("挂失");
        JComboBox comLossState=new JComboBox(stateVector);
        comLossState.setPreferredSize(new Dimension(15,20));
        
//        将选中的数据项加入至列表
        int row=readerInfoView.readerInfoTable.getSelectedRow();
        Vector<String> selectValue=new Vector<>();
        for(int i=0;i<readerInfoView.readerInfoTable.getColumnCount();i++) {
        	String s=(String)readerInfoView.readerInfoTable.getValueAt(row, i);
        	selectValue.add(s);
        }
        txtId.setText(selectValue.get(0));
        txtName.setText(selectValue.get(1));
        txtBorNum.setText(selectValue.get(2));
        txtAge.setText(selectValue.get(5));
        txtIdNum.setText(selectValue.get(10));
        txtPhone.setText(selectValue.get(11));
        txtE_mail.setText(selectValue.get(12));
        txtWorkLoc.setText(selectValue.get(13));
        txtDep.setText(selectValue.get(14));
        addBoxComp(updateBox,labelId,txtId);
        addBoxComp(updateBox,labelName,txtName);
        addBoxComp(updateBox,labelSex,comSex);
        addBoxComp(updateBox,labelAge,txtAge);
        addBoxComp(updateBox,labelPhone,txtPhone);
        addBoxComp(updateBox,labelIdNum,txtIdNum);
        addBoxComp(updateBox,labelBorNum,txtBorNum);
        addBoxComp(updateBox,labelE_mail,txtE_mail);
        addBoxComp(updateBox,labelBirth,datePickerBirth);
        addBoxComp(updateBox,labelRegisterDate,datePickerRegister);
        addBoxComp(updateBox,labelWorkLoc,txtWorkLoc);
        addBoxComp(updateBox,labelDep,txtDep);
        addBoxComp(updateBox,labelLossState,comLossState);
        

        JButton saveBtn=new JButton("保存");
        updateBox.add(Box.createVerticalStrut(30));
        updateBox.add(saveBtn);
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //创建一个ReaderInfo对象，将数据保存至对象中，再提交至数据库
                ReaderInfoVO tmpReader=new ReaderInfoVO();
                tmpReader.setReaderId(txtId.getText());
                tmpReader.setName(txtName.getText());
                tmpReader.setAge(txtAge.getText());
                tmpReader.setE_mail(txtE_mail.getText());
                tmpReader.setPhone(txtPhone.getText());
                tmpReader.setBorrowNum(txtBorNum.getText());
                tmpReader.setSex((String) comSex.getSelectedItem());
                tmpReader.setIdCard(txtIdNum.getText());
                tmpReader.setBirth(datePickerBirth.getText());
                tmpReader.setRegisterDate(datePickerRegister.getText());
                tmpReader.setLossState((String) comLossState.getSelectedItem());
                tmpReader.setWorkLocation(txtWorkLoc.getText());
                tmpReader.setDepartment(txtDep.getText());
                if(ReaderInfoDao.updateReaderInfo(tmpReader)){
                    JOptionPane.showMessageDialog(updateDialog,"保存成功");
                    updateOriginalData();
                }else {
                    JOptionPane.showMessageDialog(updateDialog,"保存失败");
                }

            }
        });


        updateDialog.add(updateBox);
        updateDialog.setLocation(400,100);
        updateDialog.setSize(400,500);
        updateDialog.setVisible(true);
    }

    /**
     * 统一设置label的样式
     * @param labelTmp 需要设置样式的label
     */
    public void setLabelStyle(JLabel labelTmp){
        labelTmp.setFont(new Font("Default",Font.TRUETYPE_FONT,15));
        labelTmp.setPreferredSize(new Dimension(200,50));
        //设置文本水平对齐方式
        labelTmp.setHorizontalAlignment(JLabel.CENTER);
    }

    /**
     * 重复的结构采用函数实现
     * @param parentBox--父元素
     * @param comp1 子元素1
     * @param comp2 子元素2
     */
    public void addBoxComp(Box parentBox, JLabel comp1, JComponent comp2){
        Box childBox=Box.createHorizontalBox();
        if(comp1!=null) {
            childBox.add(comp1);
        }
        childBox.add(comp2);
        //填充水平方向剩余的空间
        childBox.add(Box.createHorizontalGlue());
        parentBox.add(Box.createVerticalStrut(10));
        parentBox.add(childBox);
    }


    /**
     * 更新表格的原始数据
     */
    public void updateOriginalData(){
        List<ReaderInfoVO> list = ReaderInfoDao.queryReaderInfo();
        Vector<Vector> allItems = new Vector<>();
        for (ReaderInfoVO temp : list) {
            Vector v1 = new Vector();
            v1.add(temp.getReaderId());
            v1.add(temp.getName());
            v1.add(temp.getBorrowNum());
            v1.add(temp.getIsBorrow());
            v1.add(temp.getSex());
            v1.add(temp.getAge());
            v1.add(temp.getBirth());
            List<ReTypeInfoVO> data = ReaderTypeDao.queryReType();
            for (ReTypeInfoVO tmp : data) {
                if (temp.getReTypeId().equals(tmp.getReTypeId())) {
                    v1.add(tmp.getReTypename());
                    break;
                }
            }
            v1.add(temp.getRegisterDate());
            v1.add(temp.getExpireTime());
            v1.add(temp.getIdCard());
            v1.add(temp.getPhone());
            v1.add(temp.getE_mail());
            v1.add(temp.getWorkLocation());
            v1.add(temp.getDepartment());
            v1.add(temp.getLossState());
            v1.add(temp.getOperator());
            allItems.add(v1);
        }
        Vector titleItems=new Vector();
        for(int i=0;i<readerInfoView.readerInfoTable.getColumnCount();i++){
            titleItems.add(readerInfoView.readerInfoTable.getColumnName(i));
        }
        readerInfoView.readerInfoTbModel.setDataVector(allItems,titleItems);
        readerInfoView.readerInfoTable.setModel(readerInfoView.readerInfoTbModel);

        setTableStyle();
    }

}
