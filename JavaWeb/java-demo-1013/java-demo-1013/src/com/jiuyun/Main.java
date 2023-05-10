package com.jiuyun;

import com.jiuyun.bean.Animal;
import com.jiuyun.bean.Cat;
import com.jiuyun.bean.Dog;
import com.jiuyun.bean.Student;
import com.jiuyun.util.ABSUtil;

import java.util.Scanner;

public class Main {

    static {
        System.out.println("init!");
    }

    public static void main(String[] args) {
	    demo7();
    }

    private static void demo7() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个分数：");
        int num = scanner.nextInt();
        System.out.println(++num);
    }

    private static void demo6() {
        System.out.println(5 / 0);
        try {
            Class.forName("");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //多态
    private static void demo5() {
        Animal animal = new Cat("小花");
        animal.shout();
        animal = new Dog("旺财");
        animal.shout();
    }

    private static void demo4() {
        Student student1 = new Student(1, "jack", "男");
        Student student2 = new Student(1, "jack", "男");
        System.out.println(student1.equals(student2));
    }

    private static void demo3() {
        Student stu1 = new Student();
        System.out.println(stu1.count);
        Student stu2 = new Student();
        System.out.println(stu2.count);
        Student stu3 = new Student();
        System.out.println(stu3.count);
        Student stu4 = new Student();
        System.out.println("stu4:" + stu4.count);
        System.out.println("stu1:" + stu1.count);
    }

    private static void demo2() {
        Student student = new Student();
        student.setStuId(1);
    }

    private static void demo1() {
        ABSUtil absUtil = new ABSUtil();
        System.out.println(ABSUtil.abs(10));
        System.out.println(absUtil.abs(-10));
        System.out.println(absUtil.abs(-10.0));
        System.out.println(absUtil.abs(0.5f));
    }
}
