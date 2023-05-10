package hut.tyt.swingtest;

import hut.tyt.mapper.EmployeeMapper;
import hut.tyt.pojo.Employee;
import hut.tyt.pojo.EmployeeExample;
import hut.tyt.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Field;
import java.util.List;

/**
 * 使用TableModel创建表
 * 该类的成员属性值得推敲，可以传入sqlSession.getMapper(EmployeeMapper.class)获取到的mapper
 * 该类不具通用性，对于每一张数据表要想在JTable中显示要有一个对应的TableModel
 * 用TableModel实现Swing界面和数据库的交互主要用到的是jdbc
 * 此处由于提早搭建好了MyBatis，故没有放弃MyBatis。如使用jdbc则此类可以实现通用性。
 * @author 小飞侠 ysrazxy@foxmail.com
 * @version 1.0 JDK 13.0.1
 * @BelongsProject: EmpControl
 * @BelongsPackage: hut.tyt.swingtest
 * @CreateTime: 2022-08-08  11:03
 * @Description: TODO
 */
public class ListAndTableModel extends AbstractTableModel {

    SqlSession sqlSession;

    public ListAndTableModel() {
        this.sqlSession = SqlSessionUtils.getSqlSession();
    }

    /**
     * 获取表格的列名
     * @param column
     * @return String
     * @date: 2022/8/8 22:04
     */
    @Override
    public String getColumnName(int column) {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        String[] strings = mapper.selectCountName();
        return strings[column];
    }

    /**
     *获取表格的行数
     * 对应数据库中多少条记录
     * @return int
     * @date: 2022/8/8 22:04
     */
    @Override
    public int getRowCount() {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        int i = Math.toIntExact(mapper.countByExample(null));
        return i;
    }

    /**
     获取列数
     此sql语句用到 -information_schema.COLUMNS- 表
     * @return int
     * @date: 2022/8/8 22:05
     */
    @Override
    public int getColumnCount() {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        return mapper.selectCountColumns();
    }

    /**
     * 获取表格中某行某列的内容，表格内容一般是String类型
     * 此处我理解的是，表格最开始的渲染也会调用此方法，且自动会做行和列的递增
     * @param rowIndex
     * @param columnIndex
     * @return Object
     * @date: 2022/8/8 22:08
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        获取整个数据表中数据到List集合中
        List<Employee> employees = mapper.selectByExample(null);
//        讲每一条数据分解
        String[] split = employees.get(rowIndex).toString().split(",");
//        讲分解的数据返回填入每一个单元格中
        return split[columnIndex];
    }

    /**
     * 返回true表示单元格可编辑
     * @param rowIndex
     * @param columnIndex
     * @return boolean
     * @date: 2022/8/8 22:19
     */
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    /**
     * 此方法会在单元格被改变的时候自动调用，类似于一个监听器
     * @param aValue
     * @param rowIndex
     * @param columnIndex

     * @date: 2022/8/8 22:19
     */
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
//        新建Employee实例
        Employee employee = new Employee();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
//        设置该employee对象的id属性为鼠标点击的单元格的行的第一列的值
        employee.setId(Integer.valueOf((String) getValueAt(rowIndex, 0)));
//        反射获取employee对象的所有属性
        Field[] declaredField = employee.getClass().getDeclaredFields();
        try {
//            由于1、3、4列的类型是String,而其他列是int，所以要分开讨论
//            如果修改的列不是1、3、4
            if (columnIndex != 1 && columnIndex != 3 && columnIndex != 4 ) {
//                设置该employee对象的对应属性的值为修改之后的int类型的值
//                注意此处是直接修改的employee实例的对应属性的值，没有用到封装，故该类的成员属性必须是public
                declaredField[columnIndex].set(employee, Integer.valueOf(aValue.toString()));
            } else {
//                设置该employee对象的对应属性的值为修改之后的String类型的值
                declaredField[columnIndex].set(employee, aValue.toString());
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
//        根据主键id修改数据表中对应的数据
        mapper.updateByPrimaryKeySelective(employee);
//        触发单元格的修改事件
        fireTableCellUpdated(rowIndex, columnIndex);
    }
}
