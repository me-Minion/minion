package com.srs.java.javabase.keyword;

/**
 * @author shaorensheng
 * @date 2022/1/13
 */
public class VolatileDemo2 {

    private static int int1 = 1;
    private volatile static int int2 = 2;
    private static int int3 = 3;
    private static int int4 = 4;
    private static int int5 = 5;

    public static void main(String[] args) {
        for (int i = 0; i < 10000; i++) {
            increase(i);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void increase(int i) {
        int1 = i + 1;
        int2 = i + 2;
        int3 = i + 3;
        int4 = i + 4;
        int5 = i + 5;
    }

}
