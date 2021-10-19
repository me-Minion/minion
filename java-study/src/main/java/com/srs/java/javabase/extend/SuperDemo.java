package com.srs.java.javabase.extend;

/**
 * 父类
 * @author shaorensheng
 * @date 2021/10/8
 */
public class SuperDemo {

    public SuperDemo() {
    }

    public SuperDemo(String name) {
        this.name = name;
    }

    public SuperDemo(int age) {
        this.age = age;
    }

    public SuperDemo(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void publicMethod() {}
    protected void protectedMethod() {}
    void defaultMethod() {}
    private void privateMethod() {}

    private String name;
    private int age;
    
    public String publicField;
    protected String protectedField;
    String defaultField;

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

    public String getPublicField() {
        return publicField;
    }

    public void setPublicField(String publicField) {
        this.publicField = publicField;
    }

    public String getProtectedField() {
        return protectedField;
    }

    public void setProtectedField(String protectedField) {
        this.protectedField = protectedField;
    }

    public String getDefaultField() {
        return defaultField;
    }

    public void setDefaultField(String defaultField) {
        this.defaultField = defaultField;
    }
}
