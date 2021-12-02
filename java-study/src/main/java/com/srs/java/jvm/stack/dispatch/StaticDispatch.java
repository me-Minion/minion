package com.srs.java.jvm.stack.dispatch;

/**
 * @author shaorensheng
 * @date 2021/11/10
 */
public class StaticDispatch {

    static abstract class Human{}
    static class Man extends Human{}
    static class Woman extends Human{}

    public void sayHello(Human guy) {
        System.out.println("hello,guy!");
    }

    public void sayHello(Man man) {
        System.out.println("hello,mna!");
    }

    public void sayHello(Woman woman) {
        System.out.println("hello,woman!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        StaticDispatch sd = new StaticDispatch();
        sd.sayHello(man);
        sd.sayHello(woman);
    }

}
