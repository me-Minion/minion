package com.srs.java.javabase.innerclass;

import com.srs.java.javabase.generics.GenericsClass;

/**
 * @author shaorensheng
 * @date 2021/10/15
 */
public class Car {

    String name;


    //内部类 Engine
    private class Engine{
        //成员内部类，无法声明静态成员
//        static int horsepower = 100;
        int horsepower = 100;

        private void run() {
            //内部类可以访问外部类的成员
            System.out.println(name + "发动机启动了！");
        }
    }


    public static void main(String[] args) {
        Car car = new Car();
        car.name = "mini";
        Engine engine = car.new Engine();
        engine.run();
    }
}
