package com.jiuyun;

import java.util.Scanner;

/**
 * @author cj
 * @create 2022年10月13日 15:36:45
 */
public class Zi {
    public static void main(String[] args) {
        String result = "";
        String[] danwei = new String[]{"万","仟","佰","拾","元"};
        String[] numbers = new String[]{"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个五位数：");
        String number = scanner.nextLine();
        //将字符串转换为字符数组
        char[] chNumber = number.toCharArray();
        for (int i = 0; i < chNumber.length; i++) {
            //将数组中的字符串转换为数字
            int n = Integer.parseInt(chNumber[i] + "");
            result += (numbers[n] + danwei[i]);
        }
        System.out.println(result);
    }
}
