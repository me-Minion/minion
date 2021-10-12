package com.srs.java.javabase.polymorphic;

/**
 * @author shaorensheng
 * @date 2021/10/11
 */
public class Vehicle {
    public void run() {
        System.out.println("交通工具运输");
    }

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle();
        //子类向上转型为父类
        Vehicle airplane = new Airplane();
        Vehicle train = new Train();

        vehicle.run();
        airplane.run();
        train.run();

        //父类转换为子类，虽然可以强转，但是运行会报ClassCastException
//        Train train1 = (Train) new Vehicle();
//        train1.voice();
    }
}
