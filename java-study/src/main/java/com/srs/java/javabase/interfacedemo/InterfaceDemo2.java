package com.srs.java.javabase.interfacedemo;

/**
 * @author shaorensheng
 * @date 2021/10/14
 */
public class InterfaceDemo2 extends InterfaceSuper implements Interface1, Interface2 {

    int NUM = 3;

    @Override
    public void eat() {
        //当父类中的属性常量与接口的常量同名时，子类无法分辨同名的NUN是哪一个，编译时会报错
        System.out.println(NUM);
    }


    public static void main(String[] args) {
        InterfaceDemo2 interfaceDemo2 = new InterfaceDemo2();
        //父类中存在与默认方法同名的方法，实例化子类时，调用其defaultMethod()方法，在没有重写的情况下，它执行了父类的defaultMethod()方法。
        interfaceDemo2.defaultMethod();
        interfaceDemo2.eat();
    }
}
