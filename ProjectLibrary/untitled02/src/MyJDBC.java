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
    //连接测试
    public static Connection myConnection(){
        Connection connection = null;
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database01", "root", "88888888");
            if (connection != null) {
                System.out.println("连接成功");
            } else {
                System.out.println("连接失败");
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
        Connection connection = null;//连接数据库对象
        Statement statement = null;//执行SQL语句对象
        try {
            String str1 = "insert into table01 values ('top01','小胡',18,'2022-8-2')";//插入sql语句
            connection = MyJDBC.myConnection();//获取连接对象
            statement = connection.createStatement();//执行数据库操作的接口
            int i1 = statement.executeUpdate(str1);//影响的行数
            if (i1 > 0) {
                System.out.println("成功!");
            } else {
                System.out.println("失败!");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try {
                //释放资源
                statement.close();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //查询
    public void test02() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet=null;//查询结果集
        try {
            String str2="select * from table01";//查询sql语句
            connection=MyJDBC.myConnection();
            statement=connection.createStatement();
            resultSet=statement.executeQuery(str2);
            //指针下移,如果返回true,表示当前指向的是有值的,并且取出值
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
            try {//释放资源
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
 * 登录类
 * 实现登录功能
 */
class Deer{
    public static boolean chaeck(String LogId,String LogPass){
        Connection connection = null;
        PreparedStatement preparedStatement=null;//安全的执行预编译的SQL语句,相比之下Statement会被SQL注入
        ResultSet resultSet=null;
        boolean flag=false;//判断是否登录成功,默认表示登录不成功
        try{
            String sql="select count(uid) from table01 where uid=? and uage=?";
            DBUtil.getConnection();
            //设置SQL查询语句中占位符的值
            preparedStatement=connection.prepareStatement(sql);
            preparedStatement.setString(1,LogId);
            preparedStatement.setString(2,LogPass);
            resultSet=preparedStatement.executeQuery();
            resultSet.next();//将resultSet光标从其当前位置向前移动一行
            int i=resultSet.getInt(1);
            if(i>0){
                System.out.println("成功!");
                flag=true;
            }else{
                System.out.println("失败");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.freed02(connection,preparedStatement,resultSet);
        }
        return flag;
    }
    //添加用户
    public static void addUser(){
        String sql="insert into table01 values (?,?,?,?)";
        Object[] values={"top05","小杨",15,"2021-5-30"};
        Common.operModify(sql,values);//调用增删改功能类
    }
}

/**
 * 工具类
 * 由于连接数据库和释放资源
 */
class DBUtil{
    public static final String URL="jdbc:mysql://localhost:3306/database01";
    public static final String DRIVER_CLASS="com.mysql.cj.jdbc.Driver";
    //连接类
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
    //释放类
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
 * 增删改功能类
 * 参数列表-->(sql语句,注入参数...)
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
                //循环设置参数值
                for(Object tmpe:paramValues){
                    preparedStatement.setObject(i++,tmpe);//给定对象设置指定参数的值
                }
            }
            int x=preparedStatement.executeUpdate();
            if(x>0){
                System.out.println("更新成功!");
                b=true;
            }else{
                System.out.println("更新失败!");
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
 * 值对象
 * 封装表中属性
 * 将每条记录变成一个个类,里面的属性就是类成员,再通过list容器将对象们传给客户端
 */
class UserInfo{
    //将表中字段封装起来
    private String uid;
    private String uname;
    private int uage;
    private String ubirthday;

    public UserInfo(){}//空无参构造方法
    public UserInfo(String uid,String uname,int uage,String ubirthday){//利用构造方法传参数值
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

    //以ArrayList方式返回查询表记录
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
     * 批处理
     * 一次性执行多条sql语句,提高效率
     */
    public static void executes(){
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=DBUtil.getConnection();
            String sql="insert into table01 values(?,?,?,?)";
            preparedStatement=connection.prepareStatement(sql);
            int a=1;
            for(int b=10;b<=110;b++){//循环100次
                preparedStatement.setString(1,"top06"+b);
                preparedStatement.setString(2,"小于"+b);
                preparedStatement.setInt(3,b);
                preparedStatement.setString(4,"2020-8-3");
                //执行批处理的方法,缓存当前SQL语句,该方法只能用于相同模板
                preparedStatement.addBatch();
                //如果是不同模板,就使用preparedStatement.addBatch(sql)
                a++;
                if(a%20==0){//每缓存20条就批处理一次
                    int[] ints=preparedStatement.executeBatch();
                    System.out.println("执行批处理成功!");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.freed02(connection,preparedStatement,null);
        }
    }

    /**
     * 事务-->单个逻辑工作单元执行的一系列操作
     *
     * 转账功能:
     * 1.检查目标账号的有效性
     * 2.检查源账余额是否足够
     * 3.目标账号金额增加
     * 4.源账号金额要减少
     * 源账号(主语),目标账号(宾语),余额
     */
    public void affair(String source,String target,float money) throws SQLException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        try{
            connection=DBUtil.getConnection();
            connection.setAutoCommit(false);//设置事务不要自动提交
            String sql="update table02 set balance=? where accountid=?";
            //查询目标余额
            float balance01=getBalance(target);
            preparedStatement=connection.prepareStatement(sql);
            //目标账号被修改余额
            preparedStatement.setFloat(1,balance01+money);
            preparedStatement.setString(2,target);
            preparedStatement.executeUpdate();
            //源账号被修改余额
            float balance02=getBalance(source);
            preparedStatement.setFloat(1,balance02-money);
            preparedStatement.setString(2,source);
            preparedStatement.executeUpdate();
            //提交事务
            connection.commit();
            System.out.println("成功!");
        } catch (Exception e) {
            e.printStackTrace();
            //发生异常就回滚事务
            connection.rollback();
            System.out.println("失败!");
            throw new RuntimeException(e);
        }finally{
            DBUtil.freed02(connection,preparedStatement,null);
        }
    }
    //根据账号ID获取余额
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
            balance=resultSet.getFloat(1);//检索此ResultSet对象的当前行中第一列的值,返回给balance
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally{
            DBUtil.freed02(connection,preparedStatement,resultSet);
        }
        return balance;
    }
}

















































