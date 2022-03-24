package com.srs.java.jvm;

/**
 * @author shaorensheng
 * @date 2022/2/10
 */
public class A {

    private int id;

    private String msg;

    private B b;

    public A(B b) {
        System.out.println(b.getClass().getClassLoader());
        this.b = b;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}
