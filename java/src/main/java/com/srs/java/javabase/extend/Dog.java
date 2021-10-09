package com.srs.java.javabase.extend;

/**
 * @author shaorensheng
 * @date 2021/10/8
 */
public class Dog extends Pet {
    @Override
    public void shout() {
        super.shout();
        System.out.println("小狗汪汪~");
    }

    /**
     * 重写方法返回值类型为父类或子类
     * @return
     */
    @Override
    public Dog getPet() {
        return new Dog();
    }

    /**
     * 同一包，子孙类可访问
     */
    @Override
    protected void protectedMethod() {
        //调用父类受保护的方法
        super.protectedMethod();
    }

    @Override
    void defaultMethod() {
        super.defaultMethod();
    }

    /**
     * 父类静态方法不能重写，但可重新声明
     */
    public static void staticMethod(){

    }

    private void privateMethod() {

    }


}
