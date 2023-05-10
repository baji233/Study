import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * 此类仅用于个人测试
 */
public class SwingGUI {

    public static void test01() {
        /**
         * JFrame容器窗口
         */
        JFrame jFrame = new JFrame("JFrameTest");
        //设置关闭窗口时的默认操作:关闭时退出
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口尺寸
        jFrame.setSize(300, 250);
        //窗口可见
        jFrame.setVisible(true);

        /**
         * JDialog对话框窗口
         */
        JDialog jDialog = new JDialog(jFrame, "模态对话框", true);//设置顶级窗口,标题,是否是模态对话框
        //设置关闭窗口时的默认操作:关闭时隐藏
        jDialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
        jDialog.setSize(250, 150);
        jDialog.setVisible(true);
    }

    public static void test02(){
        /**
         * BorderLayout边界布局管理器
         */
        JFrame jFrame1=new JFrame("BorderLayout");
        //设置窗体布局
        jFrame1.setLayout(new BorderLayout());
        jFrame1.setSize(500,500);
        //设置窗体位置
        jFrame1.setLocation(300,200);
        //创建5个按钮并放置在不同区域
        jFrame1.add(new JButton("页头"),BorderLayout.NORTH);
        jFrame1.add(new JButton("行首"),BorderLayout.EAST);
        jFrame1.add(new JButton("行中"),BorderLayout.CENTER);
        jFrame1.add(new JButton("行尾"),BorderLayout.WEST);
        jFrame1.add(new JButton("页尾"),BorderLayout.SOUTH);
        jFrame1.setVisible(true);
        jFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public static void test03(){
        /**
         * FlowLayout流式布局管理器
         */
        JFrame jFrame2=new JFrame("FlowLayout");
        //设置对齐方式,水平间距,垂直间距
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
         * GridLayout网格布局管理器
         */
        JFrame jFrame3=new JFrame("GridLayout");
        //设置行数,列数,水平间距,垂直间距
        jFrame3.setLayout(new GridLayout(3,4,20,30));
        jFrame3.setSize(400,300);
        jFrame3.setLocation(350,350);
        //循环添加八个按钮到jFrame3中
        for(int i=1;i<13;i++){
            JButton jButton=new JButton("JButton"+i);
            jFrame3.add(jButton);
        }
        jFrame3.setVisible(true);
        jFrame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void test05(){
        /**
         * GridBagLayout网格袋布局管理器
         */

    }

    public static void test06(){
        /**
         * KeyListener键盘监听器
         */
        JFrame jFrame5=new JFrame("KeyEvent");
        jFrame5.setLayout(new FlowLayout());
        jFrame5.setSize(400,300);
        jFrame5.setVisible(true);
        jFrame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTextField jTextField=new JTextField(30);
        jFrame5.add(jTextField);
        //为文本框添加键盘事件监听器
        jTextField.addKeyListener(new KeyListener() { //继承KeyListener后,要实现他的三个方法
            @Override
            public void keyTyped(KeyEvent e) {
                //键入的键
            }
            @Override
            public void keyPressed(KeyEvent e) { //键按下
                char c=e.getKeyChar();
                System.out.println(c);
            }
            @Override
            public void keyReleased(KeyEvent e) {
                //钥匙释放
            }
        });
    }

    public static void test07(){
        /**
         * JScrollPane滚动条面板
         */
        //创建JFrame窗体
        JFrame jFrame6=new JFrame("JScrollPane");
        jFrame6.setSize(400,300);
        jFrame6.setVisible(true);
        jFrame6.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //创建JPanel面板
        JPanel jPanel=new JPanel();
        for(int i=1;i<=100;i++){
            jPanel.add(new JButton("按钮"+i));
        }
        //创建JScrollPane组件
        JScrollPane jScrollPane=new JScrollPane();
        jScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);//水平滚动条自动显示
        jScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);//垂直滚动条始终显示
        //添加添加添加
        jScrollPane.setViewportView(jPanel);
        jFrame6.add(jScrollPane);
    }

