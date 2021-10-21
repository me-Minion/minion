#  内部类
## 1. 什么是内部类
将一个类定义在另一个类里面或者一个方法里面，这样的类称为内部类。

```java
public class Car{
    // 内部类 Engine
    class Engine{
        private String innerName = "发动机内部类";
    }
}
```
代码中，<font color=blue> Engine </font>是内部类，<font color=blue> Car </font>是外部类。

## 2. 分类
Java中的内部类可以分为4种： <font color=blue> 成员内部类 </font>、 <font
color=blue> 静态内部类
 </font> <font color=blue> 方法内部类 </font>和
 </font> <font color=blue> 匿名内部类 </font>。

### 2.1 成员内部类
#### 2.1.1 定义
成员内部类也称为普通内部类，它是最常见的内部类。可以将其看做外部类的一个成员。在成员内部类中无法声明静态成员。 `
```java
//外部类 Car
public class Car {
    
    //内部类 Engine
    private class Engine {
        private void run() {
            System.out.println("发动机启动了！");
        }
    }
}
```

与普通Java类不同，含有内部类的类被编译器编译后，会生成两个独立的字节码文件：
```
Car$Engine.class
Car.class
```
内部类<font color=blue> Engine </font>
会另外生成一个字节码文件，其文件名为：<font color=blue> 
外部类类名$内部类类名.class </font>

#### 2.1.2 实例化
内部类在外部使用时，无法直接实例化，需要借助外部类才能完成实例化操作。关于成员内部类的实例化，有三种方式：

- 通过<font color=blue> new 外部类().new 内部类() </font>的方式获取内部类的实例对象；
```java
public class Car {
    private class Engine {
        private void run() {
            System.out.println("发动机启动了");
        }
    }
    
    public static void main(String[] args){
        //1. 实例化外部类后紧接着实例化内部类
        Engine engine = new Car().new Engine();
        //2. 调用内部类方法
        engine.run();
    }
}
```
- 通过先实例化外部类、再实例化内部类的方法获取内部类的对象实例；
```
public static void main(String[] args){
    //1. 实例化外部类
    Car car = new Car();
    //2. 通过外部类实例对象再实例化内部类
    Engine engine = car.new Engine();
    //3. 调用内部类方法
    engine.run();
}
```
- 在外部类中定义一个获取内部类的方法 <font color=blue> getEngine() </font>
  ，然后通过外部类的实例对象调用这个方法来获取内部类实例；
```java
public class Car {
    
    // 获取内部类实例的方法
    public Engine getEngine() {
        return new Engine();
    }
    
    private class Engine {
        private void run() {
            System.out.println("发动机启动了");
        }
    }
    
    public static void main(String[] args){
        //1. 实例化外部类
        Car car = new Car();
        //2. 调用实例化方法getEngine()，获取内部类实例
        Engine engine = car.getEngine();
        //3. 调用内部类方法
        engine.run();
    }
}
```
#### 2.1.3 成员访问
成员内部类可以直接访问外部类的成员，例如，可以在内部类中访问外部类的成员属性和成员方法。

还存在一个同名成员的问题：如果内部类中也存在一个同名成员，那么优先访问内部类的成员。可理解为就近原则。

这种情况下如果依然希望访问外部类的属性，可以使用<font color=blue>
外部类名.this.成员 </font>的方式


### 2.2 静态内部类
#### 2.2.1 定义
静态内部类也称为嵌套类，是使用<font color=blue> static </font>关键字修饰的内部类。
```java
public class Car1 {
    static class Engine1 {
        public void run() {
            System.out.println("我是静态内部类的run()方法");
            System.out.println("发动机启动了");
        }
    }
}
```

#### 2.2.2 实例化
静态内部类的实例化，可以不依赖外部类的对象直接创建。 
在同一类中：
```
Engine1 engine1 = new Engine1();
engine1.run();
```
在同一包中：
```
Car.Engine1 engine1 = new Car1.Engine1();
engine1.run();
```
其它地方无法访问

#### 2.2.3 成员的访问
在静态内部类中，只能访问外部类中的静态成员或方法。 

属性或方法名相同时，可以通过<font color=blue> 外部类名.静态成员（静态方法）
</font>的方式进行调用。

### 2.3 方法内部类
#### 2.3.1 定义
方法内部类，是定义在方法中的内部类，也称局部内部类。
```java
public class Car2 {
    void run() {
        class Engine2 {
            void run() {
                System.out.println("方法内部类Engine的run()");
            }
        }
        Engine2 engine2 = new Engine2();
        engine2.run();
    }
    
