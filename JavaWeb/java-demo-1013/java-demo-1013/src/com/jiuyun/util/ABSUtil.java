package com.jiuyun.util;

/**
 * @author cj
 * @create 2022年10月13日 10:44:24
 */
public class ABSUtil {
    public static int abs(int a) {
        return ((a < 0) ? -a : a);
    }
    public int abs(int a, int b) {
        return ((a < 0) ? -a : a);
    }

    public float abs(float a) {
        return ((a < 0) ? -a : a);
    }

    public double abs(double a) {
        return ((a < 0) ? -a : a);
    }

}
