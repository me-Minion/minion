package com.srs.java.javabase.innerclass;

/**
 * @author shaorensheng
 * @date 2021/10/18
 */
public class Car1 {

    //静态内部类
    static class Engine{
        public void run() {
            System.out.println("静态内部类的run()方法");
            System.out.println("发动机启动了");
        }
    }

    public static void main(String[] args) {
        Engine engine = new Engine();
        engine.run();
    }
}
