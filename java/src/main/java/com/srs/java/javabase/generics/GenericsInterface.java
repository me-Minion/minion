package com.srs.java.javabase.generics;

/**
 * @author shaorensheng
 * @date 2021/9/22
 */
public interface GenericsInterface<T> {
    public void show(T t);
}


class GenericsInterfaceImpl<T> implements  GenericsInterface<T> {

    @Override
    public void show(T t) {
        System.out.println(t);
    }
}

class GenericsInterfaceImpl1 implements  GenericsInterface<String> {

    @Override
    public void show(String s) {
        System.out.println(s);
    }
}
