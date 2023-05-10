package com.jiuyun.system.view;


import com.eltima.components.ui.DatePicker;
import com.jiuyun.system.control.AddReaderAction;
import com.jiuyun.system.model.ReaderTypeDao;
import com.jiuyun.system.vo.ReTypeInfoVO;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class AddReaderView extends JDialog {
    public JTextField[] arrayField=null;

    JSplitPane mainPanel;
    JTabbedPane jTabbedPane;
    JPanel catePanel;
    public JComboBox cateCom;
    JButton addReTypeBtn;
    //基本信息面板组件
    public JComboBox stateLossCBox;
    public JButton saveBtn;
    public JButton exitBtn;
    public JRadioButton isBorrowBtn;
    public DatePicker registerDate;
    public DatePicker birthDatePicker;
    public JPanel basicMain;
    JPanel basicPanel;
    JPanel imagePanel;
    JLabel reTypeNameLabel;
    JLabel borrowQuanLabel;
    public JLabel boQuanContent;
    JLabel borrowTimeLabel;
    public JLabel boTimeContent;
    JLabel validTimeLabel;
    public JLabel validTimeContent;
    public AddReaderView(JFrame frame,String title,boolean modal){
        super(frame,title,modal);
        initialStyle();
        mainPanel=new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        initialCatePanel();
        initialTablePane();
        mainPanel.setTopComponent(catePanel);
        mainPanel.setBottomComponent(jTabbedPane);
        mainPanel.setDividerLocation(100);
        this.add(mainPanel);
        mainPanel.setBackground(Color.CYAN);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    }

    public void initialStyle(){
        this.setBounds(300,100,700,450);
        //设置不可最大化
//        this.setResizable(false);
    }


    public void initialCatePanel() {
        //设置catePanel的布局，边框等
        GridBagConstraints gbc;
        gbc=new GridBagConstraints();
        GridBagLayout gbl = new GridBagLayout();

        catePanel=new JPanel();
        catePanel.setBorder(new LineBorder(Color.red,2));
        JPanel catePanelChild;
        catePanelChild=new JPanel(gbl);
        catePanelChild.setLayout(gbl);
        catePanel.add(catePanelChild,BorderLayout.CENTER);

        catePanelChild.setBorder(new LineBorder(Color.gray,2));


        //初始化基本组件
        reTypeNameLabel=new JLabel("读者类型：");
        reTypeNameLabel.setSize(10,10);
        reTypeNameLabel.setHorizontalAlignment(JLabel.CENTER);
        reTypeNameLabel.setBorder(new LineBorder(Color.darkGray,2));
        addReTypeBtn=new JButton("+");
        addReTypeBtn.setSize(5,5);
        //通过增加监听器来生成一个添加读者类型的窗口
        addReTypeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //由于当前处在监听器对象内,所以指向父窗口需要使用下列形式
                new AddReTypeView(AddReaderView.this,"添加等级",true);
            }
        });
        /*cateLabel[1]=new JLabel("收费标准：");
        cateLabel[2]=new JLabel("押金金额");
        cateLabel[3]=new JLabel("超过收费标准");*/
        borrowQuanLabel=new JLabel("可借数量：");
        borrowQuanLabel.setHorizontalAlignment(JLabel.RIGHT);
        borrowTimeLabel=new JLabel("持书时间：");
        validTimeLabel=new JLabel("证件有效时间：");

        //数据库拿数据
        setCateCom();
        JSplitPane addCateCom;
        addCateCom=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        addCateCom.setLeftComponent(cateCom);
        addCateCom.setRightComponent(addReTypeBtn);
        //设置网格布局
        setConstrains(gbc,0,0,1,1);
//        gbc.fill=GridBagConstraints.BOTH;
        catePanelChild.add(reTypeNameLabel,gbc);
        setConstrains(gbc,0,1,1,1);
