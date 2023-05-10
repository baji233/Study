package hut.tyt.view;

import hut.tyt.adaptor.MouseAdaptor;
import hut.tyt.mapper.InformationMapper;
import hut.tyt.monitor.LoginMonitor;
import hut.tyt.pojo.Information;
import hut.tyt.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * @author 小飞侠 ysrazxy@foxmail.com
 * @version 1.0 JDK 13.0.1
 * @BelongsProject: EmpControl
 * @BelongsPackage: hut.tyt.face
 * @CreateTime: 2022-07-30  12:50
 * @Description: TODO
 */
public class Login {
    //        登入界面
    JFrame jFrame;
    //        账号文本框
    public JTextField jTextField;
    //        账号标签
    JLabel jLabel;
    //        密码标签
    JLabel jLabel1;
    //        管理员标签
    JLabel jLabel2;
    //        密码文本框
    public JTextField jTextField1;
    //        管理员号文本框
    public JTextField jTextField2;
    //        登入状态文本框
    public JTextField jTextField3;
    //        登入按钮
    JButton jButton;
    //        布局方式
    GridBagLayout gridBagLayout;
    //        关联布局方式，获取组件布局
    GridBagConstraints gridBagConstraints;

    public Login() {
        init();
    }

    /**
     * 登入界面的初始化方法，在登入类的无参构造器中调用


     * @date: 2022/8/1 16:03
     */
    public void init(){
        jFrame = new JFrame("登入");
        jTextField = new JTextField(20);
        jLabel = new JLabel("账号");
        jLabel1 = new JLabel("密码");
        jTextField1 = new JTextField(20);
        jLabel2 = new JLabel("管理员");
        jTextField2 = new JTextField(20);
        jTextField3 = new JTextField("未登入",10);
        jButton = new JButton("登入");
        jFrame.add(jLabel2);
        jFrame.add(jTextField2);
        jFrame.add(jLabel);
        jFrame.add(jTextField);
        jFrame.add(jLabel1);
        jFrame.add(jTextField1);
        jFrame.add(jTextField3);
        jFrame.add(jButton);
        jFrame.setBounds(400, 300, 400, 300);
        gridBagLayout = new GridBagLayout();
        jFrame.setLayout(gridBagLayout);
        gridBagConstraints = new GridBagConstraints();

//        设置受该gridBagConstraints影响的组件位于网格的横向索引
        gridBagConstraints.gridx = 0;
//        设置受该gridBagConstraints影响的组件位于网格的纵向索引
        gridBagConstraints.gridy = 0;
//        设置受该gridBagConstraints影响的组件横向跨多少网格
        gridBagConstraints.gridwidth = 1;
//        设置受该gridBagConstraints影响的组件纵向跨多少网格
        gridBagConstraints.gridheight = 1;
//        设置那个组件受该gridBagConstraints控制
        gridBagLayout.setConstraints(jLabel2, gridBagConstraints);
//        设置该组件的外部填充大小   类似HTML中盒模型的外边距
        gridBagConstraints.insets = new Insets(5, 5, 2, 5);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 1;
        gridBagLayout.setConstraints(jTextField2, gridBagConstraints);
        gridBagConstraints.insets = new Insets(5, 5, 2, 5);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagLayout.setConstraints(jLabel, gridBagConstraints);
        gridBagConstraints.insets = new Insets(5, 5, 2, 5);

        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagLayout.setConstraints(jLabel1, gridBagConstraints);
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 1;
        gridBagLayout.setConstraints(jTextField, gridBagConstraints);
        gridBagConstraints.insets = new Insets(5, 5, 2, 5);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 1;
        gridBagLayout.setConstraints(jTextField1, gridBagConstraints);
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagLayout.setConstraints(jTextField3, gridBagConstraints);
        gridBagConstraints.insets = new Insets(5, 5, 5, 5);

        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 1;
        gridBagConstraints.gridheight = 1;
        gridBagLayout.setConstraints(jButton, gridBagConstraints);

//        设置登入界面可见
        jFrame.setVisible(true);
//        设置关闭
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        调整界面大小为最佳
        jFrame.pack();

//        添加登入按钮监听器
        jButton.addMouseListener(new LoginMonitor(this));
    }

}
