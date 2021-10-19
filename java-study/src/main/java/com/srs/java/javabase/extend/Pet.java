package com.srs.java.javabase.extend;

/**
 * @author shaorensheng
 * @date 2021/10/8
 */
public class Pet {

    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void shout() {
        System.out.println("宠物会叫！");
    }

    public Pet getPet() {
        return new Pet();
    }

    protected void protectedMethod(){}

    void defaultMethod(){}

    private void privateMethod() {}

    public static void statiMethod() {}

    public final void finalMethod(){}
}
