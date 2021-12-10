package com.srs.java.jvm.stack;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shaorensheng
 * @date 2021/11/15
 */
public class Stack {

    public void add() {
        //int i = 10;
        //int a = i++;
        ////System.out.println(a);
        //int b = ++i;
        //System.out.println(b);
        //List list = new ArrayList();
        //for (int j = 0; j < 1000; j++) {
        //    list.add(j);
        //}
        //System.gc();
        //try {
        //    Thread.sleep(100000000L);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        //System.out.println(Runtime.getRuntime().maxMemory()/1024/1024 +"MB");
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024 +"MB");
        //int[] data = new int[1 * 1024 * 1024];
    }

    public static void main(String[] args) throws InterruptedException {
        Stack stack = new Stack();
        stack.add();
    }

}
