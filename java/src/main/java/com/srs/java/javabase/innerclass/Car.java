package com.srs.java.javabase.innerclass;

/**
 * @author shaorensheng
 * @date 2021/10/15
 */
public class Car {
    //内部类 Engine
    private class Engine{
        //成员内部类，无法声明静态成员
//        static int horsepower = 100;
        int horsepower = 100;

        private void run() {
            System.out.println("发动机启动了！");
        }
    }


    public static void main(String[] args) {
        Engine engine = new Car().new Engine();
        engine.run();
    }
}
