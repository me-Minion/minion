package com.srs.java.javabase.interfacedemo;

/**
 * @author shaorensheng
 * @date 2021/10/14
 */
public interface Person {

    void run();

    /**
     * 默认方法
     */
    default void eat(){
        System.out.println("默认方法-eat()");
    }
}
