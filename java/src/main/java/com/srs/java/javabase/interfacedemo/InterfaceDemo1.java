package com.srs.java.javabase.interfacedemo;


/**
 * @author shaorensheng
 * @date 2021/10/14
 */
public class InterfaceDemo1 implements Interface1, Interface2 {

    @Override
    public void eat() {
        //接口中存在重名常量，调用方式为：接口名称.常量名
        System.out.println(Interface1.NUM);
        System.out.println(Interface2.NUM);
    }

    /**
     * 当实现类实现两个接口时，同名的默认方法将会发生冲突，解决办法是在实现类中重写这个默认方法
     */
    @Override
    public void defaultMethod() {
        System.out.println("InterfaceDemo defaultMethod");
    }

    public static void main(String[] args) {
        InterfaceDemo1 interfaceDemo1 = new InterfaceDemo1();
        interfaceDemo1.eat();
    }

}
