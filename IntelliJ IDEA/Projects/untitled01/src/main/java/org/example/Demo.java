package org.example;

import java.io.*;
import java.util.HashSet;
import java.util.Random;

public class Demo {
    public static void main(String[] args){
        demo1();
    }

    private static void demo1(){
        HashSet hashSet=new HashSet();
        int x=0;
        while(hashSet.size() != 7){
            Random random=new Random();
            x=random.nextInt((34)+1);
            hashSet.add(x);
        }
        System.out.println(hashSet);
    }
}
