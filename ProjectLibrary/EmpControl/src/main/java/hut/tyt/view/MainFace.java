package hut.tyt.view;

import javax.swing.*;
import java.awt.*;

/**
 * @author 小飞侠 ysrazxy@foxmail.com
 * @version 1.0 JDK 13.0.1
 * @BelongsProject: EmpControl
 * @BelongsPackage: hut.tyt.face
 * @CreateTime: 2022-08-02  09:41
 * @Description: TODO
 */
public class MainFace {

    JPanel jPanel1;
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    GridBagLayout gridBagLayout;
    GridBagConstraints gridBagConstraints;
    JPanel jPanel;
    JScrollPane jScrollPane;
    JTable jTable;

    public MainFace() {
        init();
    }
    public void init(){

        JFrame frame = new JFrame("主界面");
        frame.setVisible(true);
        gridBagLayout = new GridBagLayout();
        gridBagConstraints = new GridBagConstraints();
        frame.setLayout(gridBagLayout);
        button1 = new JButton("部门查询");
        button2 = new JButton("员工查询");
        button3 = new JButton("职位查询");
        button4 = new JButton("添加员工");
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.weightx = 3;
        gridBagConstraints.weighty = 1;
        gridBagLayout.setConstraints(button1, gridBagConstraints);

        gridBagConstraints.gridx = 2;
        gridBagLayout.setConstraints(button2, gridBagConstraints);

        gridBagConstraints.gridx = 4;
        gridBagLayout.setConstraints(button3, gridBagConstraints);

        gridBagConstraints.gridx = 6;
        gridBagLayout.setConstraints(button4, gridBagConstraints);

        jPanel = new JPanel();

        Object[] empTitle = {"id","姓名","年龄","性别","邮箱","职位","部门","登入信息编号","ip号"};
        Object[] deptTitle = {"id","部门名"};
        Object[] positionTitle = {"id","职位名"};

        Object[][] tableData = {
                new Object[] {"sdaf","asdgfadgasgafdgareadsgfaff"},
                new Object[] {"sdaf","asdgfadgasgafdgareadsgfaff"},
                new Object[] {"sdaf","asdgfadgasgafdgareadsgfaff"},
                new Object[] {"sdaf","asdgfadgasgafdgareadsgfaff"}
        };
        jTable = new JTable(tableData,deptTitle);
        jScrollPane = new JScrollPane(jTable);
        //        关闭列大小调节功能
        jTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
//        只能选中单个单元格
        jTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//        jPanel.add(jScrollPane);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;

        gridBagConstraints.weightx = 12;
//        gridBagConstraints.fill = GridBagConstraints.BOTH;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagLayout.setConstraints(jScrollPane, gridBagConstraints);
        frame.add(jScrollPane);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setBounds(400, 300, 1000, 500);
//        frame.pack();
    }
}
