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

    /**
     *
     * @param s 此处只能用String类型
     */
    @Override
    public void show(String s) {
        System.out.println(s);
    }
}
