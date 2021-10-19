package com.srs.java.javabase.extend;

/**
 * 子类
 * @author shaorensheng
 * @date 2021/10/8
 */
public class SubDemo extends SuperDemo {



    public SubDemo() {
        //使用super，调用父类无参构造
        super();
        //使用super，调用父类属性
        this.defaultMsg = super.defaultField;
        this.protectedMsg = super.protectedField;
        this.publicMsg = super.publicField;
        //使用super，调用父类方法
        super.publicMethod();
        super.protectedMethod();
        super.defaultMethod();//同一包下是可以的，不同包下不行
    }

    public SubDemo(String name, int age) {
        //使用super，调用父类有参构造器
        super(name, age);
        //此处的this指代的是SubDemo，this.name指的是SubDemo中的name
        this.name = name;
    }

    private String name;

    private int age;

    public String publicMsg;
    protected String protectedMsg;
    String defaultMsg;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }
}