//        cateCom.setBorder(new LineBorder(Color.red,2));
        catePanelChild.add(addCateCom,gbc);

        setConstrains(gbc,1,0,1,1);
        catePanelChild.add(borrowQuanLabel,gbc);
        setConstrains(gbc,1,1,1,1);
        catePanelChild.add(boQuanContent,gbc);
        setConstrains(gbc,1,2,1,1);
        catePanelChild.add(borrowTimeLabel,gbc);
        setConstrains(gbc,1,3,1,1);
        catePanelChild.add(boTimeContent,gbc);
        setConstrains(gbc,1,4,1,1);
        catePanelChild.add(validTimeLabel,gbc);
        setConstrains(gbc,1,5,1,1);
        catePanelChild.add(validTimeContent,gbc);

    }

    public void setConstrains(GridBagConstraints gbc,int row,int col,int width,int height)
    {
        gbc.gridy=row;
        gbc.gridx=col;
        gbc.gridheight=height;
        gbc.gridwidth=width;
//        gbc.anchor=GridBagConstraints.EAST;
        //weightx值表示当父组件大小变化时，组件的变化，默认为0表示大小不变
        gbc.weightx=1;
        gbc.weighty=1;
//        gbc.fill=GridBagConstraints.BOTH;
    }

    /**
     * 查询所有的读者类型名称，初始化读者类型名称下拉框
     */
    public  void setCateCom(){
        Vector<String> cateVector=new Vector<>();
        List<ReTypeInfoVO> data = ReaderTypeDao.queryReType();
        for(ReTypeInfoVO tmp:data){
            cateVector.add(tmp.getReTypename());
        }
        cateCom=new JComboBox(cateVector);
        //默认选中第一个，取第一个读者类型的相关数据并生成Label
        ReTypeInfoVO reTypeFirstInfo = data.get(0);
        boQuanContent=new JLabel(reTypeFirstInfo.getMaxBook()+"本");
        //设置前景
        boQuanContent.setForeground(Color.blue);
        boTimeContent=new JLabel(reTypeFirstInfo.getBorrowTime());
        boTimeContent.setForeground(Color.blue);
        validTimeContent=new JLabel(reTypeFirstInfo.getValidTime());
        validTimeContent.setForeground(Color.blue);
        cateCom.addItemListener(new AddReaderAction(this));
    }


    public void initialTablePane(){
        jTabbedPane=new JTabbedPane();
        initialBasicPanel();
        imagePanel=new JPanel();
        jTabbedPane.addTab("基本信息",basicPanel);
        jTabbedPane.addTab("图片信息",imagePanel);
    }

    public void initialBasicPanel(){
        basicPanel=new JPanel();
        basicMain=new JPanel(new GridBagLayout());
        basicPanel.add(basicMain);
        basicMain.setBorder(new LineBorder(Color.LIGHT_GRAY,2));
        arrayField=new JTextField[9];

        arrayField[0]=new JTextField(15);
        arrayField[1]=new JTextField(15);
        arrayField[2]=new JTextField(15);
        arrayField[3]=new JTextField(15);
        arrayField[4]=new JTextField(15);
        arrayField[5]=new JTextField(15);
        arrayField[6]=new JTextField(15);
        arrayField[7]=new JTextField(15);
        arrayField[8]=new JTextField(15);

        Vector<String> stateLossVector=new Vector<>();
        stateLossVector.add("正常");
        stateLossVector.add("挂失");
        stateLossCBox=new JComboBox(stateLossVector);
        stateLossCBox.setSelectedIndex(0);
        isBorrowBtn=new JRadioButton("可 预 借");
//        isBorrowBtn.setHorizontalTextPosition(JRadioButton.TRAILING);
        isBorrowBtn.setSelected(false);
        saveBtn=new JButton("保存");
        saveBtn.setActionCommand("saveReader");
        exitBtn=new JButton("退出");
        exitBtn.setActionCommand("exit");
        AddReaderAction addReaderAction = new AddReaderAction(this);
        saveBtn.addActionListener(addReaderAction);
        exitBtn.addActionListener(addReaderAction);

        GridBagConstraints gbcBasic=new GridBagConstraints();
        gbcBasic.insets=new Insets(5,3,5,3);
        //网袋布局
        //日期零件
        setBasicConstrains(gbcBasic,0,0,1,1,new JLabel("编号"));
        setBasicConstrains(gbcBasic,0,1,1,1,arrayField[0]);
        setBasicConstrains(gbcBasic,0,2,1,1,new JLabel("姓名"));
        setBasicConstrains(gbcBasic,0,3,1,1,arrayField[1]);
        setBasicConstrains(gbcBasic,0,4,1,1,new JLabel("年龄"));
        setBasicConstrains(gbcBasic,0,5,1,1,arrayField[2]);

        setBasicConstrains(gbcBasic,1,0,1,1,new JLabel("出生日期"));
        birthDatePicker =new DatePicker();
        birthDatePicker.setSize(10,20);
        birthDatePicker.setFont(new Font("宋体",Font.BOLD,14));
        setBasicConstrains(gbcBasic,1,1,1,1, birthDatePicker);
        setBasicConstrains(gbcBasic,1,2,1,1,new JLabel("性别"));
        setBasicConstrains(gbcBasic,1,3,1,1,arrayField[3]);
        setBasicConstrains(gbcBasic,1,4,1,1,new JLabel("身份证"));
        setBasicConstrains(gbcBasic,1,5,1,1,arrayField[4]);

        setBasicConstrains(gbcBasic,2,0,1,1,new JLabel("工作单位"));
        setBasicConstrains(gbcBasic,2,1,1,1,arrayField[5]);
        setBasicConstrains(gbcBasic,2,2,1,1,new JLabel("电话"));
        setBasicConstrains(gbcBasic,2,3,1,1,arrayField[6]);

        setBasicConstrains(gbcBasic,3,0,1,1,new JLabel("挂失状态"));
        setBasicConstrains(gbcBasic,3,1,1,1,stateLossCBox);
        setBasicConstrains(gbcBasic,3,2,1,1,new JLabel("电子邮件"));
        setBasicConstrains(gbcBasic,3,3,1,1,arrayField[7]);

        setBasicConstrains(gbcBasic,4,0,1,1,new JLabel("工作部门"));
        setBasicConstrains(gbcBasic,4,1,1,1,arrayField[8]);
        setBasicConstrains(gbcBasic,4,2,1,1,new JLabel("注册日期"));
        registerDate=new DatePicker();
        setBasicConstrains(gbcBasic,4,3,1,1,registerDate);
        setBasicConstrains(gbcBasic,5,0,1,1,isBorrowBtn);
        setBasicConstrains(gbcBasic,6,0,1,1,exitBtn);
        setBasicConstrains(gbcBasic,6,1,1,1,saveBtn);
    }
    public void setBasicConstrains(GridBagConstraints gbc, int row, int col, int width, int height, Component cmp)
    {
        gbc.gridy=row;
        gbc.gridx=col;
        gbc.gridheight=height;
        gbc.gridwidth=width;
        gbc.weightx=1;
        gbc.weighty=1;
        basicMain.add(cmp,gbc);
    }

    public static void main(String[] args) {
        AddReaderView frame=new AddReaderView(null,"读者信息维护",false);
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
