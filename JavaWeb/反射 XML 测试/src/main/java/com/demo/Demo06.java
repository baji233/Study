package com.demo;

import java.io.Serializable;
import java.lang.reflect.*;


public class Demo06 {
    /**
     * 反射机制:
     * java.reflect.*;
     * @param args
     */
    int i1=18;
    String s1="tjw";
    void show(String s2,int i2){
        System.out.println(s2+" "+i2);
    }

    //获取Class对象的五种方式
    public static void method01() throws ClassNotFoundException {  //使用try捕获
        //No.1: Class c=class.forName("类名");
        Class c1=Class.forName("Demo06");

        //No.2: Object o=对象名.getClass();
        Demo06 d6=new Demo06();
        Class c2=d6.getClass();

        //No.3: Class c=数据类型.class
        Class c3=String.class;

        //No4: Class c=基本数据类型包装类.TYPE
        Class c4=Integer.TYPE;

        //No5: 使用类加载器ClassLoader
        ClassLoader cl=Demo06.class.getClassLoader();
        Class c5=cl.loadClass("java.lang.String");
    }

    //获取class信息
    public void method02() throws NoSuchMethodException {
        Class c=Student.class;
        Package p=c.getPackage();
        String pName=p.getName();System.out.println(pName);//包名
        String className=c.getName();System.out.println(className);//类名
        Class superclass=c.getSuperclass();System.out.println("父类: "+superclass.getName());//父类名
        Class[] ifs=c.getInterfaces();//接口名
        System.out.println("实现的接口如下");
        for(Class x:ifs){
            System.out.println(x.getName()+" ");
        }
        Constructor[] constructors=c.getDeclaredConstructors();//获取构造方法信息
        for(Constructor y:constructors){
            int modifiers=y.getModifiers();
            String contructorModifier=Modifier.toString(modifiers);System.out.println("修饰符: "+contructorModifier+" ");//打印修饰符
            Class[] parameterTypes=y.getParameterTypes();//参数
            for(Class z:parameterTypes){
                System.out.println("参数: "+z+" ");
            }
            System.out.println(y.getName()+" ");//打印公共构造方法名
        }
        Constructor constructor=c.getConstructor();//获取公共构造方法对象
        Class[] pointConstructors={String.class,int.class,char.class};//获取指定构造方法
        try {//利用默认无参构造方法创建对象
            Object oc=c.newInstance();//Student的实例对象
            Constructor myConstructors=c.getConstructor(pointConstructors);//指定构造方法
            Object[] parameterValues={"小明",18,'男'};//待传入参数列表
            Object omc=myConstructors.newInstance(parameterValues);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
    //Field--->成员
    public void method03(){
        {
            try {
                Class c1 = Class.forName("src/Demo06.java");
                Field[] allField=c1.getDeclaredFields();//获取全部字段
                for(Field f:allField){
                    int fieldModifiers=f.getModifiers();//获取修饰符
                    String strModifiers=Modifier.toString(fieldModifiers);System.out.println(strModifiers+" ");
                    Class fieldTyple=f.getType();System.out.println(fieldTyple+" ");//获取字段数据类型
                    String fieldName=f.getName();System.out.println(fieldName+" ");//获取字段名
                }
                //获取指定字段,并设置值
                Field myField=c1.getField("name");//获取指定name字段
                Object oc1=c1.newInstance();//获取类实例对象
                myField.set(oc1,"小玉");//小玉赋值给字段name
                Object xiaoYu=myField.get(oc1);System.out.println(xiaoYu);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (NoSuchFieldException e) {
                throw new RuntimeException(e);
            }
        }
    }
    //Method-->方法
    public void method04() throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Demo06 demo06=new Demo06();
        Class c2=demo06.getClass();
        Method[] allMethods=c2.getDeclaredMethods();//获取所有方法
        for(Method m:allMethods){
            String mName=m.getName();System.out.println(mName+" ");//获取方法名
            Class[] methodParameter=m.getParameterTypes();//获得方法的参数
            for(Class mArr:methodParameter){
                System.out.println(mArr+" ");
            }
        }
        Method testMethod=c2.getMethod("Test",null);//获取指定方法Test,参数类型为空
        Class[] methodParameter={String.class,int.class,char.class};//通过参数类型指定构造方法
        Constructor c2c=c2.getConstructor(methodParameter);//获取指定构造方法对象
        Object object=c2c.newInstance("老太婆",88,'女');//实例化该对象并传参
        testMethod.invoke(object,null);//通过上面的对象调用方法,不会返回东西
    }
    public static void main(String[] args) {
        Demo06 d6=new Demo06();
        try {
            d6.method02();
            d6.method03();
            d6.method04();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}






























