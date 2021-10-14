package com.srs.java.javabase.interfacedemo;

/**
 * @author shaorensheng
 * @date 2021/10/14
 */
public interface Interface1 {

    final int NUM = 100;

    void eat();

    default void defaultMethod(){
        System.out.println("Interface1 defaultMethod");
    }
}
