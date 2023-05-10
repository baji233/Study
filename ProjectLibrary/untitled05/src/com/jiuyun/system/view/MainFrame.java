package com.jiuyun.system.view;

import com.jiuyun.system.control.EmpInfoActionListener;
import com.jiuyun.system.model.EmpDao;
import com.jiuyun.system.vo.EmpInfo;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.List;
import java.util.Vector;


/**
 * ��Ա���
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
    //�����
    public MainFrame(){
        initialMainPanel();
        this.setSize(500,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//����Ĭ�Ϲرղ���(�ر�ʱ�˳�)
    }

    //��Ƴ�ʼ�������������
    private void initialMainPanel(){
        mainPane=new JSplitPane();//�ָ����
        mainPane.setLastDividerLocation(100);//�������һ���ָ���λ��
        initialLeftPanel();
        mainPane.setLeftComponent(leftPanel);//����������ڷָ��ߵ����
        initialRightPanel();
        mainPane.setRightComponent(rightPanel);//�Ҳ�
        //���������ӵ�������
        this.add(mainPane);
    }
    //��ʼ�����ṹ
    private void initialJTree(){
        DefaultMutableTreeNode root=new DefaultMutableTreeNode();//�����ݽṹ�е�ͨ�ýڵ�
        deptTree=new JTree(root);
        deptTree.setRowHeight(30);//���ø߶�
    }

    //��ʼ�������
    private void initialLeftPanel(){
        leftPanel=new JPanel();
        BorderLayout layout=new BorderLayout();//����һ���µı߿򲼾֣����֮��û�м�϶
        leftPanel.setLayout(layout);//Ϊ��������ñ߿�
        jLabelTip=new JLabel("���Žṹ");//������ǩ
        //���ṹ
        initialJTree();
        JScrollPane jSplitPane=new JScrollPane(deptTree);//�������(����)
        jSplitPane.setViewportView(deptTree);//�ӿ���ͼ(��֦)
        //����ǩ�͹��������ӵ������
        leftPanel.add(jLabelTip,BorderLayout.NORTH);//����.����������
        leftPanel.add(jSplitPane,BorderLayout.CENTER);
    }

    //��ʼ�������
    private void initialRightPanel(){
        this.rightPanel=new JTabbedPane();
        initialEmpInfoPanel();
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
    public JTextField txtName,txtJob;
    public JTable empTab;
    //�����
    JPanel empSouthPanel;
    JButton btnQuery,btnAdd,btnDelete,btnUpdate;
    //��ʼ����Ա��Ϣ���
    private void initialEmpInfoPanel(){
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
        jrbByName.setActionCommand("name");
        this.jrbByJob=new JRadioButton("������");
        jrbByJob.setActionCommand("job");
        this.buttonGroup=new ButtonGroup();//ButtonGroup���󴴽�һ�鰴ť��ζ�š��򿪡�����һ����ť��ر����е�����������ť
        buttonGroup.add(jrbByName);
        buttonGroup.add(jrbByJob);
        this.txtName=new JTextField(15);
        this.txtJob=new JTextField(15);
        this.btnQuery=new JButton("��ѯ");
        btnQuery.setActionCommand("query");

        //��Լ�����С���
        addByConstraints(gbc,0,0,5,1,lblQueryTitle);
        addByConstraints(gbc,1,0,1,1,jrbByName);
        addByConstraints(gbc,1,1,3,1,txtName);
        addByConstraints(gbc,2,0,1,1,jrbByJob);
        addByConstraints(gbc,2,1,3,1,txtJob);
        addByConstraints(gbc,2,4,1,1,btnQuery);
        //չʾ���
        this.empDisplayPanel=new JPanel();
        empDisplayPanel.setLayout(new BorderLayout());
        //������Ա��Ϣ��
        initialEmpTbl();
        JScrollPane jScrollPane=new JScrollPane(empTab);//��ʾJTable�����ӿ���ͼ
        jScrollPane.setViewportView(empTab);//ָ�����ڹ�����������ʾ�Ŀɹ�������empTbl
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
        this.btnUpdate=new JButton("�޸�");
        btnAdd.setActionCommand("update");
        this.empSouthPanel.add(btnAdd);
        this.empSouthPanel.add(btnDelete);
        this.empSouthPanel.add(btnUpdate);
        //ע�ᶯ��������
        EmpInfoActionListener empInfoActionListener=new EmpInfoActionListener(this);
        this.btnQuery.addActionListener(empInfoActionListener);
        this.btnAdd.addActionListener(empInfoActionListener);
        this.btnDelete.addActionListener(empInfoActionListener);
        this.btnUpdate.addActionListener(empInfoActionListener);
        empJPanel.add(empSouthPanel,BorderLayout.SOUTH);
    }
    public DefaultTableModel dtm=null;//��ģ��
//JTable��ʾ��(���ַ���)
    private void initialEmpTbl(){
        //��������
        Vector<String> titles=new Vector<>();//ѡ����Vector��װ��������Ϊ:DefaultTableModel�Ĺ��췽���Ĳ�������
        titles.add("��Ա���");
        titles.add("����");
        titles.add("����");
        titles.add("����");
        titles.add("����");
        titles.add("����");

        //��������
        List<EmpInfo> lstEmp=EmpDao.queryAllEmp();//���װ�в�ѯ����Ķ���
        Vector<Vector> allData=new Vector<>();//���������������
        for(EmpInfo empInfo :lstEmp){
            Vector<String>vector=new Vector<>();//���empinfo���в�ѯ������
            vector.add(empInfo.getEmpId());
            vector.add(empInfo.getEmpName());
            vector.add(empInfo.getPay());
            vector.add(empInfo.getJob());
            vector.add(empInfo.getBirthday());
            vector.add(empInfo.getDeptId());
            allData.add(vector);
        }

        dtm=new DefaultTableModel(allData,titles);//������Vector������Ϊ��������Ĭ�ϱ�ģ��
        empTab=new JTable(dtm);
        /**
         * ��JTable����ʾMySQL��
         */

        /**
         * ���췽��JTable(Object[][] rowData, Object[] columnNames)ֵ,����
         *         String[] columnNames={"��Ա���","����","����","����","����","����"};
         *         String[][] rowData= {{"1","С��","3000.5","����Ա","2001-8-8","101"},{"2","С��","3500.9","���","2003-2-23","203"}};
         *         empTab=new JTable(rowData,columnNames);
         */

        /**
         * ���췽��JTable(TableModel dm)����ģ��,��ʹ��Vector<>��������ģ��

        Vector<String> columnNames=new Vector<>();
        columnNames.add("��Ա���");
        columnNames.add("����");
        columnNames.add("����");
        columnNames.add("����");
        columnNames.add("����");
        columnNames.add("����");

        Vector<Vector> rowData=new Vector<>();
        Vector<String> emp01=new Vector<>();
        emp01.add("1");
        emp01.add("С��");
        emp01.add("3000.5");
        emp01.add("����Ա");
        emp01.add("2001-8-8");
        emp01.add("101");
        Vector<String> emp02=new Vector<>();
        emp02.add("2");
        emp02.add("С��");
        emp02.add("3500.9");
        emp02.add("���");
        emp02.add("2003-2-23");
        emp02.add("203");
        rowData.add(emp01);
        rowData.add(emp02);
        dtm=new DefaultTableModel(rowData,columnNames);
        empTab=new JTable(dtm);
         */

    }
    //���Լ���ķ���
    private void addByConstraints(GridBagConstraints gbc,int row,int col,int width,int height,Component component){
        gbc.gridx=col;
        gbc.gridy=row;
        gbc.gridwidth=width;
        gbc.gridheight=height;
        empQueryPanel.add(component,gbc);
    }

    public static void main(String[] args){
        new MainFrame().setVisible(true);//ʹWindow�ɼ�
    }
}