    public static void test08(){
        /**
         * JTextField文本框/JTextArea文本域
         */
        JFrame jFrame7=new JFrame("聊天窗口");
        jFrame7.setLayout(new BorderLayout());
        jFrame7.setSize(600,500);
        jFrame7.setLocation(300,250);
        jFrame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame7.setVisible(true);
        //创建一个文本域用来显示多行聊天信息
        JTextArea jTextArea=new JTextArea(15,30);
        jTextArea.setEditable(false);//设置文本域不可编辑
        //将文本域装入滚动条面板
        JScrollPane jScrollPane=new JScrollPane(jTextArea);
        //创建一个文本框用来输入单行聊天信息
        JTextField jTextField=new JTextField(30);
        JButton jButton=new JButton("发送");
        //创建一个JPanel面板...
        JPanel jPanel=new JPanel();
        JLabel jLabel=new JLabel("聊天信息");
        //向JPanel按顺序添加jLabel,jTextField,jButton
        jPanel.add(jLabel);
        jPanel.add(jTextField);
        jPanel.add(jButton);
        //向jFrame7的顶部和底部添加和jPanel
        jFrame7.add(jScrollPane,BorderLayout.NORTH);
        jFrame7.add(jPanel,BorderLayout.SOUTH);
        //为按钮添加动作监听器(当只有一个按钮需要监听器时,可以使用Lambda表达式来实现抽象方法)
        jButton.addActionListener(e->{
            String text=jTextField.getText();
            if(text!=null && !text.trim().equals("")){ //空格或未输入
                //如果输入信息不为空,就将输入文本追加到文本域显示
                jTextArea.append("我的信息: "+text+"\n");
            }else{
                //如果为空...
                jTextArea.append("聊天信息不能为空!\n");
            }
            //然后将文本框重置为空
            jTextField.setText("");
        });
    }

