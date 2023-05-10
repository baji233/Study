package com.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReflectDemo {
    public static void main(String[] args) {
        try {

            demo4();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static final Logger log = LoggerFactory.getLogger(ReflectDemo.class);


    /**
     * 获取类的类信息
     */
    public static void demo1() throws ClassNotFoundException {
        // 1
        Class class1 = Student.class;
        // 2
        Class class2 = new Student().getClass();
        // 3(常用)
        Class class3 = Class.forName("com.demo.Student");

        log.info("类的简称:" + class3.getName());

        log.info("类的全称:" + class3.getSimpleName());
    }

    /**
     * 获取属性信息
     *
     * @throws ClassNotFoundException
     */
    public static void demo2() {
        Class class1 = Student.class;
        Field[] fields = class1.getDeclaredFields(); //Declared 声明
        for (Field field : fields) {
            log.info(field.getName());
        }
    }

    /**
     * 获取方法信息
     *
     * @throws ClassNotFoundException
     */
    public static void demo3() {
        Class class2 = new Student().getClass();
        Method[] methods = class2.getDeclaredMethods();
        for (Method method : methods) {
            log.info(method.getName());
        }
    }

    /**
     * 题目：接收控制台输入的类名，打印信息
     */
    public static void demo4() throws ClassNotFoundException {
        System.out.println("请输入完整类名：");
        Scanner scanner = new Scanner(System.in);
        String className = scanner.nextLine();

        Class class3 = Class.forName(className);
        Field[] fields = class3.getDeclaredFields();
        for (Field field : fields) {
            log.info(field.getType().getName() + " " + field.getName());
        }

        Method[] methods = class3.getDeclaredMethods();
        String methodInfo = "";
        for (Method method : methods) {
            methodInfo += Modifier.toString(method.getModifiers()); //访问控制级
            methodInfo += method.getDefaultValue();
            methodInfo += method.getReturnType().getName();
            methodInfo += method.getName();
            methodInfo += "(";
            Object[] paramType = method.getParameterTypes();
            methodInfo += ")";
            //...
            log.info(methodInfo);
        }
    }

    /**
     * 动态获取类的实例对象
     */
    public static void demo5() throws IllegalAccessException, InstantiationException {
        Class class1 = Student.class;
        Student student = (Student) class1.newInstance();
    }

    /**
     * 动态调用方法
     */
    public static void demo6() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class class1 = Student.class;
        Student student = (Student) class1.newInstance();
        Method method = class1.getMethod("setStuId",Integer.class);// (方法名，参数类型)
        log.info("未调用方法前:"+method);
        method.invoke(student,1);// (调用该方法的对象，参数)
        log.info("调用方法之后:"+method);
    }

    /**
     * 题目：获取一个类名并创建对象，调用方法并为所有属性赋值
     */
    public static void demo7() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        System.out.println("请输入完整类名：");
        Scanner scanner = new Scanner(System.in);
        String className = scanner.nextLine();
        Class class3 = Class.forName(className);
        Method[] methods = class3.getDeclaredMethods();
        List<String> setMList = new ArrayList<>();
        //找到set方法
        for(Method method : methods){
            String mName = method.getName();
            if(mName.startsWith("set")){
                setMList.add(mName);
            }
        }
        //获取set方法对象
        Object object = class3.newInstance();
        for(String mNames : setMList){
            log.info("请为"+mNames+"方法设置参数：");
            Object param= scanner.next();
            Method method1 = class3.getMethod(mNames,Object.class);//TODO:获取set方法参数类型

            Class[] paramType = method1.getParameterTypes();
            for(int i=0;i<=paramType.length;i++){
                Method method3 = class3.getMethod(mNames,paramType[i]);
                method3.invoke(object,param);
            }
        }
    }

    public static void demo8() {

    }



}










