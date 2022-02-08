# 关键字
## 1. super关键字
<font color="red">**super**</font> 
是用在子类中的，目的是访问父类的变量或方法【详见SuperDemo和SubDemo】。

> * 只能调用父类的public和protected成员；
> * 可以用在子类的构造方法中调用父类的构造方法；
> * 不能用于静态方法中。

## 2. this关键字

<font color="red">**this**</font> 
关键字指向当前类对象的引用【详见SubDemo中的构造器】，它的使用场景为：

> * 访问当前类的成员属性和成员方法；
> * 访问当前类的构造方法；
> * 不能在静态方法中使用。

## 3. final关键字

<font color="red">**final**</font> 关键字可以作用于类、方法或变量。

在使用时，必须将其放在变量类型或者方法返回之前，建议将其放在访问修饰符和static关键字之后
```
//定义一个常量
public static final int MAX_NUM = 99;
```
### 3.1 final作用于类

作用于类上，这个类不会被其他类继承

```java
final class FinalClass{
    
}

//final不能被继承，编译会报错
public class SubClass extends FinalClass{
    
}
```

### 3.2 final作用于方法

当父类中的方法不希望被重写时，可以将该方法标记为final

```java
class FinalClass{
    public final void fianlMethod() {
        System.out.println("这是个final方法。");
    }
}

//final不能被继承，编译会报错
public class SubClass extends FinalClass{
    
    /**
     * 被父类标记为final的方法不允许被继承，编译会报错
     */
    @Override
    public void finalMethod() {
        
    }
}
```

## 4. abstract 关键字

### 4.1 抽象类
abstract修饰类时，称为抽象类。
> * 抽象类不能用来实例化对象，声明抽象类的唯一目的是为了将来对该类进行扩充。
> * 一个类不能同时被abstract和fianl修饰。如果一个类包含抽象方法，那么该类一定要声明为抽象类，否则将出现编译错误。<br>
> * ***抽象类*** 可以包含 **抽象方法** 和 **非抽象方法**。
```java
abstract class AbstractDemo {
    private String name;
    private int age;
    
    /**
     * 抽象方法
     */
    public abstract void doSomething();
    
    /**
     * 非抽象方法
     */
    public void todo(){
        //......
    }
}
```

### 4.2 抽象方法
abstract修饰方法时，称为抽象方法。
> * 抽象方法是一种没有任何实现的方法，该方法的具体实现由子类提供；
> * 抽象方法不能被声明成 fianl 和 static；
> * 任何继承抽象类的子类必须实现父类的所有抽象方法，除非该子类也是抽象类；
> * 如果一个类包含如果抽象方法，那么该类必须声明为抽象类，抽象类可以不包含抽象方法

## 5. synchronized 关键字
synchronized 关键字声明的方法，同一时间只能被一个线程访问。

## 6. transient 关键字
序列化的对象包含transient修饰的实例变量时，java虚拟机跳过该特定的变量。

## 7. volatile关键字
volatile
修饰的成员变量在每次被线程访问时，都强制从共享内存中重新读取该成员变量的值。而且，
当成员变量发生变化时，会强制线程将变化值写到共享内存。
这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。
不具有原子性，线程不安全。 可参照VolatileDemo
具有可见性和有序性（锁）。
