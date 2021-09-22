package com.srs.java.javabase.generics;

/**
 * @author shaorensheng
 * @date 2021/9/22
 */
public class GenericsMethod {

    public <T> void print(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        GenericsMethod method = new GenericsMethod();
        method.print(123);
        method.print(123L);
        method.print(123F);
        method.print(123D);
        method.print("123");
    }
}
