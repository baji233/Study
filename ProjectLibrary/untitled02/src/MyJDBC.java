import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * JDBC
 */
public class MyJDBC {
    public static void main(String[] args) {
        myConnection();

    }
    //���Ӳ���
    public static Connection myConnection(){
        Connection connection = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database01", "root", "88888888");
            if (connection != null) {
                System.out.println("���ӳɹ�");
            } else {
                System.out.println("����ʧ��");
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
class DBConnection {
    public void test01() {
        Connection connection = null;//�������ݿ����
        Statement statement = null;//ִ��SQL������
        try {
            String str1 = "insert into table01 values ('top01','С��',18,'2022-8-2')";//����sql���
            connection = MyJDBC.myConnection();//��ȡ���Ӷ���
            statement = connection.createStatement();//ִ�����ݿ�����Ľӿ�
            int i1 = statement.executeUpdate(str1);//Ӱ�������
            if (i1 > 0) {
                System.out.println("�ɹ�!");
            } else {
                System.out.println("ʧ��!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                //�ͷ���Դ
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //��ѯ
    public void test02() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet=null;//��ѯ�����
        try {
            String str2="select * from table01";//��ѯsql���
            connection=MyJDBC.myConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery(str2);
            //ָ������,�������true,��ʾ��ǰָ�������ֵ��,����ȡ��ֵ
            while(resultSet.next()){
                String id=resultSet.getString("uid");
                String name=resultSet.getString("uname");
                int age=resultSet.getInt("uage");
                String birthday=resultSet.getString("ubirthday");
                System.out.println(id+" "+name+" "+age+" "+birthday);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            try {//�ͷ���Դ
                resultSet.close();
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

/**
 * ��¼��
 * ʵ�ֵ�¼����
 */
class Deer{
    public static boolean chaeck(String LogId,String LogPass){
        Connection connection = null;
        PreparedStatement preparedStatement=null;//��ȫ��ִ��Ԥ�����SQL���,���֮��Statement�ᱻSQLע��
        ResultSet resultSet=null;
        boolean flag=false;//�ж��Ƿ��¼�ɹ�,Ĭ�ϱ�ʾ��¼���ɹ�
        try{
            String sql="select count(uid) from table01 where uid=? and uage=?";
            DBUtil.getConnection();
            //����SQL��ѯ�����ռλ����ֵ
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,LogId);
            preparedStatement.setString(2,LogPass);
            resultSet=preparedStatement.executeQuery();
            resultSet.next();//��resultSet�����䵱ǰλ����ǰ�ƶ�һ��
            int i=resultSet.getInt(1);
            if(i>0){
                System.out.println("�ɹ�!");
                flag=true;
            }else{
                System.out.println("ʧ��");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.freed02(connection,preparedStatement,resultSet);
        }
        return flag;
    }
    //����û�
    public static void addUser(){
        String sql="insert into table01 values (?,?,?,?)";
        Object[] values={"top05","С��",15,"2021-5-30"};
        Common.operModify(sql,values);//������ɾ�Ĺ�����
    }
}

/**
 * ������
 * �����������ݿ���ͷ���Դ
 */
class DBUtil{
    public static final String URL="jdbc:mysql://localhost:3306/database01";
    public static final String DRIVER_CLASS="com.mysql.cj.jdbc.Driver";
    //������
    public static Connection getConnection(){
        Connection connection;
        try{
            Class.forName(DRIVER_CLASS);
            connection=DriverManager.getConnection(URL,"root","88888888");
        }catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
    //�ͷ���
    public static void freed01(Connection connection,Statement statement,ResultSet resultSet){
    try{
        if(resultSet!=null){
            resultSet.close();
        }
        if(statement!=null){
            statement.close();
        }
        if(connection!=null){
            connection.close();
        }
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}
    public static void freed02(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        try{
            if(resultSet!=null){
                resultSet.close();
            }
            if(preparedStatement!=null){
                preparedStatement.close();
            }
            if(connection!=null){
                connection.close();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

/**
 * ��ɾ�Ĺ�����
 * �����б�-->(sql���,ע�����...)
 */
class Common{
    public static boolean operModify(String sql,Object...paramValues){
        boolean b=false;
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=DBUtil.getConnection();
            preparedStatement=connection.prepareStatement(sql);
            int i=1;
            if(paramValues!=null){
                //ѭ�����ò���ֵ
                for(Object tmpe:paramValues){
                    preparedStatement.setObject(i++,tmpe);//������������ָ��������ֵ
                }
            }
            int x=preparedStatement.executeUpdate();
            if(x>0){
                System.out.println("���³ɹ�!");
                b=true;
            }else{
                System.out.println("����ʧ��!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.freed02(connection,preparedStatement,null);
        }
        return b;
    }
}

/**
 * ֵ����
 * ��װ��������
 * ��ÿ����¼���һ������,��������Ծ������Ա,��ͨ��list�����������Ǵ����ͻ���
 */
class UserInfo{
    //�������ֶη�װ����
    private String uid;
    private String uname;
    private int uage;
    private String ubirthday;

    public UserInfo(){}//���޲ι��췽��
    public UserInfo(String uid,String uname,int uage,String ubirthday){//���ù��췽��������ֵ
        super();
        this.uid=uid;
        this.uname=uname;
        this.uage=uage;
        this.ubirthday=ubirthday;
    }
    public String getUserId(){
        return uid;
    }
    public void setUserId(String uid){
        this.uid=uid;
    }
    public String getUname(){
        return uname;
    }
    public void setUname(String uname){
        this.uname=uname;
    }
    public int getUage(){
        return uage;
    }
    public void setUage(int uage){
        this.uage=uage;
    }
    public String getUbirthday(){
        return ubirthday;
    }
    public void setUbirthday(String ubirthday){
        this.ubirthday=ubirthday;
    }

    //��ArrayList��ʽ���ز�ѯ���¼
    public static List<UserInfo> query(){
        ArrayList<UserInfo> arrayList=new ArrayList<UserInfo>();
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        try{
            connection=DBUtil.getConnection();
            String sql="select * from table01";
            preparedStatement=connection.prepareStatement(sql);
            resultSet=preparedStatement.executeQuery();
            while(resultSet.next()){
                String uid= resultSet.getString("uid");
                String uname= resultSet.getString("uname");
                int uage= resultSet.getInt("uage");
                String ubirthday= resultSet.getString("ubirthday");
                UserInfo userInfo=new UserInfo(uid,uname,uage,ubirthday);
                arrayList.add(userInfo);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.freed02(connection,preparedStatement,resultSet);
        }
        return arrayList;
    }
}

class Tese1{
    /**
     * ������
     * һ����ִ�ж���sql���,���Ч��
     */
    public static void executes(){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=DBUtil.getConnection();
            String sql="insert into table01 values(?,?,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            int a=1;
            for(int b=10;b<=110;b++){//ѭ��100��
                preparedStatement.setString(1,"top06"+b);
                preparedStatement.setString(2,"С��"+b);
                preparedStatement.setInt(3,b);
                preparedStatement.setString(4,"2020-8-3");
                //ִ��������ķ���,���浱ǰSQL���,�÷���ֻ��������ͬģ��
                preparedStatement.addBatch();
                //����ǲ�ͬģ��,��ʹ��preparedStatement.addBatch(sql)
                a++;
                if(a%20==0){//ÿ����20����������һ��
                    int[] ints=preparedStatement.executeBatch();
                    System.out.println("ִ��������ɹ�!");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.freed02(connection,preparedStatement,null);
        }
    }

    /**
     * ����-->�����߼�������Ԫִ�е�һϵ�в���
     *
     * ת�˹���:
     * 1.���Ŀ���˺ŵ���Ч��
     * 2.���Դ������Ƿ��㹻
     * 3.Ŀ���˺Ž������
     * 4.Դ�˺Ž��Ҫ����
     * Դ�˺�(����),Ŀ���˺�(����),���
     */
    public void affair(String source,String target,float money) throws SQLException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=DBUtil.getConnection();
            connection.setAutoCommit(false);//��������Ҫ�Զ��ύ
            String sql="update table02 set balance=? where accountid=?";
            //��ѯĿ�����
            float balance01=getBalance(target);
            preparedStatement=connection.prepareStatement(sql);
            //Ŀ���˺ű��޸����
            preparedStatement.setFloat(1,balance01+money);
            preparedStatement.setString(2,target);
            preparedStatement.executeUpdate();
            //Դ�˺ű��޸����
            float balance02=getBalance(source);
            preparedStatement.setFloat(1,balance02-money);
            preparedStatement.setString(2,source);
            preparedStatement.executeUpdate();
            //�ύ����
            connection.commit();
            System.out.println("�ɹ�!");
        } catch (Exception e) {
            e.printStackTrace();
            //�����쳣�ͻع�����
            connection.rollback();
            System.out.println("ʧ��!");
            throw new RuntimeException(e);
        }finally{
            DBUtil.freed02(connection,preparedStatement,null);
        }
    }
    //�����˺�ID��ȡ���
    public float getBalance(String accountId){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        float balance=0;
        try{
            connection=DBUtil.getConnection();
            String sql="select balance from table02 where accountid=?";
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,accountId);
            resultSet=preparedStatement.executeQuery();
            resultSet.next();
            balance=resultSet.getFloat(1);//������ResultSet����ĵ�ǰ���е�һ�е�ֵ,���ظ�balance
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.freed02(connection,preparedStatement,resultSet);
        }
        return balance;
    }
}

















































