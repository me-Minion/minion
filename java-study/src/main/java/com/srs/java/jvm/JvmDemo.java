package com.srs.java.jvm;

/**
 * @author shaorensheng
 * @date 2022/2/9
 */
public class JvmDemo {

    private static int _1M = 1024 * 1024;

    private static byte[] a = new byte[8 * _1M];
    private static byte[] b = new byte[8 * _1M];

    /**
     * -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:+UseSerialGC
     * 验证eden大小不足，触发Minor GC
     * Survivor区不足时，直接进入老年代
     */
    public static void SerialDemo() {
        byte[] int1 = new byte[2 * _1M];
        byte[] int2 = new byte[2 * _1M];
        byte[] int3 = new byte[2 * _1M];
        byte[] int4 = new byte[4 * _1M];
    }

    /**
     * -Xms20m -Xmx20m -Xmn10m -XX:+PrintGCDetails -XX:+UseParallelGC
     * 验证eden大小不足，触发Minor GC
     * Survivor区不足时，直接进入老年代
     */
    public static void ParallelDemo() {
        //byte[] int1 = new byte[2 * _1M];
        //byte[] int2 = new byte[2 * _1M];
        //byte[] int3 = new byte[2 * _1M];
        //byte[] int4 = new byte[4 * _1M];
    }

    public static void main(String[] args) {
        //SerialDemo();
        ParallelDemo();
    }

}
