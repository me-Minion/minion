package com.srs.java.javabase.extend;

/**
 * 修饰符
 *
 * 此demo主要针对protected
 *
 *【简单描述】
 * protected修饰的成员对于本包及其子类可见。
 *
 *【详细理解】
 * 基类的protected成员是包内可见的，并且对子类可见；
 * 若子类与基类不在同一包中，那么在子类中，子类实例可以访问从基类继承而来的protected方法，而不能访问基类实例的protected方法。
 *
 * @author shaorensheng
 * @date 2021/10/9
 */
public class QualifierDemo extends Thread {

    /**
     * 受保护的
     */
    public void protectedDemo() {
        QualifierDemo demo = new QualifierDemo();
        try {
            //在子类中，子类实例可以访问受保护的方法
            demo.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        Thread thread = new Thread();
        //在子类中，基类实例不能访问受保护的方法
//        thread.clone();
        /**
         * 可以理解为：
         * QualifierDemo 只是继承了 Thread类 的保护型方法区域
         *
         * 并没有继承实例thread的保护型方法区域
         */
        try {
            //可以通过super访问基类的protected方法
            super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 默认的
     */
    public void defaultDemo() {
        //java.lang.Thread.blockedOn方法是默认的
        QualifierDemo demo = new QualifierDemo();
//        demo.blockedOn();不同包，子孙类不可访问
        Thread thread = new Thread();
//        thread.blockedOn();不同包，基类不可访问
//        super.blockedOn();super，不可访问
        //同一包，子孙类可访问，在Dog类中
    }


}
