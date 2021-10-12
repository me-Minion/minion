package com.srs.java.javabase.abstractdemo;

/**
 * @author shaorensheng
 * @date 2021/10/12
 */
public class Circle extends Graph {
    @Override
    public void draw() {
        System.out.println("画个圈圈");
    }

    @Override
    public void area() {
        System.out.println("圈圈的面积");
    }

    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.draw();
        circle.area();
    }
}
