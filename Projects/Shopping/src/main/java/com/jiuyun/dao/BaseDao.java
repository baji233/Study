package com.jiuyun.dao;

import com.jiuyun.util.DBUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 需要方法时自行添加
 */
public class BaseDao {
    /**
     * 增加记录
     * @param object
     * @return
     * @throws Exception
     */
    public boolean save(Object object) throws Exception {
        boolean flag = false;
        String sql = createSaveSqlByObject(object);
        Connection conn = null;
        Statement st = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.createStatement();
            flag = st.executeUpdate(sql) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, st, null);
        }
        return flag;
    }

    /**
     * 根据主键id删除
     * @param object
     * @return
     * @throws Exception
     */
    public boolean delete(Object object) throws Exception {
        boolean flag = false;
        String sql = createDeleteSqlByObject(object);
        Connection conn = null;
        Statement st = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.createStatement();
            flag = st.executeUpdate(sql) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, st, null);
        }
        return flag;
    }

    /**
     * 根据主键id修改
     * @param object
     * @return
     * @throws Exception
     */
    public boolean update(Object object) throws Exception {
        boolean flag = false;
        String sql = createUpdateSqlByObject(object);
        Connection conn = null;
        Statement st = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.createStatement();
            flag = st.executeUpdate(sql) > 0;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, st, null);
        }
        return flag;
    }

    /**
     * 根据主键id查询
     * @param object
     * @return
     * @throws Exception
     */
    public Object selectById(Object object) throws Exception {
        Object result = null;
        String sql = createSelectByIdSqlByObject(object);
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                result = getResultByObject(rs, object);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, st, null);
        }
        return result;
    }

    /**
     * 查询表中全部记录
   * @param object
     * @return
     */
    public List selectAll(Object object) {
        List list = new ArrayList();
        String sql = createSelectAllSqlByObject(object);
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            conn = DBUtil.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery(sql);
            list.add(getResultByObject(rs, object));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBUtil.close(conn, st, null);
        }
        return list;
    }



    /**
     * 根据对象创建Update语句
     * @param object
     * @return
     */
    private static String createUpdateSqlByObject(Object object) throws Exception {
        //update t_student set stu_name=,sex=,age= where stu_id=
        String sql = "update " + getTableNameByObject(object) + " set ";
        sql += (getUpdateColumn(object) + " where " + getPkByObject(object) + "=" + getPkValue(object));
        return sql;
    }

    /**
     * 根据对象创建Delete语句
     * @param object
     * @return
     */
    private static String createDeleteSqlByObject(Object object) throws Exception {
        String sql = "delete from " + getTableNameByObject(object) + " where " + getPkByObject(object) + "=" + getPkValue(object);
        return sql;
    }

    /**
     * 根据对象创建SelectById语句
     * @param object
     * @return
     */
    private static String createSelectByIdSqlByObject(Object object) throws Exception {
        //select * from t_student where stu_id=21
        String sql = "select * from " + getTableNameByObject(object) + " where ";
        sql += getPkByObject(object) + "=" + getPkValue(object);
        return sql;
    }


    /**
     * 根据对象创建SelectAll语句
     * @param object
     * @return
     */
    private static String createSelectAllSqlByObject(Object object) {
        String sql = "select * from " + getTableNameByObject(object);
        return sql;
    }

    /**
     * 根据传入的对象创建保存的Sql语句
     * @param object
     * @return
     * @throws Exception
     */
    private static String createSaveSqlByObject(Object object) throws Exception {
        String sql = "insert into " + getTableNameByObject(object) + " ";
        sql += getColumnNamesByObject(object) + " values ";
        sql += getValuesByObject(object);
        return sql;
    }

    /**
     * 获取值的Sql语句片段
     * @param object
     * @return
     * @throws Exception
     */
    private static String getValuesByObject(Object object) throws Exception {
        String values = "(";
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String methodName = getMethodNameByFiled("get", field.getName());
            Method method = clazz.getMethod(methodName, null);
            switch (field.getType().getSimpleName()) {
                case "Integer":
                case "Float":
                case "Double":
                    values += (method.invoke(object, null) + ",");
                    break;
                default:
                    values += ("'" + method.invoke(object, null) + "',");
            }
        }
        values = values.substring(0, values.length() - 1);
        return values + ")";
    }

    /**
     * 根据对象获取修改字符串
     * @param object
     * @return
     */
    private static String getUpdateColumn(Object object) throws Exception {
        String columnValues = "";
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (int i = 1; i < fields.length; i++) {
            Method method = clazz.getMethod(getMethodNameByFiled("get",fields[i].getName()));
            Object value = method.invoke(object);
            switch (fields[i].getType().getSimpleName()) {
                case "Integer":
                case "Float":
                case "Double":
                    columnValues += (getColumnNameByFieldName(fields[i].getName()) + "=" + value + ",");
                    break;
                default:
                    columnValues += (getColumnNameByFieldName(fields[i].getName()) + "='" + value + "',");
            }
        }
        columnValues = columnValues.substring(0, columnValues.length() - 1);
        return columnValues;
    }

    /**
     * 根据字段名获取方法名
     * @param type
     * @param fieldName
     * @return
     */
    private static String getMethodNameByFiled(String type, String fieldName) {
        String methodName = type;
        methodName += (fieldName.substring(0,1).toUpperCase() + fieldName.substring(1));
        return methodName;
    }

    /**
     * 根据对象获取列名
     * @param object
     * @return
     */
    private static String getColumnNamesByObject(Object object) {
        String columns = "(";
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            columns += getColumnNameByFieldName(field.getName()) + ",";
        }
        columns = columns.substring(0, columns.length() - 1);
        return columns + ")";
    }

    /**
     * 根据字段名获取对应列名
     * @param fieldName
     * @return
     */
    private static String getColumnNameByFieldName(String fieldName) {
        String columnName = "";
        for (int i = 0; i < fieldName.length(); i++) {
            char ch = fieldName.charAt(i);
            if(Character.isUpperCase(ch)) {
                columnName += ("_" + ch);
            } else {
                columnName += ch;
            }
        }
        return columnName.toLowerCase();
    }

    /**
     * 根据对象获取表名
     * @param object
     * @return
     */
    private static String getTableNameByObject(Object object) {
        String tableName = "t_";
        tableName += object.getClass().getSimpleName().toLowerCase();
        return tableName;
    }

    /**
     * 根据对象获取主键列名
     * @param object
     * @return
     */
    private static String getPkByObject(Object object) {
        String pkName = "";
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        if(fields.length > 0) {
            pkName = getColumnNameByFieldName(fields[0].getName());
        }
        return pkName;
    }

    /**
     * 获取主键列的值
     * @param object
     * @return
     */
    private static Object getPkValue(Object object) throws Exception {
        Object value = null;
        Class clazz = object.getClass();
        Field[] fields = clazz.getDeclaredFields();
        if(fields.length > 0) {
            Method method = clazz.getMethod(getMethodNameByFiled("get", fields[0].getName()));
            value = method.invoke(object, null);
        }
        return value;
    }

    /**
     * 根据结果集以及对象，创建结果
     * @param rs
     * @param object
     * @return
     */
    private Object getResultByObject(ResultSet rs, Object object) throws Exception {
        Class clazz = object.getClass();
        Object result = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            String methodName = getMethodNameByFiled("set", field.getName());
            Method method = clazz.getMethod(methodName, field.getType());
            String columnName = getColumnNameByFieldName(field.getName());
            method.invoke(result, rs.getObject(columnName));
        }
        return result;
    }

}
