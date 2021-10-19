# 多态
## 1. 什么是多态
多态即为有多种形态，是指对象能够有多种形态。
在面向对象中最常用的多态性发生在当父类引用指向子类对象时。
> 例如， 火车类和飞机类都继承自交通工具类，这些类下都有各自的run()方法，
> 交通工具的run()方法输出交通工具可以运输，而火车的run()方法输出火车会跑，
> 飞机的run()方法则输出飞机会飞，火车和飞机都继承父类的run()方法，
> 但是对于不同的对象，拥有不同的操作。

## 2. 实现多态
### 2.1 实现条件
在Java中实现多态有3个必要条件：
* 满足继承关系
* 要有重写
* 父类引用指向子类对象

### 2.2 实例
```java
public class Pet{
    public void eat() {
        System.out.println("宠物吃东西");
    }
}

public class Cat extends Pet{
    @Override
    public void eat() {
        System.out.println("喵喵吃猫粮");
    }
}

public class Dog extends Pet{
    @Override
    public void eat() {
        System.out.println("汪汪吃狗粮");
    }
}
```
以上代码中，Cat和Dog继承自Peg，并且都重写了eat()方法，已经满足多态的两个条件。

如何实现让父类引用指向子类对象呢？如下：
```java
public class Demo{
    public static void main(String[] args){
        //分别实例化三个对象，并且保持其类型为父类Pet
        Pet pet = new Pet();
        Pet cat = new Cat();
        Pet dog = new Dog();
        //调用对象下的方法
        pet.eat();
        cat.eat();
        dog.eat();
    }
}
```
运行结果
```
宠物吃东西
喵喵吃猫粮
汪汪吃狗粮
```
在代码中，<font color="blue">Pet cat = new Cat();</font>、<font
color="blue">Pet dog = new
Dog();</font>这两个语句，把Dog和Cat对象转换为Pet对象，
这种把一个子类对象转型为父类对象的做法称为<font color="blue">向上转型</font>。父类引用指向了子类实例，也就实现了多态。

### 2.3 向上转型
向上转型又称为自动转型、隐式转型。向上转型就是父类引用指向子类实例，也就是子类的对象可以赋值给父类对象。例如：
```
Pet pet = new Cat();
```
这是因为Cat类继承自Pet类，它拥有父类Pet的全部功能，所以如果Pet类型的变量指向了子类Cat的实例，是不出现问题的。

向上转型实际上是把一个子类型安全地变成了更加抽象的父类型，由于所有类的根类都是Object，我们也把子类类型转换为Object类型：
```
Cat cat = new Cat();
Obejct o = cat;
```

### 2.4 向下转型
向上转型是父类引用指向子类实例；向下转型是子类引用执行父类实例，向下转型也被称为强制类型转换。例如：
```java
public class Cat extends Pet{
    public void eat() {
        System.out.println("喵喵吃猫粮");
    }
    
    public void run() {
        System.out.println("喵喵跑步");   
    }
    
    public static void main(String[] args){
        //实例化子类
        Pet cat = new Cat();
        //强制类型转化，只有转化为Cat对象后，才能调用其下面的run方法，不转化为Cat对象，是无法调用run方法的
        Cat catObj = (Cat)cat;
        catObj.run();
    }
}
```
运行结果
```
喵喵跑步
```
<font color="blue">Cat</font>中的run方法， 无法通过<font
color="blue">Pet</font>类型的<font
color="blue">Cat</font>实例调用到其下面的<font
color="blue">run</font>方法，需要向下转型，通过<font
color="blue">(Cat)cat</font>将Pet类型的对象强制转为<font color="blue">Cat</font>类型，
这样就可以调用<font color="blue">run</font>方法。

> 注意：
> * 不能将父类对象转换为子类类型（子类功能比父类多，父类转为子类后，会<font
>   color="red">缺少</font>子类的部分功能）
> * 不能将兄弟类对象相互转换（兄弟类之间的功能不尽相同，不同的功能无法凭空变出来）


总结：子类转型为父类，子类的部分功能（子类独有的）无法使用；父类不能转型为子类，如果转型，使用会报错。（详见：Vehicle类）

## 3. instanceof 运算符
<font color=blue>instanceof</font> 运算符用来检查对象引用是否是类型的实例，或者是这个类型的子类，并返回布尔值。
如果是返回<font color=blue>true</font>，不是返回<font color=blue>false</font>。

使用语法：
```
<对象引用> instanceof 特定类型
```

在向下转型之前，可以使用<font
color=blue>instanceof</font>运算符判断，这样可以提高向下转型的安全性：
```
Pet pet = new Cat();
if (pet instanceof Cat) {
    //将父类转换为子类
    Cat cat = (Cat)pet;
}
```
