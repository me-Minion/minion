package com.srs.java.jvm.stack;


/**
 * @author shaorensheng
 * @date 2021/11/3
 */
public class Demo {

    long ll = 100000000000000000L;

    public int math() {
        long lo = ll;
        long l = 100000000000000000L;
        int a = 1;
        int b = 2;
        int c = (a + b) * 10;
        return c;
    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        int math = demo.math();
        int x = 0;
    }

}
