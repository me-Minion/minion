package com.srs.java.javabase.interfacedemo;

/**
 * @author shaorensheng
 * @date 2021/10/14
 */
public class Student implements Person {

    @Override
    public void run() {
        System.out.println("学生跑步");
    }
    //在实现类中，可以不实现默认方法（没有实现eat()方法）

}
