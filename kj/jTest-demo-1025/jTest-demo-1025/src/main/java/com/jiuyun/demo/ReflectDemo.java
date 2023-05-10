package com.jiuyun.demo;

import com.jiuyun.bean.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * @author cj
 * @create 2022年10月25日 18:33:46
 */
public class ReflectDemo {
    private static final Logger log = LoggerFactory.getLogger(ReflectDemo.class);
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        demo7();
    }

    //获取一个类名，创建其对象，并给它所有属性赋值，最后打印
    private static void demo7() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        log.info("请输入完整类名：");
        Scanner scanner = new Scanner(System.in);
        String className = scanner.nextLine();
        Class clazz = Class.forName(className);
        Object obj = clazz.newInstance();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            Method method = clazz.getMethod(getMethodName("set", field.getName()), field.getType());
            log.info("请输入" + field.getName() + "的值：");
            String str = scanner.nextLine();
            Object param = null;
            switch (field.getType().getSimpleName()) {
                case "Integer":
                    param = Integer.parseInt(str);
                    break;
                case "Double":
                    param = Double.parseDouble(str);
                    break;
                case "Float":
                    param = Float.parseFloat(str);
                    break;
                default:
                    param = str;
            }
            method.invoke(obj, param);
        }
        log.info("对象信息：" + obj);
    }

    private static String getMethodName(String type, String fieldName) {
        String methodName = "";
        methodName += type;
        methodName += (fieldName.substring(0,1).toUpperCase() + fieldName.substring(1));
        return methodName;
    }

    private static void demo6() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class clazz = Student.class;
        Student student = (Student) clazz.newInstance();
        Method method = clazz.getMethod("setStuId", Integer.class);
        log.info("未调用方法前：" + student);
        method.invoke(student, 1);
        log.info("调用方法后：" + student);
    }

    //如何通过Class对象获取该类的实例
    private static void demo5() throws IllegalAccessException, InstantiationException {
        Class clazz = Student.class;
        Student student = (Student) clazz.newInstance();
        System.out.println(student);
    }

    //接收控制台的输入类名，打印其信息，以及其属性和方法信息
    private static void demo4() throws ClassNotFoundException {
        log.info("请输入完整类名：");
        Scanner scanner = new Scanner(System.in);
        String className = scanner.nextLine();
        Class clazz = Class.forName(className);
        log.info("ClassName:" + clazz.getSimpleName());
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            log.info(field.getType().getName() + " " + field.getName());
        }
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            log.info(getMethodInfo(method));
        }
    }

    private static String getMethodInfo(Method method) {
        String methodInfo = "";
        methodInfo += Modifier.toString(method.getModifiers()) + " ";
        methodInfo += method.getReturnType().getSimpleName() + " ";
        methodInfo += method.getName();
        methodInfo += "(";
        Class[] parameterTypes = method.getParameterTypes();
        for (Class parameterType : parameterTypes) {
            methodInfo += parameterType.getSimpleName() + " ,";
        }
        if(parameterTypes.length > 0) {
            methodInfo = methodInfo.substring(0, methodInfo.length() - 1);
        }
        return methodInfo + ")";
    }

    //获取方法对象
    private static void demo3() {
        Class clazz = Student.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            log.info(method.getName());
        }
    }

    //获取属性信息
    private static void demo2() {
        Class clazz = Student.class;
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            log.info(field.getName());
        }
    }

    //获取类的类信息
    private static void demo1() throws ClassNotFoundException {
        Class clazz1 = Student.class;
        Class clazz2 = new Student().getClass();
        Class clazz3 = Class.forName("com.jiuyun.bean.Student");
        log.info("类的全名：" + clazz3.getName());
        log.info("类的简称：" + clazz3.getSimpleName());

    }
}
