# JAVA 

+ 筑基 
    - [方法](#方法)
    - [封装](#封装)
    - [继承](#继承)
    - [多态](#多态)
    - [抽象类](#抽象类) 
    - [接口](#接口)
    - [内部类](#内部类)
    - [关键字](#关键字)
+ 融合
    - [泛型](#泛型)
    - [反射](#反射)
    - [注解](#注解)
    - [输入输出流](#输入输出流)
    - [序列化与反序列化](#序列化与反序列化)
    - [函数式接口](#函数式接口)
    - [Java流式操作](#Java流式操作)


 ![avatar](/interfacedemo/interface.md)
 
 [interface](/interfacedemo/interface.md)
 
 [interface.md](/interfacedemo/interface.md)
## <a name="方法"> 方法 </a>
### 1. 传值
调用方和方法之间有参数传递时，要注意方法传值的问题。 

#### 1.1 基本类型的传值
> 基本类型参数的传递，是调用方值的复制。</br> 双方各自的后续修改，互不影响。
```java
public class MethodDemo {

    /**
     * 基本类型传值
     * @param a
     */
    public void add(int a) {
        System.out.println("before:" + a);
        a ++;
        System.out.println("after:" + a);
    }

    public static void main(String[] args) {
        int a = 10;
        MethodDemo demo = new MethodDemo();
        demo.add(a);
        System.out.println("result:" + a);
    }
}
```
> 基本数据类型：<br> 数字型：short、int、float、duoble、long<br>
> 字符型：byte、char<br> 布尔型：boolean
```
运行结果：
before:10
after:11
result:10
```
#### 1.2 引用类型的传值
> 引用类型参数的传递，调用方的变量，和接收方的参数变量，地址指向的是<font
> color="red" >同一个对象</font>。 双方任意一方对这个对象的修改，都会影响对方。
```java
public class MethodDemo {

    public void change(int[] arr) {
        System.out.println("before:" + Arrays.toString(arr));
        arr[0] = 20;
        System.out.println("after:" + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        MethodDemo demo = new MethodDemo();
        int[] arr = {10};
        demo.change(arr);
        System.out.println("result:" + Arrays.toString(arr));
    }
}
```
> 引用类型：<br> 类（Class）<br>接口（interface）<br>数组
```
运行结果：
before:[10]
after:[20]
result:[20]
```
### 2. 可变参数
> 可变参数列表的语法：参数类型... 参数名

```java
public class MethodDemo {

    /**
     * 可变参数
     */
    public static void sum(int... i) {
        int sum = 0;
        for (int i1 : i) {
            sum += i1;
        }
        System.out.println(sum);
    }

    /**
     * 参数列表有两个或两个以上参数时，可变参数一定要放在最后
     */
    public static void say(String name, String... words) {
        for (String word : words) {
            System.out.println(name + "：" +word);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        //可变参数
        sum(1,2,3);
        //可变参数改为数组
        sum(arr);
        //可变参数一定要放在最后
        say("张三", "18岁","192CM","大一");
    }

}
```
```
6
6
张三：18岁
张三：192CM
张三：大一
```
### 3. 重载
> 在一个类中，方法名字相同，参数列表不同。返回类型可以相同也可以不相同。<br>最常用的地方就是构造器的重载。

```java
public class MethodDemo {

//    public MethodDemo say() {
//        System.out.println("没有同学。");
//        return null;
//    }

    public void say() {
        System.out.println("没有同学。");
    }

    public void say(String name) {
        System.out.println(name + "同学好。");
    }

    public void say(String name, int age) {
        System.out.println(name + "同学：" + age);
    }
    
    public void say(String name, int age) {
        System.out.println(name + "同学：" + age);
    }

    public static void main(String[] args) {
        MethodDemo demo = new MethodDemo();
        demo.say();
        demo.say("张飞");
        demo.say("张飞", 21);
    }
}
```
> 以上say方法属于重载，注释掉的方法因为和say()参数列表相同，算是重载的一种，但是不能和say()共存。



## <a name="封装"> 封装 </a>
### 1. 什么是封装
类的基本作用就是封装代码。<br/>封装将类的一些特征和行为隐藏在类的内部，不允许类外部直接访问。
> 封装的两个特点：<br/>1.只能通过规定的方法访问数据。<br/>2.隐藏类的实例细节，方便修改和实现。

### 2. 为什么需要封装
封装具有以下有点：
> * 封装有利于提高类的内聚性，适当的封装可以让代码更容易理解与维护；
> * 良好的封装有利于降低代码的耦合度；
> * 一些关键属性只允许类内部可以访问和修改，增强类的安全性；
> * 隐藏实现细节，为调用方提供易于理解的接口；
> * 当需求发生变动时，我们只需要修改我们封装的代码，而不需要导出修改调用处的代码。

### 3. 实现封装
分为3个步骤：
> * 修改属性的可见性为private；
> * 创建公开的getter和setter方法，分别用于属性的读写；
> * 在gettere和setter方法中，对属性的合理性进行判断。

### 4. 小结
> 封装隐藏了对象的信息，并且留出了访问的接口。

## <a name="继承"> 继承 </a>
### 1. 什么是继承
继承是面向对象软件技术当中的一个概念。<br>继承可以使得子类具有父类的各种属性和方法，而不需要再次编写相同的代码。
> 一个类B继承自类A，就把B称为A的子类，A称为B的父类或超类。

特点：
> * 一个类只能拥有一个父类，一个父类可以拥有多个子类。
> * 子类一旦继承了父类，就会继承父类所有开放的特征，不能选择性地继承父类特征。
> * 传递性。如果A是B的父类，B是C的父类，那么C也是A的子类。

### 2. 实现继承
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
### 3. 方法重写
B从A中继承了一个方法，如果这个方法没有被标记为final或static，就可以对这个方法进行重写。<br>
> 好处：能够定义特定于子类类型的行为，这意味着子类能够基于要求来实现父类的方法。

#### 3.1 重写示例
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
#### 3.2 方法重写规则
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

#### 3.3 方法重写 与 方法重载 的区别
重写：子类重新定义父类的方法（不在一个类中）。方法名、参数列表、返回类型相同；访问修饰符的限定(限定范围：public、protected、default、private，依次降低)大于等于父类方法。


重载：在同一类中两个或两个以上的方法名相同但是参数不同。方法名相同，参数列表不同。

### 4. 访问修饰符
#### 4.1 作用
为了实现对类的封装和继承，Java提供了访问控制机制。

通过访问控制机制，类的设计者可以掩盖变量和方法来达维护类自身状态的目的，而且还可以将另外一些需要暴露的变量和方法提供给别的类进行访问和修改。

#### 4.2 种类
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

#### 4.3 修饰符小结

> * 方法声明为public，那么所有类都能够访问该方法；
> * 方法声明为private，那么除了当前类之外，其余均不能访问该方法；
> * 如果该方法只想对其所在类的子类可见，则该方法声明为protected。 



## <a name="多态"> 多态 </a>
### 1. 什么是多态
多态即为有多种形态，是指对象能够有多种形态。
在面向对象中最常用的多态性发生在当父类引用指向子类对象时。
> 例如， 火车类和飞机类都继承自交通工具类，这些类下都有各自的run()方法，
> 交通工具的run()方法输出交通工具可以运输，而火车的run()方法输出火车会跑，
> 飞机的run()方法则输出飞机会飞，火车和飞机都继承父类的run()方法，
> 但是对于不同的对象，拥有不同的操作。

### 2. 实现多态
#### 2.1 实现条件
在Java中实现多态有3个必要条件：
* 满足继承关系
* 要有重写
* 父类引用指向子类对象

#### 2.2 实例
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

#### 2.3 向上转型
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

#### 2.4 向下转型
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

### 3. instanceof 运算符
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


## <a name="抽象类"> 抽象类 </a>
### 1. 什么是抽象类
在面向对象的概念中，所有的对象都是通过类来描绘的，但是反过来，并不是所有的类都是用来描绘对象的，
如果一个类中没有包含足够的信息来描绘一个具体的对象，这样的类就是抽象类。

抽象类不能直接实例化，但类的其他功能依然存在，必须被继承才能被使用。

### 2. 抽象类的使用
使用<font color=blue> abstract </font>关键字声明抽象类，<font color=blue>
abstract </font>关键字必须放在<font color=blue> class </font>关键字前面：
```
abstract class Pet{
    ...
}
```
使用
```java
abstract class Pet{
    abstract void eat();
}
class Cat extends Pet{
    @Override 
    void eat(){
        System.out.println("喵喵吃猫粮");
    }
}
```
使用抽象类，既可以通过父类和子类的继承关系，限定子类的设计随意性，也可以避免父类的无意义实例化。

### 3. 抽象方法
抽象类中可以包含抽象方法，它没有具体实现的方法（与普通方法不同的是，它没有方法体）。

抽象类只声明方法，不关系这些方法的具体实现，而子类必须去实现这些方法。如上面的Pet和Cat。
### 4. 小结
> * 抽象类不能被实例化，如果被实例化，就会报错，编译无法通过。只有抽象类的非抽象子类可以创建对象。
> * 抽象类中不一定包含抽象方法，但是有抽象方法的类必定是抽象类。
> * 抽象类中的抽象方法只是声明，不包含方法体（没有方法的具体实现）。
> * 构造方法，类方法（用static修饰的方法）不能声明为抽象方法。
> * 抽象类的子类必须给出抽象类中的抽象方法的具体实现，除非该子类也是抽象类。

## <a name="接口"> 接口 </a>
### 1. 什么是接口
> Java接口是一系列方法的声明，是一些方法特征的集合，一个接口只有方法的特征没有方法的实现。

在Java中，被关键字<font color=blue> interface </font>修饰的class就是一个接口。
接口定义了一个行为协议，可以由类层次结构中任何位置的任何类实现。接口中定义了一组抽象方法，
都没有具体实现，实现该接口的类必须实现该接口中定义的所有抽象方法。

接口是为了解决Java单继承这个弊端而产生的，虽然<font
color=red>一个类只能有一个直接父类，但是它可以实现多个接口</font>，
没有继承关系的类也可以实现相同的接口。继承和接口的双重设计既保持了类的数据安全也变相实现了多继承。
### 2. 接口的使用
#### 2.1 接口声明
使用<font color=blue> interface </font>关键字声明一个接口：
```java
public interface Person{
    
}
```
#### 2.2 接口主体
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

### 3. 接口继承
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

### 4. 默认方法和静态方法
从jdl1.8开始，接口中可以定义 默认方法 和 静态方法。与抽象方法不同，实现类可以不实现默认方法和类方法。
#### 4.1 默认方法
##### 4.1.1 声明
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
##### 4.1.2 调用
在实现类中，可以不实现默认方法；也可以重写默认方法，重写不需要default关键字。

> 实现类中可以调用接口的默认方法，调用方式：<font color=blue> 接口名.super.默认方法名() </font>。

使用场景：当一个方法不需要所有实现类都实现时，可以将该方法声明为默认方法；
也可以将默认方法作为实现类的公共逻辑，在需要用的实现类中调用，不需要不调用，
还可以重写为实现类的独有方法。【详见：Person、Student、Teacher】

#### 4.2 静态方法
##### 4.2.1 声明
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

##### 4.2.2 调用
类中的静态方法只能被子类继承不能被重写，同样在实现类中，静态方法不能被重写。
>  如果想调用接口中的静态方法，只能使用 <font color=blue> 接口名.静态方法名 
>  </font>的方式调用。

#### 4.3 默认方法 和 静态方法 区别
> * 调用方式不同
> * 默认方法可以被实现类重写；静态方法只能被实现类继承，不能重写

### 5. 接口和抽象类的区别
> * 接口的方法默认是public的，所有方法在接口中不能有实现（java
>   8开始，接口方法可以有默认实现），而抽象类可以有非抽象方法；
> * 接口中除了static、final变量，不能有其它变量，而抽象类可以；
> * 一个类可以实现多个接口，但只能实现一个抽象类。接口自己本身可以通过extends关键字扩展多个接口；
> * 接口方法默认修饰符是public，抽象方法可以有public、protected和default这些修饰符（抽象方法就是为了被重写所以不能使用private关键字修饰）；
> * 从设计层面来说，<font color=red>
>   抽象是对类的抽象，是一种模板设计</font>，而<font color=red>
>   接口是对行为的抽象，是一种行为的规范</font>。

### 6. 多个接口中的重名成员解决方法
#### 6.1 多个接口存在重名默认方法
当实现多个接口时，同名的默认方法会产生冲突。 【详见：InterfaceDemo1】

当继承的父类中某一方法和实现接口的默认方法同名时，编译不会报错。【详见：InterfaceDemo2】

#### 6.2 多个接口存在重名常量
重名常量可以通过类名.常量名获取，但是实际出现时只需保证编译不报错即可。【详见：InterfaceDemo1、InterfaceDemo2】

### 7. 小结
接口是为了解决其单继承的弊端而产生的，可以使用<font color=blue> interface
</font> 关键字来声明一个接口，接口内部不能有具体的方法实现。 可以使用<font
color=blue> implements </font>
关键字来实现接口，一个接口可以继承多个父接口，接口名放在<font color=blue> extends
</font>后面，以逗号分割。从 Java 8 开始，接口中可以定义默认方法和静态方法。



## <a name="内部类"> 内部类 </a>
### 1. 什么是内部类
### 2. 分类
#### 2.1 成员内部类
#### 2.2 静态内部类
#### 2.3 方法内部类
#### 2.4 匿名内部类
### 3. 作用
#### 3.1 封装性
#### 3.2 实现多继承
#### 3.3 解决继承或实现接口是的方法同名问题

## <a name="关键字"> 关键字 </a>
### 1. super关键字
<font color="red">**super**</font> 
是用在子类中的，目的是访问父类的变量或方法【详见SuperDemo和SubDemo】。

> * 只能调用父类的public和protected成员；
> * 可以用在子类的构造方法中调用父类的构造方法；
> * 不能用于静态方法中。

### 2. this关键字

<font color="red">**this**</font> 
关键字指向当前类对象的引用【详见SubDemo中的构造器】，它的使用场景为：

> * 访问当前类的成员属性和成员方法；
> * 访问当前类的构造方法；
> * 不能在静态方法中使用。

### 3. final关键字

<font color="red">**final**</font> 关键字可以作用于类、方法或变量。

在使用时，必须将其放在变量类型或者方法返回之前，建议将其放在访问修饰符和static关键字之后
```
//定义一个常量
public static final int MAX_NUM = 99;
```
#### 3.1 final作用于类

作用于类上，这个类不会被其他类继承

```java
final class FinalClass{
    
}

//final不能被继承，编译会报错
public class SubClass extends FinalClass{
    
}
```

#### 3.2 final作用于方法

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

### 4. abstract 关键字

#### 4.1 抽象类
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

#### 4.2 抽象方法
abstract修饰方法时，称为抽象方法。
> * 抽象方法是一种没有任何实现的方法，该方法的具体实现由子类提供；
> * 抽象方法不能被声明成 fianl 和 static；
> * 任何继承抽象类的子类必须实现父类的所有抽象方法，除非该子类也是抽象类；
> * 如果一个类包含如果抽象方法，那么该类必须声明为抽象类，抽象类可以不包含抽象方法

### 5. synchronized 关键字
synchronized 关键字声明的方法，同一时间只能被一个线程访问。

### 6. transient 关键字
序列化的对象包含transient修饰的实例变量时，java虚拟机跳过该特定的变量。

### 7. volatile关键字
volatile
修饰的成员变量在每次被线程访问时，都强制从共享内存中重新读取该成员变量的值。而且，
当成员变量发生变化时，会强制线程将变化值写到共享内存。
这样在任何时刻，两个不同的线程总是看到某个成员变量的同一个值。



-----------------
-----------------
-----------------
-----------------
-----------------

## <a name="泛型"> 泛型（Generics） </a>
### 1. 什么是泛型
泛型，允许在定义类、接口时通过一个标识表示类中某个属性的类型或者是某个方法的返回值及参数类型。这个类型参数将在使用时（例如，继承或实现这个接口，用这个类型声明变量、创建对象时）确定（即传入实际的类型参数，也称为类型实参）。
> 代码路径 /javabase/generics
### 2. 优点 
+ 保证类型安全（避免运行期抛出ClassCastException）
+ 便捷（避免强制类型转换） 
### 3. 使用
#### 3.1 泛型类
```java
public class GenericsClass<T> {

    private T number;

    public T getNumber() {
        return number;
    }

    public void setNumber(T number) {
        this.number = number;
    }

    public static void main(String[] args) {
        GenericsClass<Long> genericsClass = new GenericsClass();
        genericsClass.setNumber(123L);
        System.out.println(genericsClass.getNumber());
    }
}
```
#### 3.2 泛型方法
```java
public class GenericsMethod {

    /**
     * 入参为任意类型
     * @param t
     * @param <T>
     */
    public <T> void print(T t) {
        System.out.println(t);
    }

    /**
     * 限定入参T为Father及其子类
     * @param t
     * @param <T>
     */
    public <T extends Father> void print1(T t) {
        System.out.println(t);
    }

    /**
     * <T> T 写法表示返回类型和入参类型一致。
     * @param t
     * @param <T>
     */
    public <T> T print4(T t) {
        return t;
    }

    public static void main(String[] args) {
        GenericsMethod method = new GenericsMethod();
        method.print(new Person());
        method.print(new Father());
        method.print(new Son());
        method.print(new Grandson());

//        method.print1(new Person());
        method.print1(new Father());
        method.print1(new Son());
        method.print1(new Grandson());

        Person person = method.print4(new Person());
        Father father = method.print4(new Father());
        Son son = method.print4(new Son());
        Grandson grandson = method.print4(new Grandson());
    }
}
```
>  \<T> T
>  表示返回类型为T（即为任意类型）。</br>泛型方法中没有super，只有extends。
### 4. 泛型类的子类
> 泛型也是一个java类，它也具有继承的特性。泛型类的继承可以分为两类：
#### 4.1 明确类型参数变量
```java
public interface GenericsInterface<T> {
    public void show(T t);
}


class GenericsInterfaceImpl implements  GenericsInterface<String> {

    @Override
    public void show(String s) {
        System.out.println(s);
    }
}
```
> 子类实现明确了泛型的参数变量为String类型。因此方法show()的重写也将T替换为了String类型。
#### 4.2 不明确类型参数变量
> 当实现类不确定泛型类的参数变量时，实现类需要定义类型参数变量，调用者使用子类时，也需要传递类型参数变量。
```java
public interface GenericsInterface<T> {
    public void show(T t);
}


class GenericsInterfaceImpl<T> implements  GenericsInterface<T> {

    @Override
    public void show(T t) {
        System.out.println(t);
    }
}
```
### 5. 类型通配符
#### 5.1 无限定通配符
```java
public class GenericsWildCard {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        List<Father> fatherList = new ArrayList<>();
        List<Son> sonList = new ArrayList<>();
        List<Grandson> grandsonList = new ArrayList<>();
        
        GenericsWildCard wildCard = new GenericsWildCard();
        wildCard.show(personList);
        wildCard.show(fatherList);
        wildCard.show(sonList);
        wildCard.show(grandsonList);
    }

    /**
     * 无限定 通配符
     * @param list
     */
    public void show(List<?> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
class Person{}
class Father extends Person{}
class Son extends Father{}
class Grandson extends Son{}
```
> 此处的?就是类型通配符，表示可以匹配任意类型，因此调用方可以传递任意泛型类型的列表。
#### 5.2 extends 通配符
```java
public class GenericsWildCard {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        List<Father> fatherList = new ArrayList<>();
        List<Son> sonList = new ArrayList<>();
        List<Grandson> grandsonList = new ArrayList<>();
        
        GenericsWildCard wildCard = new GenericsWildCard();
//        wildCard.show1(personList);
        wildCard.show1(fatherList);
        wildCard.show1(sonList);
        wildCard.show1(grandsonList);
    }

    /**
     * extends 通配符
     * @param list
     */
    public void show1(List<? extends Father> list) {
        for (Father father : list) {
            System.out.println(father);
        }
    }
}
class Person{}
class Father extends Person{}
class Son extends Father{}
class Grandson extends Son{}
```
> 这样的写法的含义为：List集合装载的元素只能是Father自身或其子类
#### 5.3 super 通配符
```java
public class GenericsWildCard {

    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();
        List<Father> fatherList = new ArrayList<>();
        List<Son> sonList = new ArrayList<>();
        List<Grandson> grandsonList = new ArrayList<>();
        
        GenericsWildCard wildCard = new GenericsWildCard();
        wildCard.show2(personList);
        wildCard.show2(fatherList);
        wildCard.show2(sonList);
//        wildCard.show2(grandsonList);
    }

    /**
     * super通配符
     * @param list
     */
    public void show2(List<? super Son> list) {
        for (Object o : list) {
            System.out.println(o);
        }
    }
}
class Person{}
class Father extends Person{}
class Son extends Father{}
class Grandson extends Son{}
```
> 这样的写法的含义为：List集合装载的元素只能是Son自身或其父类
## <a name="反射"> 反射 </a>
## <a name="注解"> 注解 </a>
## <a name="输入输出流"> 输入输出流 </a>
## <a name="序列化与反序列化"> 序列化与反序列化 </a>
## <a name="函数式接口"> 函数式接口 </a>
## <a name="Java流式操作"> Java流式操作 </a>
