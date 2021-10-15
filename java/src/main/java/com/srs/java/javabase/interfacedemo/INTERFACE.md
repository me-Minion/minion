# 接口
## 1. 什么是接口
> Java接口是一系列方法的声明，是一些方法特征的集合，一个接口只有方法的特征没有方法的实现。

在Java中，被关键字<font color=blue> interface </font>修饰的class就是一个接口。
接口定义了一个行为协议，可以由类层次结构中任何位置的任何类实现。接口中定义了一组抽象方法，
都没有具体实现，实现该接口的类必须实现该接口中定义的所有抽象方法。

接口是为了解决Java单继承这个弊端而产生的，虽然<font
color=red>一个类只能有一个直接父类，但是它可以实现多个接口</font>，
没有继承关系的类也可以实现相同的接口。继承和接口的双重设计既保持了类的数据安全也变相实现了多继承。
## 2. 接口的使用
### 2.1 接口声明
使用<font color=blue> interface </font>关键字声明一个接口：
```java
public interface Person{
    
}
```
### 2.2 接口主体
```java
public interface Person{
    final String NAME = "我是Person接口中的常量";
    void walk();
    void run();
}
```
接口比抽象类更加"抽象"，它下面不能拥有具体实现的方法，必须全部都是抽象方法，
所有的方法默认都是<font color=blue> public abstract </font>的。

接口除了方法声明外，还可以包含常量声明。在接口中定义的所有的常量默认都是public,static,和final的。

接口中的成员声明不允许使用<font color=blue> private </font> 和 <font
color=blue> protected </font> 修饰符。

## 3. 接口继承
接口也是存在继承关系的。接口继承使用<font color=blue> extends </font>关键字。
```java
public interface Interface1{
    void method1();
}

public interface Interface2 extends Interface1{
    void method2();
}
```

当一个类实现 Interface2 接口，将会实现该接口所继承的所有抽象方法
```java
public class MyClass implements Interface2 {
    @Override
    public void method1(){}
    
    @Override
    public void method2(){}
}
```

一个接口可以继承多个父接口，接口名放在<font color=blue> extends </font>后面，以逗号分隔
```java
public interface Interface3 extends Interface1,Interface2 {
    
}
```

当一个类，既存在<font color=blue> extends </font>关键字，又存在<font
color=blue> implements </font> 关键字时：
```java
public class Myclass extends SuperClass implements Interface1{
    
}
```

## 4. 默认方法和静态方法
从jdl1.8开始，接口中可以定义 默认方法 和 静态方法。与抽象方法不同，实现类可以不实现默认方法和类方法。
### 4.1 默认方法
#### 4.1.1 声明
使用<font color=blue> default </font>关键字
```java
public interface Person{
    
    void run();
    
    /**
     * 默认方法
     */
    default void eat(){
        System.out.println("默认方法-eat()");
    }
}
```
#### 4.1.2 调用
在实现类中，可以不实现默认方法；也可以重写默认方法，重写不需要default关键字。

> 实现类中可以调用接口的默认方法，调用方式：<font color=blue> 接口名.super.默认方法名() </font>。

使用场景：当一个方法不需要所有实现类都实现时，可以将该方法声明为默认方法；
也可以将默认方法作为实现类的公共逻辑，在需要用的实现类中调用，不需要不调用，
还可以重写为实现类的独有方法。【详见：Person、Student、Teacher】

### 4.2 静态方法
#### 4.2.1 声明
使用<font color=blue> static </font>关键字在接口中声明静态方法。
```java
public interface Person{
    void walk();
    //声明静态方法
    static void say(){
        System.out.println("Hello");
    }
}
```

#### 4.2.2 调用
类中的静态方法只能被子类继承不能被重写，同样在实现类中，静态方法不能被重写。
>  如果想调用接口中的静态方法，只能使用 <font color=blue> 接口名.静态方法名 
>  </font>的方式调用。

### 4.3 默认方法 和 静态方法 区别
> * 调用方式不同
> * 默认方法可以被实现类重写；静态方法只能被实现类继承，不能重写

## 5. 接口和抽象类的区别
> * 接口的方法默认是public的，所有方法在接口中不能有实现（java
>   8开始，接口方法可以有默认实现），而抽象类可以有非抽象方法；
> * 接口中除了static、final变量，不能有其它变量，而抽象类可以；
> * 一个类可以实现多个接口，但只能实现一个抽象类。接口自己本身可以通过extends关键字扩展多个接口；
> * 接口方法默认修饰符是public，抽象方法可以有public、protected和default这些修饰符（抽象方法就是为了被重写所以不能使用private关键字修饰）；
> * 从设计层面来说，<font color=red>
>   抽象是对类的抽象，是一种模板设计</font>，而<font color=red>
>   接口是对行为的抽象，是一种行为的规范</font>。

## 6. 多个接口中的重名成员解决方法
### 6.1 多个接口存在重名默认方法
当实现多个接口时，同名的默认方法会产生冲突。 【详见：InterfaceDemo1】

当继承的父类中某一方法和实现接口的默认方法同名时，编译不会报错。【详见：InterfaceDemo2】

### 6.2 多个接口存在重名常量
重名常量可以通过类名.常量名获取，但是实际出现时只需保证编译不报错即可。【详见：InterfaceDemo1、InterfaceDemo2】

## 7. 小结
接口是为了解决其单继承的弊端而产生的，可以使用<font color=blue> interface
</font> 关键字来声明一个接口，接口内部不能有具体的方法实现。 可以使用<font
color=blue> implements </font>
关键字来实现接口，一个接口可以继承多个父接口，接口名放在<font color=blue> extends
</font>后面，以逗号分割。从 Java 8 开始，接口中可以定义默认方法和静态方法。
