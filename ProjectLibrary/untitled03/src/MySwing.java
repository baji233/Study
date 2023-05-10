import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class MySwing extends JFrame {
    JButton jButton;//按钮
    JRadioButton jrbMan,jrbWoman;//单选按钮
    ButtonGroup buttonGroup=new ButtonGroup();//按钮组
    JLabel lblUid,lblPwd,lblSex,lblLike,lblCity;//标签
    JTextField jTextField;//文本框
    JPasswordField jPasswordField;//密码框
    JCheckBox jCheckBox01,jCheckBox02,jCheckBox03;//复选框
    JComboBox jComboBox;//下拉框
    JTextArea jTextArea;//文本域

    //无参构造方法调用普通方法
    public MySwing(){
        test01();
        test02();
    }
    //创建基本组件并添加到窗体中
    private void test02(){
        FlowLayout flowLayout=new FlowLayout();//流式布局
        this.setLayout(flowLayout);
        //带图片的按钮
        jButton=new JButton(new ImageIcon("图片\\1(2)"));
        //设置按钮的边框
        jButton.setBorder(BorderFactory.createLineBorder(Color.YELLOW,2));

        lblUid=new JLabel("用户名: ");
        //设置字体颜色
        lblUid.setForeground(Color.BLUE);
        //设置字体 字体名，字体风格，字体大小
        Font font=new Font("宋体",Font.ITALIC,20);
        lblUid.setFont(font);
        //设置文本内容的对齐方式
        lblUid.setHorizontalTextPosition(SwingConstants.LEFT);

        //设置文本框
        jTextField=new JTextField(15);
        jTextField.setBorder(BorderFactory.createLineBorder(Color.RED,3));
        jTextField.setText("HolleWorld~");
        //文本框不可用
        jTextField.setEnabled(false);
        lblPwd=new JLabel("密码");
        jPasswordField=new JPasswordField(10);

        //单选按钮--值,是否被选中
        lblSex=new JLabel("性别");
        jrbMan=new JRadioButton("男");
        jrbWoman=new JRadioButton("女");
        //获得单选按钮是否被选中
        boolean b1=jrbMan.isSelected();
        String str1=jrbMan.getText();
        //将两个单选按钮加入到组
        buttonGroup.add(jrbMan);
        buttonGroup.add(jrbWoman);

        //爱好复选按钮
        lblLike=new JLabel("爱好");
        jCheckBox01=new JCheckBox("唱跳");
        jCheckBox02=new JCheckBox("RAP");
        jCheckBox03=new JCheckBox("篮球");

        //下拉框
        lblCity=new JLabel("城市");
        Vector<String> vector=new Vector<String>();//向量数组
        vector.add("长沙");
        vector.add("湘潭");
        vector.add("株洲");
        jComboBox=new JComboBox(vector);
        jComboBox.addItem("岳阳");//将项目添加到项目列表
        //设置默认被选中的条目
        jComboBox.setSelectedIndex(2);
        //获得被选中的条目对应的内容
        String str3=(String)jComboBox.getSelectedItem();//Object强制转换为String

        //文本域(指定行列)
        jTextArea=new JTextArea(4,15);
        //设置内容满的时候，自动换行
        jTextArea.setLineWrap(true);
        //设置滚动条
        JScrollPane jScrollPane=new JScrollPane(jTextArea);
        jScrollPane.setViewportView(jTextArea);

        //添加到窗体
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

        //初始化窗体的属性特征
    private void test01(){
        Toolkit toolkit=Toolkit.getDefaultToolkit();//获取默认工具包
        Dimension dimension=toolkit.getScreenSize();//获取屏幕的大小
        double height=dimension.getHeight();
        double width=dimension.getWidth();
        //设置窗体位置,大小,标题,锁定大小,背景颜色
        this.setLocation(150,120);
        this.setSize(500,400);
        this.setTitle("用户注册");
        this.setResizable(true);
        this.getContentPane().setBackground(Color.pink);//设置窗体的背景颜色
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗口关闭的同时系统自动退出
        this.setVisible(true);//显示JFrame窗体
    }

    public static void main(String[] args){
        MySwing mySwing=new MySwing();
        mySwing.test01();
    }
}




































