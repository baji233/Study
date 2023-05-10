package com.jiuyun.system.view;

import com.jiuyun.system.control.BookTypeAction;
import com.jiuyun.system.model.BookTypeDao;
import com.jiuyun.system.vo.CategoryInfoVo;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.util.*;
import java.util.List;

//图书类型的管理
public class BookTypeInfoView extends JFrame {
    JSplitPane mainPanel;
    JPanel treePanel;
    JPanel btnPanel;
    public DefaultTreeModel bookTypeTModel;
    public JTree bookTypeTree;
    JScrollPane scrollPane;
    TreePath selectPath;
    public DefaultMutableTreeNode selectNode;
    public DefaultMutableTreeNode parentNode;
    Box btnBox;
    JButton btnDeleteCate;
    JButton btnUpdateCate;
    JButton btnAddChildCate;
    JButton btnAddSameCate;
    public BookTypeInfoView(){
        initialStyle();
        mainPanel=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
//        mainPanel.setSize(300,200);
        initialTreePanel();
        mainPanel.setLeftComponent(treePanel);
        mainPanel.setDividerLocation(200);
        initialBtnPanel();
        mainPanel.setRightComponent(btnPanel);
        this.add(mainPanel);
        this.setSize(400,300);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    }

    public void initialStyle(){
        setLocation(100,100);
    }

    public void initialTreePanel(){

        //对表格数据进行关系管理
        List<CategoryInfoVo> CategoryInfoVoList = BookTypeDao.queryAllBookType();
        /*Vector root=new Vector<>();
        for(CategoryInfoVo tmp:CategoryInfoVoList){
            if(tmp.getCateGoryId().length()==1){

            }
        }*/
//        对list集合的元素按编号进行排序,传入比较器Comparator
        TreeSet<CategoryInfoVo> treeSetBookType=new TreeSet<>(new Comparator<CategoryInfoVo>() {
            @Override
            public int compare(CategoryInfoVo o1, CategoryInfoVo o2) {
                return o1.getCateGoryStructure().compareTo(o2.getCateGoryStructure());
            }
        });
        //批量导入
        treeSetBookType.addAll(CategoryInfoVoList);
        CategoryInfoVoList = new ArrayList<>(treeSetBookType);
        //遍历输出
        for(CategoryInfoVo tmp:CategoryInfoVoList){
            System.out.print(tmp.getCateGoryStructure()+"*"+tmp.getCateGoryName()+" ");
        }

        DefaultMutableTreeNode root=new DefaultMutableTreeNode("图书分类");
        for(CategoryInfoVo tmp:CategoryInfoVoList){
            int length = tmp.getCateGoryStructure().length();
            if(length==1){
                DefaultMutableTreeNode child=new DefaultMutableTreeNode(tmp.getCateGoryStructure()+"*"+tmp.getCateGoryName());
                root.add(child);
            }else{
                //扔掉首字符
                String childString=tmp.getCateGoryStructure().substring(1);
                //获取当前的子节点
                int count = root.getChildCount()-1;
                recursion((DefaultMutableTreeNode) root.getChildAt(count),childString,tmp);
            }
        }

        bookTypeTModel=new DefaultTreeModel(root);
        bookTypeTree=new JTree();
        bookTypeTree.setModel(bookTypeTModel);
        bookTypeTree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                selectPath=e.getPath();
                //获取当前选中的节点
                selectNode=(DefaultMutableTreeNode)selectPath.getLastPathComponent();
                parentNode=(DefaultMutableTreeNode) selectNode.getParent();
            }
        });
        bookTypeTree.setPreferredSize(new Dimension(150,200));
        scrollPane=new JScrollPane();
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.add(bookTypeTree);
        scrollPane.setViewportView(bookTypeTree);
        treePanel=new JPanel();
        treePanel.add(scrollPane,BorderLayout.CENTER);
    }

    public void recursion(DefaultMutableTreeNode parentNode,String parentString,CategoryInfoVo tmpBookType){
        if(parentString.length()==1){
            DefaultMutableTreeNode child=new DefaultMutableTreeNode(tmpBookType.getCateGoryStructure()+"*"+tmpBookType.getCateGoryName());
            parentNode.add(child);
        }else{
            //获取当前的子节点
            int count=parentNode.getChildCount()-1;
            //扔掉首字符
            String childString=parentString.substring(1);
            recursion((DefaultMutableTreeNode) parentNode.getChildAt(count),childString,tmpBookType);
        }
    }


    public void initialBtnPanel(){
        btnPanel=new JPanel();
        btnBox=Box.createVerticalBox();
        BookTypeAction bookTypeAction=new BookTypeAction(this);
        btnAddChildCate=new JButton("增加下级类别");
        btnAddChildCate.setActionCommand("addChildBookType");
        btnAddChildCate.addActionListener(bookTypeAction);

        btnAddSameCate=new JButton("增加同级类别");
        btnAddSameCate.setActionCommand("addSameCategoryBT");
        btnAddSameCate.addActionListener(bookTypeAction);

        btnUpdateCate=new JButton("修改当前类别");
        btnUpdateCate.setActionCommand("updateBookType");
        btnUpdateCate.addActionListener(bookTypeAction);

        btnDeleteCate=new JButton("删除选中类别");
        btnDeleteCate.setActionCommand("deleteBookType");
        btnDeleteCate.addActionListener(bookTypeAction);

        btnBox.add(btnAddSameCate);
        btnBox.add(Box.createVerticalStrut(10));
        btnBox.add(btnAddChildCate);
        btnBox.add(Box.createVerticalStrut(10));
        btnBox.add(btnUpdateCate);
        btnBox.add(Box.createVerticalStrut(10));
        btnBox.add(btnDeleteCate);
        btnPanel.add(btnBox);
    }

    public static void main(String[] args) {
        BookTypeInfoView bookTypeInfoView=new BookTypeInfoView();
        bookTypeInfoView.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
