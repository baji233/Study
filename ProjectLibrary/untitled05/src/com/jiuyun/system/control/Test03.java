package com.jiuyun.system.control;

import com.jiuyun.system.model.Test02;
import com.jiuyun.system.vo.Test01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

/**
 * ��ť�¼�����ʵ����
 */
public class Test03 implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        String str=e.getActionCommand();
        Test02 o=new Test02();
        if("query".equals(str)){
            Test01 test01 =new Test01();
            String empName= test01.getEmpName();
            String empJob= test01.getJob();
            if(!"".equals(empName)){
                String sql="select * from empinfo where ����=?";
                o.queryEmpInfo(empName,sql);
            }else if(!"".equals(empJob)){
                String sql="select * from empinfo where ����=?";
                o.queryEmpInfo(empJob,sql);
            }else if(!"".equals(empName)&!"".equals(empJob)){
                System.out.println("ֻ������һ��!!!");
            }
        }else if("add".equals(str)){
            o.addEmpInfo();
        }else if("delete".equals(str)){
            o.deleteEmpInfo();
        }else if("update".equals(str)){
            try {
                o.updateEmpInfo();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    public static void main(String[] args){

    }
}

