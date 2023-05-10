package hut.tyt.test;

import hut.tyt.mapper.EmployeeMapper;
import hut.tyt.pojo.Employee;
import hut.tyt.pojo.EmployeeExample;
import hut.tyt.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ????? ysrazxy@foxmail.com
 * @version 1.0 JDK 13.0.1
 * @BelongsProject: EmpControl
 * @BelongsPackage: hut.tyt.test
 * @CreateTime: 2022-07-31  01:11
 * @Description: TODO
 */
public class Test1 {
    @Test
    public void test1(){

//        System.out.println("A\\".matches("\\u0041\\\\"));
        String[] s = {
                "kongyeeku@163.com",
                "kongyeeku@gmail.com",
                "ligang@crazyit.org",
                "wawa@abc.xx"
        };
        Pattern mailPattern = Pattern.compile("\\w{3,20}@\\w+\\.(com|org|cn|net|gov)");

        Arrays.stream(s).forEach(o->{
            Matcher matcher = mailPattern.matcher(o);
            System.out.println(o+"   "+matcher.matches());
        });

    }
    @Test
    public void test2(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        /*for (Employee employee : mapper.selectByExample(null)) {
            System.out.println(employee);
        }*/
        System.out.println(mapper.selectCountColumns());
    }

    @Test
    public void test3() {

        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

        for (String s : mapper.selectCountName()) {
            System.out.println(s);
        }
    }

    @Test
    public void test4() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        EmployeeExample employeeExample = new EmployeeExample();
        EmployeeExample.Criteria criteria = employeeExample.createCriteria();
        criteria.andNameEqualTo("???");
        List<Employee> employees = mapper.selectByExample(employeeExample);
        System.out.println(employees);
        employees.stream().forEach(System.out::println);
    }
}