    public static void test09(){
        /**
         * JCheckBox复选框按钮/JRadioButton单选按钮
         */
        JFrame jFrame7=new JFrame("设置字体01");
        jFrame7.setLayout(new BorderLayout());
        jFrame7.setSize(600,500);
        jFrame7.setLocation(300,250);
        jFrame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame7.setVisible(true);
        //标签文本居中显示
        JLabel jLabel=new JLabel("Hello World!",JLabel.CENTER);
        jLabel.setFont(new Font("宋体",Font.PLAIN,25));//Font.PLAIN:朴素的风格不变
        //创建两个复选框按钮
        JCheckBox jCheckBox01=new JCheckBox("斜体");
        JCheckBox jCheckBox02=new JCheckBox("加粗");
        //创建两个单选按钮
        JRadioButton jRadioButton01=new JRadioButton("楷书");
        JRadioButton jRadioButton02=new JRadioButton("30");
        //将两个单选按钮放在同一个按钮组
        ButtonGroup buttonGroup=new ButtonGroup();
        buttonGroup.add(jRadioButton01);
        buttonGroup.add(jRadioButton02);
        //添加添加添加
        JPanel jPanel=new JPanel();
        jPanel.add(jCheckBox01);
        jPanel.add(jCheckBox02);
        jPanel.add(jRadioButton01);
        jPanel.add(jRadioButton02);
        jFrame7.add(jLabel,BorderLayout.CENTER);
        jFrame7.add(jPanel,BorderLayout.SOUTH);
        //为复选框按钮添加动作监听器(当有多个按钮需要监听器时,就用匿名内部类吧)
        ActionListener actionListener01=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int mode=0;//字体风格
                if(jCheckBox01.isSelected()){ //如果选择了切换按钮，则为true
                    mode+=Font.ITALIC;//斜体样式常量
                }
                if(jCheckBox02.isSelected()){
                    mode+=Font.BOLD;//粗体样式常量
                }
                //将字体重新设置
                jLabel.setFont(new Font("宋体",mode,25));
            }
        };
        //为单选按钮添加动作监听器
        ActionListener actionListener02=new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String s="楷书";
                int i=30;
                if(jRadioButton01.isSelected()){
                    jLabel.setFont(new Font("楷书",Font.PLAIN,25));//换字体
                }
                if(jRadioButton02.isSelected()){
                    jLabel.setFont(new Font("宋体",Font.PLAIN,i));//改大小
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
         * JComboBox下拉框
         */
        JFrame jFrame7=new JFrame("JComboBox");
        jFrame7.setLayout(new BorderLayout());
        jFrame7.setSize(600,500);
        jFrame7.setLocation(300,250);
        jFrame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame7.setVisible(true);
        JPanel jPanel=new JPanel();
        //创建下拉框组件并添加选项
        JComboBox<String> jComboBox=new JComboBox<>();
        jComboBox.addItem("请选择你的英雄");
        jComboBox.addItem("鲁班七号");
        jComboBox.addItem("百里守约");
        jComboBox.addItem("孙尚香");
        jComboBox.addItem("诸葛亮");
        jComboBox.addItem("程咬金");
        //创建文本框用来展示用户选项
        JTextField jTextField=new JTextField(20);
        //为下拉框添加动作监听器
        ActionListener actionListener= e -> {
            //获取选中选项的字符串
            String item=(String)jComboBox.getSelectedItem();
            if("请选择你的英雄".equals(item)){
                jTextField.setText("");
            }else{
                jTextField.setText("你选择的英雄是:"+item);
            }
        };
        //添加添加添加
        jComboBox.addActionListener(actionListener);
        jPanel.add(jComboBox);
        jPanel.add(jTextField);
        jFrame7.add(jPanel,BorderLayout.CENTER);
    }

    public static void test11() {
        /**
         * JMenuBar下拉式菜单
         */
        JFrame jFrame7=new JFrame("Menu");
        jFrame7.setLayout(new BorderLayout());
        jFrame7.setSize(600,500);
        jFrame7.setLocation(300,250);
        jFrame7.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame7.setVisible(true);
        //创建菜单栏
        JMenuBar jMenuBar=new JMenuBar();
        //添加两个菜单
        JMenu jMenu1=new JMenu("文件(F)");
        JMenu jMenu2=new JMenu("帮助(H)");
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        //添加两个菜单项
        JMenuItem jMenuItem1=new JMenuItem("新建(N)");
        JMenuItem jMenuItem2=new JMenuItem("退出(X)");
        jMenu1.add(jMenuItem1);
        jMenu1.addSeparator();//在菜单末尾追加一个新的分隔符
        jMenu1.add(jMenuItem2);
        //为俩菜单项注册动作监听器
        ActionListener actionListener1= new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //创建一个模态对话框窗口
                JDialog jDialog=new JDialog(jFrame7,"新建文件对话窗口",true);
                jDialog.setSize(200,200);
                jDialog.setLocation(400,300);
                jDialog.setVisible(true);
                jDialog.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);//默认窗口关闭操作
            }
        };
        jMenuItem1.addActionListener(actionListener1);
        jMenuItem2.addActionListener(e -> {
            //退出系统
            System.exit(0);
        });
        jFrame7.add(jMenuBar,BorderLayout.NORTH);

        /**
         * JPopupMenu弹出式菜单
         */
        JFrame jFrame8=new JFrame("JFrame");
        jFrame8.setSize(600,550);
        jFrame8.setLocation(500,200);
        jFrame8.setVisible(true);
        jFrame8.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //创建JPopupMenu
        JPopupMenu jPopupMenu=new JPopupMenu("JPopupMenu");
        JMenuItem jMenuItem3=new JMenuItem("查看");
        JMenuItem jMenuItem4=new JMenuItem("刷新");
        jPopupMenu.add(jMenuItem3);
        jPopupMenu.addSeparator();
        jPopupMenu.add(jMenuItem4);
        //为jFrame8添加并注册动作监听器
        jFrame8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //如果点击鼠标右键,显示JPopupMenu
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
    * 1.使用该Swing工具类调用test02方法显示窗体
    * SwingUtilities.invokeLater(Demo08::test02);
    *
    * 2.直接调用方法显示窗体
    * SwingGUI.test03();
    */
    }

}















