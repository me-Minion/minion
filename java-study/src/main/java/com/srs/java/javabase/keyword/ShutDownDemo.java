package com.srs.java.javabase.keyword;

import java.util.concurrent.TimeUnit;

/**
 * 两个线程
 * 同时shutdown
 *
 * @author shaorensheng
 * @date 2022/1/11
 */
public class ShutDownDemo {


    volatile boolean shutDownFlag;

    public void shutDown() {
        shutDownFlag = true;
    }


    public void doWork(String name) {
        long l = System.currentTimeMillis();
        while (!shutDownFlag) {

        }
        System.out.println(name + "耗时：" + (System.currentTimeMillis() - l));
    }

    public static void main(String[] args) {
        ShutDownDemo shutDownDemo = new ShutDownDemo();
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            shutDownDemo.doWork("第一线程");
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            shutDownDemo.doWork("第二线程");
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            shutDownDemo.shutDown();
        }).start();
    }

}
