# 继承
## 1. 什么是继承
继承是面向对象软件技术当中的一个概念。<br>继承可以使得子类具有父类的各种属性和方法，而不需要再次编写相同的代码。
> 一个类B继承自类A，就把B称为A的子类，A称为B的父类或超类。

特点：
> * 一个类只能拥有一个父类，一个父类可以拥有多个子类。
> * 子类一旦继承了父类，就会继承父类所有开放的特征，不能选择性地继承父类特征。
> * 传递性。如果A是B的父类，B是C的父类，那么C也是A的子类。

## 2. 实现继承
```java
/**
* 父类
*/
public class SuperClass {}
/**
* 子类
*/
public class SubClass extends SuperClass {}
```
## 3. 方法重写
B从A中继承了一个方法，如果这个方法没有被标记为final或static，就可以对这个方法进行重写。<br>
> 好处：能够定义特定于子类类型的行为，这意味着子类能够基于要求来实现父类的方法。

### 3.1 重写示例
Pet类
```java
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
        System.out.println("宠物会叫~");
    }
}
```

Dog类 
``` java
public class Dog extends Pet {
    @Override
    public void shout() {
        System.out.println("小狗汪汪~");
    }
}
```

Cat类 
``` java
public class Cat extends Pet {
    @Override
    public void shout() {
        System.out.println("小猫喵喵~");
    }
}
```

调用重写方法：
```
Dog dog = new Dog();
dog.shout();

Cat cat = new Cat();
cat.shout();
```

运行结果：
```
小狗汪汪~
小猫喵喵~
```
如果在重写方法中使用【super.重写方法名】，可以调用父类的方法 
```java
public class Dog extends Pet {
    @Override
    public void shout() {
        super.shout();
        System.out.println("小狗汪汪~");
    }
}
```

运行结果：
```
宠物会叫~
小狗汪汪~
```
### 3.2 方法重写规则
方法重写，有以下规则（详见Pet、Dog、Cat类）：
> * 重写方法的参数列表应该与原方法完全相同；
> * 返回值类型应该和原方法的返回值类型一样，或者是它在父类定义时的子类型【父类方法返回值为父类，子类重写此方法时返回值既可以是父类也可以是子类，参见Dog中getPet方法】；
> * 重写方法访问级别限制不能比原方法高【限制级别：private、default、protected、public依次降低】。例如：如果父类方法声明为公有的，那么子类中的重写方法不能是私有、默认或保护的；
> * 只有被子类继承时，方法才能被重写；
> * 方法定义为final，将不能被重写；
> * 一个方法被定义为static，将使其不能被重写，但是可以重新声明；
> * 一个方法不能被继承，那么也不能被重写；
> * 和父类在一个包中的子类，能够重写任何没有被声明为private和final的父类方法；
> * 和父类不在同一个包中子类，只能重写non-final方法或被声明为public或protected的方法；
> * 一个重写方法能够抛出任何运行时异常，不管被重写方法是否抛出异常。
> * 构造方法不能被重写。

### 3.3 方法重写 与 方法重载 的区别
重写：子类重新定义父类的方法（不在一个类中）。方法名、参数列表、返回类型相同；访问修饰符的限定(限定范围：public、protected、default、private，依次降低)大于等于父类方法。


重载：在同一类中两个或两个以上的方法名相同但是参数不同。方法名相同，参数列表不同。

## 4. 访问修饰符
### 4.1 作用
为了实现对类的封装和继承，Java提供了访问控制机制。

通过访问控制机制，类的设计者可以掩盖变量和方法来达维护类自身状态的目的，而且还可以将另外一些需要暴露的变量和方法提供给别的类进行访问和修改。

### 4.2 种类
> * public : 公共的，可以在任何地方访问。
> * protected : 受保护的，允许在同一个类，同一个包以及不同包的子类中访问；
> * 默认的 : 允许在同一个类，同一个包中访问；
> * private : 私有的，只允许在本类中访问；

|  修饰符 |当前类|同一包|子孙类（同一包）|子孙类（不同包）|其他包|
|---|---|---|---|---|---|
|  public |Y|Y|Y|Y|Y|
|  protected |Y|Y|Y|Y/N(详见ModifiterDemo)|N|
|  default |Y|Y|Y|N|N|
|  private |Y|N|N|N|N|

### 4.3 修饰符小结

> * 方法声明为public，那么所有类都能够访问该方法；
> * 方法声明为private，那么除了当前类之外，其余均不能访问该方法；
> * 如果该方法只想对其所在类的子类可见，则该方法声明为protected。 

