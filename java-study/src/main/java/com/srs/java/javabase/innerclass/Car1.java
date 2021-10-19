package com.srs.java.javabase.innerclass;

/**
 * @author shaorensheng
 * @date 2021/10/18
 */
public class Car1 {

    String name = "Mini";

    static String sta_name = "Sta_Mini";

    void method() {
        System.out.println("method()");
    }

    static void staMethod() {
        System.out.println("staMethod()");
    }

    //静态内部类
    static class Engine1{
        public void run() {
            System.out.println("静态内部类的run()方法");
            System.out.println("发动机启动了");
        }

        void method() {
            //静态内部类，无法访问外部类的非静态属性
//            String name = name;
            String name = sta_name;
            //静态内部类，无法访问外部类的非静态方法
//            method();
        }

        static void staMethod() {
            //属性或方法重名时，遵循就近原则
            //可以使用外部类名.静态方法，指定调用同名的外部方法
            Car1.staMethod();
        }
    }

    public static void main(String[] args) {
        //同一类中，访问静态内部类；另见【Car】
        Engine1 engine = new Engine1();
        engine.run();
        engine.method();
    }
}
