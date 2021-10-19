package com.srs.java.javabase.interfacedemo;

/**
 * @author shaorensheng
 * @date 2021/10/14
 */
public class Teacher implements Person {
    @Override
    public void run() {
        System.out.println("教师跑步");
    }

    /**
     * 实现类中，重写默认方法，重写不需要 default 关键字
     */
    @Override
    public void eat() {
        //在实现类中调用接口的默认方法，使用 接口名.super.静态方法名()
        Person.super.eat();
        //重写后，可以自定义eat()方法
        System.out.println("教师进餐");
    }
}
