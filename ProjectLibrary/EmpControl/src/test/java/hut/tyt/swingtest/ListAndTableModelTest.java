package hut.tyt.swingtest;

import javax.swing.*;

/**
 * @author 小飞侠 ysrazxy@foxmail.com
 * @version 1.0 JDK 13.0.1
 * @BelongsProject: EmpControl
 * @BelongsPackage: hut.tyt.swingtest
 * @CreateTime: 2022-08-08  11:13
 * @Description: TODO
 */
public class ListAndTableModelTest {
    public static void main(String[] args) {
//        主窗口
        JFrame frame = new JFrame();
//        新建TableModel
        ListAndTableModel listAndTableModel = new ListAndTableModel();
//        通过TableModel创建表格
        JTable jTable = new JTable(listAndTableModel);
//        表格放入滚动窗口中，注意不是用add方法放入
        JScrollPane jScrollPane = new JScrollPane(jTable);
//        添加滚动窗口进入主窗口
        frame.add(jScrollPane);
//        设置主窗口可见
        frame.setVisible(true);
//        设置关闭方式
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
