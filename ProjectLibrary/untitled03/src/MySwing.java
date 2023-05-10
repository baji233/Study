import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class MySwing extends JFrame {
    JButton jButton;//��ť
    JRadioButton jrbMan,jrbWoman;//��ѡ��ť
    ButtonGroup buttonGroup=new ButtonGroup();//��ť��
    JLabel lblUid,lblPwd,lblSex,lblLike,lblCity;//��ǩ
    JTextField jTextField;//�ı���
    JPasswordField jPasswordField;//�����
    JCheckBox jCheckBox01,jCheckBox02,jCheckBox03;//��ѡ��
    JComboBox jComboBox;//������
    JTextArea jTextArea;//�ı���

    //�޲ι��췽��������ͨ����
    public MySwing(){
        test01();
        test02();
    }
    //���������������ӵ�������
    private void test02(){
        FlowLayout flowLayout=new FlowLayout();//��ʽ����
        this.setLayout(flowLayout);
        //��ͼƬ�İ�ť
        jButton=new JButton(new ImageIcon("ͼƬ\\1(2)"));
        //���ð�ť�ı߿�
        jButton.setBorder(BorderFactory.createLineBorder(Color.YELLOW,2));

        lblUid=new JLabel("�û���: ");
        //����������ɫ
        lblUid.setForeground(Color.BLUE);
        //�������� �������������������С
        Font font=new Font("����",Font.ITALIC,20);
        lblUid.setFont(font);
        //�����ı����ݵĶ��뷽ʽ
        lblUid.setHorizontalTextPosition(SwingConstants.LEFT);

        //�����ı���
        jTextField=new JTextField(15);
        jTextField.setBorder(BorderFactory.createLineBorder(Color.RED,3));
        jTextField.setText("HolleWorld~");
        //�ı��򲻿���
        jTextField.setEnabled(false);
        lblPwd=new JLabel("����");
        jPasswordField=new JPasswordField(10);

        //��ѡ��ť--ֵ,�Ƿ�ѡ��
        lblSex=new JLabel("�Ա�");
        jrbMan=new JRadioButton("��");
        jrbWoman=new JRadioButton("Ů");
        //��õ�ѡ��ť�Ƿ�ѡ��
        boolean b1=jrbMan.isSelected();
        String str1=jrbMan.getText();
        //��������ѡ��ť���뵽��
        buttonGroup.add(jrbMan);
        buttonGroup.add(jrbWoman);

        //���ø�ѡ��ť
        lblLike=new JLabel("����");
        jCheckBox01=new JCheckBox("����");
        jCheckBox02=new JCheckBox("RAP");
        jCheckBox03=new JCheckBox("����");

        //������
        lblCity=new JLabel("����");
        Vector<String> vector=new Vector<String>();//��������
        vector.add("��ɳ");
        vector.add("��̶");
        vector.add("����");
        jComboBox=new JComboBox(vector);
        jComboBox.addItem("����");//����Ŀ��ӵ���Ŀ�б�
        //����Ĭ�ϱ�ѡ�е���Ŀ
        jComboBox.setSelectedIndex(2);
        //��ñ�ѡ�е���Ŀ��Ӧ������
        String str3=(String)jComboBox.getSelectedItem();//Objectǿ��ת��ΪString

        //�ı���(ָ������)
        jTextArea=new JTextArea(4,15);
        //������������ʱ���Զ�����
        jTextArea.setLineWrap(true);
        //���ù�����
        JScrollPane jScrollPane=new JScrollPane(jTextArea);
        jScrollPane.setViewportView(jTextArea);

        //��ӵ�����
        this.add(jButton);
        this.add(jrbMan);
        this.add(jrbWoman);
        this.add(lblUid);
        this.add(lblPwd);
        this.add(lblSex);
        this.add(lblLike);
        this.add(lblCity);
        this.add(jTextField);
        this.add(jPasswordField);
        this.add(jCheckBox01);
        this.add(jCheckBox02);
        this.add(jCheckBox03);
        this.add(jComboBox);
        this.add(jTextArea);
    }

        //��ʼ���������������
    private void test01(){
        Toolkit toolkit=Toolkit.getDefaultToolkit();//��ȡĬ�Ϲ��߰�
        Dimension dimension=toolkit.getScreenSize();//��ȡ��Ļ�Ĵ�С
        double height=dimension.getHeight();
        double width=dimension.getWidth();
        //���ô���λ��,��С,����,������С,������ɫ
        this.setLocation(150,120);
        this.setSize(500,400);
        this.setTitle("�û�ע��");
        this.setResizable(true);
        this.getContentPane().setBackground(Color.pink);//���ô���ı�����ɫ
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô��ڹرյ�ͬʱϵͳ�Զ��˳�
        this.setVisible(true);//��ʾJFrame����
    }

    public static void main(String[] args){
        MySwing mySwing=new MySwing();
        mySwing.test01();
    }
}




































