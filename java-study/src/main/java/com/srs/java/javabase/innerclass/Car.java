package com.srs.java.javabase.innerclass;


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

        public Engine() {
        }

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
        //同一包中，访问静态内部类；另见【Car1】
        Car1.Engine1 engine1 = new Car1.Engine1();
    }
}
