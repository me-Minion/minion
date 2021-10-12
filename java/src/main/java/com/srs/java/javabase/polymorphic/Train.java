package com.srs.java.javabase.polymorphic;

/**
 * @author shaorensheng
 * @date 2021/10/11
 */
public class Train extends Vehicle {
    @Override
    public void run() {
        System.out.println("火车会跑");
    }

    public void voice() {
        System.out.println("呜呜");
    }
}
