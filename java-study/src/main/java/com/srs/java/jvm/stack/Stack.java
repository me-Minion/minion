package com.srs.java.jvm.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shaorensheng
 * @date 2021/11/15
 */
public class Stack {

    public void add() {
        int i = 10;
        int a = i++;
        //System.out.println(a);
        int b = ++i;
        System.out.println(b);
        List list = new ArrayList();
        for (int j = 0; j < 100; j++) {
            list.add(j);
        }
        System.gc();
        //while (true) {
        //
        //}

    }

    public static void main(String[] args) throws InterruptedException {
        Stack stack = new Stack();
        stack.add();
    }

}
