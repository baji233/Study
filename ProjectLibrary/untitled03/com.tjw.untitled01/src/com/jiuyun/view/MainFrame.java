package com.jiuyun.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ��Ա��Ϣ������
 */
public class MainFrame extends JFrame {
    //����ṹ
    JSplitPane mainPane;
    JPanel leftPanel;
    JTabbedPane rightPanel;
    //����������
    JLabel jLabelTip;
    JTree deptTree;
    //�ұ��������
    JPanel empJPanel,deptJPanel;
    //�¼���������
    ButtonLister buttonLister;
    //�����
    public MainFrame(){
        initialMainPanl();
        this.setSize(500,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����Ĭ�Ϲرղ���(�ر�ʱ�˳�)
    }

    //��Ƴ�ʼ�������������
    private void initialMainPanl(){
        mainPane=new JSplitPane();//�ָ����
        mainPane.setLastDividerLocation(100);//�������һ���ָ���λ��
        initialLeftPanl();
        mainPane.setLeftComponent(leftPanel);//����������ڷָ��ߵ����
        initialRightPanl();
        mainPane.setRightComponent(rightPanel);//�Ҳ�
        //���������ӵ�������
        this.add(mainPane);
    }

    //��ʼ�������
    private void initialLeftPanl(){
        leftPanel=new JPanel();
        BorderLayout layout=new BorderLayout();//����һ���µı߿򲼾֣����֮��û�м�϶
        leftPanel.setLayout(layout);//Ϊ��������ñ߿�
        jLabelTip=new JLabel("���Žṹ");//������ǩ
        //���ṹ
        deptTree=new JTree();
        JScrollPane jSplitPane=new JScrollPane(deptTree);//�������(����)
        jSplitPane.setViewportView(deptTree);//�ӿ���ͼ(��֦)
        //����ǩ�͹��������ӵ������
        leftPanel.add(jLabelTip,BorderLayout.NORTH);//����.����������
        leftPanel.add(jSplitPane,BorderLayout.SOUTH);
    }

    //��ʼ�������
    private void initialRightPanl(){
        this.rightPanel=new JTabbedPane();
        initialEmpinfoPanl();
        empJPanel.setForeground(Color.YELLOW);//����ǰ��
        this.deptJPanel=new JPanel();
        deptJPanel.setForeground(Color.RED);
        //��Ա����Ϣ�Ͳ�����Ϣ��ӵ������
        rightPanel.add("Ա����Ϣ",empJPanel);
        rightPanel.add("������Ϣ",deptJPanel);
    }
    //�����
    JSplitPane empCenterPane;
    JPanel empQueryPanel,empDisplayPanel;
    //��ѯ������Ҫ�����
    JLabel lblQueryTitle;
    JRadioButton jrbByName,jrbByJob;
    ButtonGroup buttonGroup;
    JTextField txtName,txtJob;
    JButton jbtQuery;
    //��ʾ��Ա��Ϣ��Ҫ�����
    JTable empTbl;
    //�����
    JPanel empSouthPanel;
    JButton btnAdd,btnDelete,btnUpdata;
    //��ʼ����Ա��Ϣ���
    private void initialEmpinfoPanl(){
        this.empJPanel=new JPanel();
        empJPanel.setLayout(new BorderLayout());
        this.empCenterPane=new JSplitPane(JSplitPane.VERTICAL_SPLIT);//��y�ᴹֱ���
        empCenterPane.setDividerLocation(130);//�ָ��ߵ�λ��
        //������ѯ���
        this.empQueryPanel=new JPanel();
        GridBagLayout gbl=new GridBagLayout();//����һ����������ֹ�����
        GridBagConstraints gbc=new GridBagConstraints();//Ϊʹ��GridBagLayout�಼�ֵ����ָ��Լ��
        gbc.insets=new Insets(10,5,10,5);//ʹ��ָ���Ķ�������ࡢ�ײ����Ҳ���봴������ʼ��һ���µĲ�ͼ����
        empQueryPanel.setLayout(gbl);
        //С���
        this.lblQueryTitle=new JLabel("������ѯ");
        Font f=new Font("����",Font.BOLD,15);
        lblQueryTitle.setFont(f);
        this.jrbByName=new JRadioButton("������",true);//true:���ѡ��ť
        this.jrbByJob=new JRadioButton("������");
        this.buttonGroup=new ButtonGroup();//ButtonGroup���󴴽�һ�鰴ť��ζ�š��򿪡�����һ����ť��ر����е�����������ť
        buttonGroup.add(jrbByName);
        buttonGroup.add(jrbByJob);
        txtName=new JTextField(15);
        txtJob=new JTextField(15);
        this.jbtQuery=new JButton("��ѯ");
        jbtQuery.setActionCommand("query");
        this.buttonLister=new ButtonLister();//����������
        jbtQuery.addActionListener(buttonLister);


        //��Լ�����С���
        addByConstraints(gbc,0,0,5,1,lblQueryTitle);
        addByConstraints(gbc,1,0,0,1,jrbByName);
        addByConstraints(gbc,1,1,3,1,txtName);
        addByConstraints(gbc,2,0,1,1,jrbByJob);
        addByConstraints(gbc,2,1,3,1,txtJob);
        addByConstraints(gbc,2,4,1,1,jbtQuery);
        //չʾ���
        this.empDisplayPanel=new JPanel();
        empDisplayPanel.setLayout(new BorderLayout());
        this.empTbl=new JTable();
        JScrollPane jScrollPane=new JScrollPane(empTbl);//��ʾJTable�����ӿ���ͼ
        jScrollPane.setViewportView(empTbl);//ָ�����ڹ�����������ʾ�Ŀɹ�������empTbl
        empDisplayPanel.add(jScrollPane);
        empCenterPane.setTopComponent(empQueryPanel);//���ö������
        empCenterPane.setBottomComponent(empDisplayPanel);//���õײ����
        empJPanel.add(empCenterPane);

        //�ϲ�������ť���
        this.empSouthPanel=new JPanel();
        this.btnAdd=new JButton("���");
        btnAdd.setActionCommand("add");
        this.btnDelete=new JButton("ɾ��");
        btnAdd.setActionCommand("delete");
        this.btnUpdata=new JButton("�޸�");
        btnAdd.setActionCommand("updata");
        btnAdd.addActionListener(buttonLister);//ע��
        btnDelete.addActionListener(buttonLister);
        btnUpdata.addActionListener(buttonLister);
        this.empSouthPanel.add(btnAdd);
        this.empSouthPanel.add(btnDelete);
        this.empSouthPanel.add(btnUpdata);
        empJPanel.add(empSouthPanel,BorderLayout.SOUTH);
    }
    //���Լ���ķ���
    private void addByConstraints(GridBagConstraints gbc,int row,int col,int width,int height,Component component){
        gbc.gridx=col;
        gbc.gridy=row;
        gbc.gridwidth=width;
        gbc.gridheight=height;
    }

    public static void main(String[] args){
        new MainFrame().setVisible(true);//ʹWindow�ɼ�
    }
}


//��ť�¼�����ʵ����
class ButtonLister implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        String str=e.getActionCommand();
        if("query".equals(str)){

        }else if("add".equals(str)){

        }else if("delete".equals(str)){

        }else if("updata".equals(str)){

        }
    }
}





















