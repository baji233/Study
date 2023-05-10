package system.util;

import java.io.FileInputStream;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class CommonDao {

    public static boolean operModify(String sql,Object...paramValues) {
        boolean isSuccess=false;
        Connection conn=null;
        PreparedStatement pstmt=null;
        try {
            conn=DBUtil.getConnection();
            pstmt=conn.prepareStatement(sql);
            int index=1;

            if (paramValues!=null) {
                for (Object tmpObject : paramValues) {
                    pstmt.setObject(index++, tmpObject);
                }
                System.out.println(pstmt);
                int row=pstmt.executeUpdate();

                if (row>0) {
                    System.out.println("�ɹ�!");
                    isSuccess=true;
                }else {
                    System.out.println("ʧ��!");
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally {
            DBUtil.releaseDBResource(conn, pstmt, null);
        }
        return isSuccess;
    }
    /*
     * ����ѯ�����װ��vo������
     * �����ֶ�����vo��������һֱ��Сд��
     */

    public static List queryInfo(String querySQL,Class voClass,Object...paramValues) {
        List items=new ArrayList();
        Connection conn=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;
        try {
            conn=DBUtil.getConnection();
            pstmt=conn.prepareStatement(querySQL);

            if(paramValues!=null) {
                int paramIndex=1;

                for (Object p : paramValues) {

                    pstmt.setObject(paramIndex++, p);
                }
                System.out.println(pstmt);
            }
            rs=pstmt.executeQuery();
            //��ò�ѯ�������Ԫ����(�������ֶ������Ϣ��
            ResultSetMetaData rsmd=rs.getMetaData();
            //System.out.println(rsmd);
            int cols = rsmd.getColumnCount();
            //System.out.println(cols);
            //String cName = rsmd.getColumnName(1);
            while (rs.next()) {
                Object vo=voClass.newInstance();
                for (int i = 1; i <=cols; i++) {
                    //�õ��ֶε�����
                    String cName=rsmd.getColumnName(i);
                    String lowerCname=cName.toLowerCase();
                    //���ݶ����������
                    String fieldName=props.getProperty(lowerCname);
                    //��ȡ�ֶε�ֵ
                    //System.out.println(fieldName);
                    Object columnValue=rs.getObject(cName);
                    //����vo����Setxx����Ϊ���Ը�ֵ
                    Field field=voClass.getDeclaredField(fieldName);

                    field.setAccessible(true);
                    field.set(vo, columnValue);
                }
                //System.out.println(	);
                items.add(vo);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            DBUtil.releaseDBResource(conn, pstmt, rs);
        }
        return items;
    }

    public static Properties props=null;

    static {
        props = loadProps();
    }

    //��ȡuserinfo.properties
    public static Properties loadProps() {
        Properties props=null;
        try {
            FileInputStream fis=new FileInputStream("userinfo.properties");
            props=new Properties();
            props.load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return props;
    }

    public static void main(String[] args) {
//		String sql="select ?,? from userinfo";
//		String []need= {"userid","userpwd"};
//		List lst=queryInfo(sql,UserInfo.class,need);
//		for(int i=0;i<lst.size();i++)
//		{
//			System.out.println(lst.get(i));
//		}
//        String sql= "select * from employee_info";
//        List lst=CommonDao.queryInfo(sql, EmployeeInfo.class, null);
//        EmployeeInfo info=new EmployeeInfo();
//        String s=new String();
//        for (int i = 0; i < lst.size(); i++) {
//            info=(EmployeeInfo) lst.get(i);
//            System.out.println(info);
//        }

    }

}
