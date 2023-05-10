package com.jiuyun.system.view;

import com.jiuyun.system.control.CollectionRecordActionListener;
import com.jiuyun.system.model.CollectionRecordDao;
import com.jiuyun.system.vo.CollectionRecordVO;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * 查询收款记录窗体
 * @author Tanjiawei
 */
public class CollectionRecordFrame extends JFrame {
    JPanel topPanel;
    JScrollPane centerPanel;
    JPanel bottomPanel;
    /**
     * 初始化窗体
     */
    private void initialCollectionRecordFrame(){
        this.setTitle("收款记录查询");
        this.setSize(1200,800);
        this.setLocation(300,150);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
    }
    public CollectionRecordFrame() {
        initialCollectionRecordFrame();
        initialTopPanel();
        this.add(topPanel,BorderLayout.NORTH);
        initialCenterPanel();
        this.add(centerPanel,BorderLayout.CENTER);
        initialBottomPanel();
        this.add(bottomPanel,BorderLayout.SOUTH);
    }

    /**
     * 初始化顶部面板(查询操作)
     */
    JLabel timeLabel;
    public JTextField timeTextField;
    JLabel typeLabel;
    public JComboBox<String> typeComboBox;
    public JTextField typeTextField;
    JButton selectButton;
    private void initialTopPanel(){
        topPanel=new JPanel();
        topPanel.setBackground(Color.LIGHT_GRAY);
        GridBagLayout groupLayout=new GridBagLayout();
        GridBagConstraints gridBagConstraints=new GridBagConstraints();
        gridBagConstraints.insets=new Insets(10,5,10,5);
        topPanel.setLayout(groupLayout);

        Font font=new Font("宋体",Font.BOLD,18);
        timeLabel=new JLabel("收款日期:");
        timeLabel.setFont(font);
        timeTextField=new JTextField(10);
        typeLabel=new JLabel("请根据类型输入查询信息:");
        typeLabel.setFont(font);
        typeComboBox=new JComboBox<>();
        typeComboBox.setEditable(false);
        typeComboBox.addItem("读者编号");
        typeComboBox.addItem("读者姓名");
        typeTextField=new JTextField(15);
        selectButton=new JButton("查询");
        selectButton.setActionCommand("select");
        CollectionRecordActionListener cral=new CollectionRecordActionListener(this);
        selectButton.addActionListener(cral);

        addByConstraints(gridBagConstraints,0,0,1,1,typeLabel);
        addByConstraints(gridBagConstraints,1,0,1,1,typeComboBox);
        addByConstraints(gridBagConstraints,2,0,1,1,typeTextField);
        addByConstraints(gridBagConstraints,3,0,1,1,timeLabel);
        addByConstraints(gridBagConstraints,4,0,1,1,timeTextField);
        addByConstraints(gridBagConstraints,5,0,1,1,selectButton);
    }

    /**
     * 添加约束
     * @param gridBagConstraints 网格包约束
     * @param row 横坐标
     * @param col 纵坐标
     * @param width 网格宽度.
     * @param height 网格高度
     * @param component 组件
     */
    private void addByConstraints(GridBagConstraints gridBagConstraints,int row,int col,int width,int height,Component component){
        gridBagConstraints.gridx=row;
        gridBagConstraints.gridy=col;
        gridBagConstraints.gridwidth=width;
        gridBagConstraints.gridheight=height;
        topPanel.add(component,gridBagConstraints);
    }

    /**
     * 初始化中间面板(收款记录表)
     */
    JTable table;
    public void initialCenterPanel() {
        centerPanel=new JScrollPane();
        centerPanel.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        centerPanel.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        List<CollectionRecordVO> allRecord=CollectionRecordDao.selectALLRecord();
        table=CollectionRecordDao.getTable(allRecord);
        table.setEnabled(false);
        centerPanel.setViewportView(table);
    }

    /**
     * 初始化底部面板(记录条数)
     */
    JLabel recordsLabel;
    private void initialBottomPanel(){
        bottomPanel=new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        int row=CollectionRecordDao.tableModel.getRowCount();
        recordsLabel=new JLabel("共"+row+"条记录");
        Font font=new Font("宋体",Font.BOLD,20);
        recordsLabel.setFont(font);
        bottomPanel.add(recordsLabel);
    }


    public static void main(String[] args) {
        /**
         * 测试
         */
        new CollectionRecordFrame().setVisible(true);
    }
}













