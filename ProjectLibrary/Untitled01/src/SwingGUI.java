import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * ��������ڸ��˲���
 */
public class SwingGUI {

    public static void test01() {
        /**
         * JFrame��������
         */
        JFrame jFrame = new JFrame("JFrameTest");
        //���ùرմ���ʱ��Ĭ�ϲ���:�ر�ʱ�˳�
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //���ô��ڳߴ�
        jFrame.setSize(300, 250);
        //���ڿɼ�
        jFrame.setVisible(true);

        /**
         * JDialog�Ի��򴰿�
         */
        JDialog jDialog = new JDialog(jFrame, "ģ̬�Ի���", true);//���ö�������,����,�Ƿ���ģ̬�Ի���
        //���ùرմ���ʱ��Ĭ�ϲ���:�ر�ʱ����
        jDialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        jDialog.setSize(250, 150);
        jDialog.setVisible(true);
    }

    public static void test02(){
        /**
         * BorderLayout�߽粼�ֹ�����
         */
        JFrame jFrame1=new JFrame("BorderLayout");
        //���ô��岼��
        jFrame1.setLayout(new BorderLayout());
        jFrame1.setSize(500,500);
        //���ô���λ��
        jFrame1.setLocation(300,200);
        //����5����ť�������ڲ�ͬ����
        jFrame1.add(new JButton("ҳͷ"),BorderLayout.NORTH);
        jFrame1.add(new JButton("����"),BorderLayout.EAST);
        jFrame1.add(new JButton("����"),BorderLayout.CENTER);
        jFrame1.add(new JButton("��β"),BorderLayout.WEST);
        jFrame1.add(new JButton("ҳβ"),BorderLayout.SOUTH);
        jFrame1.setVisible(true);
        jFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void test03(){
        /**
         * FlowLayout��ʽ���ֹ�����
         */
        JFrame jFrame2=new JFrame("FlowLayout");
        //���ö��뷽ʽ,ˮƽ���,��ֱ���
        jFrame2.setLayout(new FlowLayout(FlowLayout.RIGHT,20,30));
        jFrame2.setSize(250,200);
        jFrame2.setLocation(300,200);
        jFrame2.add(new JButton("1"));
        jFrame2.add(new JButton("2"));
        jFrame2.add(new JButton("3"));
        jFrame2.add(new JButton("4"));
        jFrame2.add(new JButton("5"));
        jFrame2.setVisible(true);
        jFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void test04(){
        /**
         * GridLayout���񲼾ֹ�����
         */
        JFrame jFrame3=new JFrame("GridLayout");
        //��������,����,ˮƽ���,��ֱ���
        jFrame3.setLayout(new GridLayout(3,4,20,30));
        jFrame3.setSize(400,300);
        jFrame3.setLocation(350,350);
        //ѭ����Ӱ˸���ť��jFrame3��
        for(int i=1;i<13;i++){
            JButton jButton=new JButton("JButton"+i);
            jFrame3.add(jButton);
        }
        jFrame3.setVisible(true);
        jFrame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void test05(){
        /**
         * GridBagLayout��������ֹ�����
         */

    }

    public static void test06(){
        /**
         * KeyListener���̼�����
         */
        JFrame jFrame5=new JFrame("KeyEvent");
        jFrame5.setLayout(new FlowLayout());
        jFrame5.setSize(400,300);
        jFrame5.setVisible(true);
        jFrame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField jTextField=new JTextField(30);
        jFrame5.add(jTextField);
        //Ϊ�ı�����Ӽ����¼�������
        jTextField.addKeyListener(new KeyListener() { //�̳�KeyListener��,Ҫʵ��������������
            @Override
            public void keyTyped(KeyEvent e) {
                //����ļ�
            }
            @Override
            public void keyPressed(KeyEvent e) { //������
                char c=e.getKeyChar();
                System.out.println(c);
            }
            @Override
            public void keyReleased(KeyEvent e) {
                //Կ���ͷ�
            }
        });
    }

    public static void test07(){
        /**
         * JScrollPane���������
         */
        //����JFrame����
        JFrame jFrame6=new JFrame("JScrollPane");
        jFrame6.setSize(400,300);
        jFrame6.setVisible(true);
        jFrame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //����JPanel���
        JPanel jPanel=new JPanel();
        for(int i=1;i<=100;i++){
            jPanel.add(new JButton("��ť"+i));
        }
        //����JScrollPane���
        JScrollPane jScrollPane=new JScrollPane();
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);//ˮƽ�������Զ���ʾ
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//��ֱ������ʼ����ʾ
        //���������
        jScrollPane.setViewportView(jPanel);
        jFrame6.add(jScrollPane);
    }

    public static void test08(){
        /**
         * JTextField�ı���/JTextArea�ı���
         */
        JFrame jFrame7=new JFrame("���촰��");
        jFrame7.setLayout(new BorderLayout());
        jFrame7.setSize(600,500);
        jFrame7.setLocation(300,250);
        jFrame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame7.setVisible(true);
        //����һ���ı���������ʾ����������Ϣ
        JTextArea jTextArea=new JTextArea(15,30);
        jTextArea.setEditable(false);//�����ı��򲻿ɱ༭
        //���ı���װ����������
        JScrollPane jScrollPane=new JScrollPane(jTextArea);
        //����һ���ı����������뵥��������Ϣ
        JTextField jTextField=new JTextField(30);
        JButton jButton=new JButton("����");
        //����һ��JPanel���...
        JPanel jPanel=new JPanel();
        JLabel jLabel=new JLabel("������Ϣ");
        //��JPanel��˳�����jLabel,jTextField,jButton
        jPanel.add(jLabel);
        jPanel.add(jTextField);
        jPanel.add(jButton);
        //��jFrame7�Ķ����͵ײ���Ӻ�jPanel
        jFrame7.add(jScrollPane,BorderLayout.NORTH);
        jFrame7.add(jPanel,BorderLayout.SOUTH);
        //Ϊ��ť��Ӷ���������(��ֻ��һ����ť��Ҫ������ʱ,����ʹ��Lambda���ʽ��ʵ�ֳ��󷽷�)
        jButton.addActionListener(e->{
            String text=jTextField.getText();
            if(text!=null && !text.trim().equals("")){ //�ո��δ����
                //���������Ϣ��Ϊ��,�ͽ������ı�׷�ӵ��ı�����ʾ
                jTextArea.append("�ҵ���Ϣ: "+text+"\n");
            }else{
                //���Ϊ��...
                jTextArea.append("������Ϣ����Ϊ��!\n");
            }
            //Ȼ���ı�������Ϊ��
            jTextField.setText("");
        });
    }

    public static void test09(){
        /**
         * JCheckBox��ѡ��ť/JRadioButton��ѡ��ť
         */
        JFrame jFrame7=new JFrame("��������01");
        jFrame7.setLayout(new BorderLayout());
        jFrame7.setSize(600,500);
        jFrame7.setLocation(300,250);
        jFrame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame7.setVisible(true);
        //��ǩ�ı�������ʾ
        JLabel jLabel=new JLabel("Hello World!",JLabel.CENTER);
        jLabel.setFont(new Font("����",Font.PLAIN,25));//Font.PLAIN:���صķ�񲻱�
        //����������ѡ��ť
        JCheckBox jCheckBox01=new JCheckBox("б��");
        JCheckBox jCheckBox02=new JCheckBox("�Ӵ�");
        //����������ѡ��ť
        JRadioButton jRadioButton01=new JRadioButton("����");
        JRadioButton jRadioButton02=new JRadioButton("30");
        //��������ѡ��ť����ͬһ����ť��
        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(jRadioButton01);
        buttonGroup.add(jRadioButton02);
        //���������
        JPanel jPanel=new JPanel();
        jPanel.add(jCheckBox01);
        jPanel.add(jCheckBox02);
        jPanel.add(jRadioButton01);
        jPanel.add(jRadioButton02);
        jFrame7.add(jLabel,BorderLayout.CENTER);
        jFrame7.add(jPanel,BorderLayout.SOUTH);
        //Ϊ��ѡ��ť��Ӷ���������(���ж����ť��Ҫ������ʱ,���������ڲ����)
        ActionListener actionListener01=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int mode=0;//������
                if(jCheckBox01.isSelected()){ //���ѡ�����л���ť����Ϊtrue
                    mode+=Font.ITALIC;//б����ʽ����
                }
                if(jCheckBox02.isSelected()){
                    mode+=Font.BOLD;//������ʽ����
                }
                //��������������
                jLabel.setFont(new Font("����",mode,25));
            }
        };
        //Ϊ��ѡ��ť��Ӷ���������
        ActionListener actionListener02=new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String s="����";
                int i=30;
                if(jRadioButton01.isSelected()){
                    jLabel.setFont(new Font("����",Font.PLAIN,25));//������
                }
                if(jRadioButton02.isSelected()){
                    jLabel.setFont(new Font("����",Font.PLAIN,i));//�Ĵ�С
                }
            }
        };
        jCheckBox01.addActionListener(actionListener01);
        jCheckBox02.addActionListener(actionListener01);
        jRadioButton01.addActionListener(actionListener02);
        jRadioButton02.addActionListener(actionListener02);
    }

    public static void test10(){
        /**
         * JComboBox������
         */
        JFrame jFrame7=new JFrame("JComboBox");
        jFrame7.setLayout(new BorderLayout());
        jFrame7.setSize(600,500);
        jFrame7.setLocation(300,250);
        jFrame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame7.setVisible(true);
        JPanel jPanel=new JPanel();
        //������������������ѡ��
        JComboBox<String> jComboBox=new JComboBox<>();
        jComboBox.addItem("��ѡ�����Ӣ��");
        jComboBox.addItem("³���ߺ�");
        jComboBox.addItem("������Լ");
        jComboBox.addItem("������");
        jComboBox.addItem("�����");
        jComboBox.addItem("��ҧ��");
        //�����ı�������չʾ�û�ѡ��
        JTextField jTextField=new JTextField(20);
        //Ϊ��������Ӷ���������
        ActionListener actionListener= e -> {
            //��ȡѡ��ѡ����ַ���
            String item=(String)jComboBox.getSelectedItem();
            if("��ѡ�����Ӣ��".equals(item)){
                jTextField.setText("");
            }else{
                jTextField.setText("��ѡ���Ӣ����:"+item);
            }
        };
        //���������
        jComboBox.addActionListener(actionListener);
        jPanel.add(jComboBox);
        jPanel.add(jTextField);
        jFrame7.add(jPanel,BorderLayout.CENTER);
    }

    public static void test11() {
        /**
         * JMenuBar����ʽ�˵�
         */
        JFrame jFrame7=new JFrame("Menu");
        jFrame7.setLayout(new BorderLayout());
        jFrame7.setSize(600,500);
        jFrame7.setLocation(300,250);
        jFrame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame7.setVisible(true);
        //�����˵���
        JMenuBar jMenuBar=new JMenuBar();
        //��������˵�
        JMenu jMenu1=new JMenu("�ļ�(F)");
        JMenu jMenu2=new JMenu("����(H)");
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        //��������˵���
        JMenuItem jMenuItem1=new JMenuItem("�½�(N)");
        JMenuItem jMenuItem2=new JMenuItem("�˳�(X)");
        jMenu1.add(jMenuItem1);
        jMenu1.addSeparator();//�ڲ˵�ĩβ׷��һ���µķָ���
        jMenu1.add(jMenuItem2);
        //Ϊ���˵���ע�ᶯ��������
        ActionListener actionListener1= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //����һ��ģ̬�Ի��򴰿�
                JDialog jDialog=new JDialog(jFrame7,"�½��ļ��Ի�����",true);
                jDialog.setSize(200,200);
                jDialog.setLocation(400,300);
                jDialog.setVisible(true);
                jDialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);//Ĭ�ϴ��ڹرղ���
            }
        };
        jMenuItem1.addActionListener(actionListener1);
        jMenuItem2.addActionListener(e -> {
            //�˳�ϵͳ
            System.exit(0);
        });
        jFrame7.add(jMenuBar,BorderLayout.NORTH);

        /**
         * JPopupMenu����ʽ�˵�
         */
        JFrame jFrame8=new JFrame("JFrame");
        jFrame8.setSize(600,550);
        jFrame8.setLocation(500,200);
        jFrame8.setVisible(true);
        jFrame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //����JPopupMenu
        JPopupMenu jPopupMenu=new JPopupMenu("JPopupMenu");
        JMenuItem jMenuItem3=new JMenuItem("�鿴");
        JMenuItem jMenuItem4=new JMenuItem("ˢ��");
        jPopupMenu.add(jMenuItem3);
        jPopupMenu.addSeparator();
        jPopupMenu.add(jMenuItem4);
        //ΪjFrame8��Ӳ�ע�ᶯ��������
        jFrame8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //����������Ҽ�,��ʾJPopupMenu
                if(e.getButton()==MouseEvent.BUTTON3){
                    jPopupMenu.setVisible(true);
                }
            }
        });
        jFrame8.add(jPopupMenu);
    }

        public static void main(String[] args){

    SwingUtilities.invokeLater(SwingGUI::test11);

    /**
    * 1.ʹ�ø�Swing���������test02������ʾ����
    * SwingUtilities.invokeLater(Demo08::test02);
    *
    * 2.ֱ�ӵ��÷�����ʾ����
    * SwingGUI.test03();
    */
    }

}















