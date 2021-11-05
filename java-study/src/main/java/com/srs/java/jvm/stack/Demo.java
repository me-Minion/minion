package com.srs.java.jvm.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author shaorensheng
 * @date 2021/11/3
 */
public class Demo {

    volatile long ll = 2000000000000000000L;


    public static void add() {

        int a = 1300;
        int b = 12;
        int c = (a + b) * 10000 ;
        int d = 100000;
    }


    public int math() {
        long l = 1000000000000000000L;
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public void add(int a ){
        this.math();
    }

//    public static void main(String[] args) {
//        Demo demo = new Demo();
//        int math = demo.math();
//        long l1 = Long.highestOneBit(1000000000000000000L);
//        long l2 = Long.lowestOneBit(1000000000000000000L);
//        String s = Long.toHexString(1000000000000000000L);
//        System.out.println(l1);
//        System.out.println(l2);
//        System.out.println(s);
//        long ll = 1000000000000000000L;
//        long l = ll >> 32;
//        long l3 = ll & 0xffff;
//        System.out.println(Long.toHexString(l));
//        System.out.println(Long.toHexString(l3));
//    }

}
