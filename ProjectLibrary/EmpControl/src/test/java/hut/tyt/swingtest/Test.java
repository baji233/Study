package hut.tyt.swingtest;

import javax.swing.*;
import java.sql.ResultSetMetaData;

/**
 * @author 小飞侠 ysrazxy@foxmail.com
 * @version 1.0 JDK 13.0.1
 * @BelongsProject: EmpControl
 * @BelongsPackage: hut.tyt.swingtest
 * @CreateTime: 2022-08-03  21:25
 * @Description: TODO
 */
public class Test {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JScrollPane jScrollPane;


        Object[] empTitle = {"id","姓名","年龄","性别","邮箱","职位","部门","登入信息编号","ip号"};
        Object[] deptTitle = {"id","部门名"};
        Object[] positionTitle = {"id","职位名"};

        Object[][] tableData = {
                new Object[] {"sdaf","asdgf"},
                new Object[] {"sdaf","asdgf"},
                new Object[] {"sdaf","asdgf"},
                new Object[] {"sdaf","asdgf"},
                new Object[] {"sdaf","asdgfadgasgafdgareadsgfaffdgfadgasgafdgareadsgfaffdgfadgasgafdgareadsgfaff"},
                new Object[] {"sdaf","asdgfadgasgafdgareadsgfaffdgfadgasgafdgareadsgfaffdgfadgasgafdgareadsgfaff"},
                new Object[] {"sdaf","asdgfadgasgafdgareadsgfaffdgfadgasgafdgareadsgfaffdgfadgasgafdgareadsgfaff"}
        };
        JTable jTable = new JTable(tableData,deptTitle);
        jScrollPane = new JScrollPane(jTable);
        frame.add(jScrollPane);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();

    }
}