    public static void main(String[] args){
      Car2 car2 = new Car2();
      car2.run();
    }
}
```
运行结果：
```
方法内部类Engine的run()
```

在调用方法内部类的<font color=blue > run() </font>方法，必须在方法内对<font
color=blue > Engine2 </font>类进行实例化，再去调用其 <font color=blue >
run() </font>方法， 然后通过外部类调用自身方法的方式让内部类方法执行。

#### 2.3.2 特点
与局部变量相同，局部内部类也有以下特点：
* 方法内定义的局部内部类只能在方法内部使用；
* 方法内不能定义静态成员；
* 不能使用访问修饰符。

### 2.4 匿名内部类
#### 2.4.1 定义
匿名内部类就是没有名字的内部类。使用匿名内部类，<font
color=blue>通常令其实现一个抽象类或接口</font>。 【详见：Transport】

#### 2.4.2 特点
* 含有匿名内部类的类被编译之后，匿名内部类会单独生成一个字节码文件，文件名的命名方式为：
  <font
  color=blue>外部类名称$数字.class</font>。Transport编译后，生成的字节码文件：
```
Transport$1.class
Transport$2.class
Transport.class
```
* 匿名内部类没有类型名称和实例对象名称；
* 匿名内部类可以继承父类也可以实现接口，但二者不可兼得；
* 匿名内部类无法使用访问修饰符、static、abstract关键字修饰；
* 匿名内部类无法编写构造方法，因为它没有类名
* 匿名内部类中不能出现静态成员。

#### 2.4.2 使用场景
由于匿名内部类没有名称，类的定义和实例化可以放到一起，这样可以简化代码的编写，同时也让代码变得不易阅读。
当我们在代码中只用到类的一个实例、方法只调用一次，可以使用匿名内部类。

## 3. 作用
### 3.1 封装性
内部类的成员通过外部类才能访问，对成员信息有更好的隐藏，因此内部类实现了更好的封装。

### 3.2 实现多继承
Java不支持多继承，而接口可以实现多继承的效果，但实现接口就必须实现里面所有的方法，
有时候我们的需求只是实现其中某个方法，内部类就可以解决这些问题。

```java
public class SuperClass1 {
    void method1(){
        System.out.println("SuperClass1.method1()");
    }
}

public class SuperClass2 {
    void method2(){
        System.out.println("SuperClass2.method2()");
    }
}

public class SubClass {
    
    //通过内部类继承SuperClass1
    class InnerClass1 extends SuperClass1 {
        @Override 
        void method1() {
            System.out.println("InnerClass1.method1()");
        }
    }
    
    //通过内部类继承SuperClass2
    class InnerClass2 extends SuperClass2 {
        @Override 
        void method2() {
            System.out.println("InnerClass2.method2()");
        }
    }
    
    public static void main(String[] args){
        //通过内部类的方式实现多继承
        InnerClass1 innerClass1 = new SubClass().new InnerClass1();
        InnerClass2 innerClass2 = new SubClass().new InnerClass2();
        innerClass1.method1();
        innerClass2.method2();
    }
}
```

### 3.3 解决继承或实现接口是的方法同名问题
```java
public class One {
    public void test() {
        
    }
}

public interface Two {
    void test();
}

public class demo extends One implements Two {
    @Override 
    public void test() {
        
    }
}
```
如上代码中，无法确定Demo中的test()方法是父类One中的test还是接口Two中的test。

内部类可以解决这个问题
```java
public class Demo2 extends One {
    @Override 
    public void test() {
        System.out.println("在外部类重写父类中的test()");
    }
    
    class InnerClass implements Two {
        @Override 
        public void test() {
            System.out.println("在内部类实现接口的test()");
        }
    }
    
    public static void main(String[] args){
      Demo2 demo2 = new Demo2();
      demo2.test();
      //实例化内部类
      InnerClass innerClass = demo2.new InnerClass();
      //调用内部类方法
      innerClass.test();
    }
}
```