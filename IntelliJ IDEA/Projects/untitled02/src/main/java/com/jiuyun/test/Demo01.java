package com.jiuyun.test;

import java.io.File;
import java.util.*;

public class Demo01 {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        String email = scanner.next();
//        boolean b=checkEmail(email);
//        System.out.println(b);

//        myHashMap();

//        test01();

        test02();
    }

    public static boolean checkEmail(String email) {
        int length = email.length();
        email.charAt(0);
        //@不能出现在首尾,.不能出现在结尾
        if ("@".equals(email.charAt(0)) || "@".equals(email.charAt(length - 1)) || ".".equals(email.charAt(length - 1))) {
            return false;
        }
        //..不能相邻
        if (email.indexOf("..") > 0) {
            return false;
        }
        //至少有一个.
        if (email.indexOf(".") == -1) {
            return false;
        }
        //.@不能相邻
        if (email.indexOf(".@")>0){
            return false;
        }
        else {
            return true;
        }
    }

    public static void myHashMap(){
        Map map = new HashMap();
        map.put(1,"aaa");
        map.put(2,"bbb");
        //取键
        Set set=map.keySet();
        for(Object o:set){
            System.out.println(o);
        }
        //取值
        Collection collection = map.values();
        for (Object o: collection) {
            System.out.println(o);
        }
        //取键值对
        Set set1=map.entrySet();
        for (Object o:set1){
            System.out.println(o);

        }
    }


    public static void test01() {
        List list = new ArrayList<>();
        list.add("同学");
        list.add("家人");
        list.add("朋友");

        Map map = new HashMap();
        map.put("同学1", "小鸟，123");
        map.put("同学2", "小狗，234");
        map.put("同学3", "小猪，345");

        map.put("家人1", "猪，456");
        map.put("家人2", "狗，678");
        map.put("家人3", "羊，789");

        map.put("朋友1", "aaa，890");
        map.put("朋友2", "bbb，012");
        map.put("朋友3", "ccc，000");

        for (Object o1 : list) {
            System.out.println(o1+"\n");
            Set key = map.entrySet();
            for (Object o2 : key) {
                if (o2.toString().startsWith(o1.toString())) {
                    System.out.println(o2);
                }
            }
        }
    }
    public static void fileTest(){
        File file=new File("d:\\abc.txt");
        if(file.exists()){
            System.out.println(file.getName());
            System.out.println(file.canExecute());

        }
    }

    public static void test02(){
        String URL="/java_web01.war/Student/update";
        Integer end=URL.length();
        Integer begin=URL.lastIndexOf("/");
        String str= String.valueOf(URL.subSequence(begin+1,end));
        System.out.println(str);
    }
}



































