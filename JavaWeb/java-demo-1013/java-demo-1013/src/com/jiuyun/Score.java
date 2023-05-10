package com.jiuyun;

import java.util.Scanner;

/**
 * @author cj
 * @create 2022年10月13日 15:50:59
 */
public class Score {
    public static void main(String[] args) {
        double max = 0;
        double min = 0;
        Scanner scanner = new Scanner(System.in);
        double[] scores = new double[7];
        for (int i = 0; i < scores.length; i++) {
            System.out.println("请输入第" + (i + 1) + "个分数：");
            scores[i] = scanner.nextDouble();
            if(max < scores[i]) {
                max = scores[i];
            }
            if(i ==0) {
                min = scores[i];
            }
            if(min > scores[i]) {
                min = scores[i];
            }
        }
        System.out.println("所有评委的评分如下：" + getScoresString(scores, max, min));
        double[] newScores = new double[5];
        int index = 0;
        for (int i = 0; i < scores.length; i++) {
            if(scores[i] != max || scores[i] != min) {
                newScores[index++] = scores[i];
                if(index == newScores.length) {
                    break;
                }
            }
        }
        double result = getResult(newScores);
        System.out.println("最终结果为：" + result);
    }

    private static double getResult(double[] newScores) {
        double sum = 0;
        for (int i = 0; i < newScores.length; i++) {
            sum += newScores[i];
        }
        return (sum * 2 / 5 * 3);
    }

    private static String getScoresString(double[] scores, double max, double min) {
        String str = "";
        for (int i = 0; i < scores.length; i++) {
            if(scores[i] == max || scores[i] == min) {
                str += ("(" + scores[i] + ")");
            } else {
                str += scores[i];
            }
            if(i < scores.length - 1) {
                str += ",";
            }
        }
        return str;
    }
}
