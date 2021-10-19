package com.srs.java.javabase.polymorphic;

/**
 * @author shaorensheng
 * @date 2021/10/11
 */
public class Airplane extends Vehicle {
    @Override
    public void run() {
        System.out.println("飞机会飞");
    }
}
