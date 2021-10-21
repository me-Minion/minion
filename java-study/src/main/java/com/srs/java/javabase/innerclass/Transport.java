package com.srs.java.javabase.innerclass;

/**
 * @author shaorensheng
 * @date 2021/10/21
 */
public abstract class Transport {

    /**
     * 非抽象方法
     * 非必须重写
     */
    void run() {
        System.out.println("交通工具类run()");
    }


    public static void main(String[] args) {
        //匿名内部类，将对象的定义和实例化放到了一起
        Transport car = new Transport(){
            /**
             * 重写父类的run()方法
             */
            @Override
            void run() {
                System.out.println("汽车跑");
            }
        };
        car.run();

        Transport airPlain = new Transport() {
            @Override
            void run() {
                System.out.println("飞机飞");
            }
        };
        airPlain.run();
    }
}
