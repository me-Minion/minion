package com.srs.java.javabase.keyword;

import java.util.concurrent.TimeUnit;

/**
 * 两个线程
 * 一个线程读
 * 一个线程写
 * 加volatile和不加volatile的区别
 * @author shaorensheng
 * @date 2022/1/11
 */
public class VolatileDemo {

    final static int MAX = 5;

    static volatile int init_value = 0;


    public static void main(String[] args) {



        new Thread(()->{
            int local_value = init_value;
            while (local_value < MAX) {
                System.out.println("update----->:" + (++local_value));
                init_value = local_value;
                try {
                    Thread.sleep(8);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "updator").start();

        new Thread(()->{
            int local_value = init_value;
            while (local_value < MAX) {
                /**
                 * 考虑一种场景：
                 * 先读，init_value = 3,local_value = 3
                 * 此时，更新操作，将init_value改为4；
                 * 再读，如果不加休眠2ms，则init_value = 3 ,local_value = 3
                 * if判断时，init_value = 4 ,local_value = 3，符合
                 * 加上休眠2ms，init_value = 4 ,local_value = 3
                 * volatile有延迟？？？？
                 * volatile线程不安全，会出现并发问题！！！
                 */
                //try {
                //    Thread.sleep(2);
                //} catch (InterruptedException e) {
                //    e.printStackTrace();
                //}
                System.out.println(String.format("local_value:%d-init_value:%d", local_value, init_value));
                //System.out.println(String.format("----local_value:%d-init_value:%d", local_value, init_value));
                if (init_value != local_value) {
                    System.out.println("reader:"+ init_value);
                    local_value = init_value;
                }
            }

        }, "reader").start();

    }

}
