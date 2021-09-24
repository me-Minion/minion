# JAVA 

+ 筑基 
    - [方法](#divtop)
    - [封装](#divtop)
    - [继承](#divtop)
    - [多态](#divtop)
    - [抽象类](#divtop) 
    - [接口](#divtop)
    - [内部类](#divtop)
+ 融合
    - [泛型](#divtop)
    - [反射](#divtop)
    - [注解](#divtop)
    - [输入输出流](#divtop)
    - [序列化与反序列化](#divtop)
    - [函数式接口](#divtop)
    - [Java流式操作](#divtop)

## <a name="divtop"> 方法 </a>
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

## <a name="divtop"> 封装 </a>
## <a name="divtop"> 继承 </a>
## <a name="divtop"> 多态 </a>
## <a name="divtop"> 抽象类 </a>
## <a name="divtop"> 接口 </a>
## <a name="divtop"> 内部类 </a>
## <a name="divtop"> 泛型（Generics） </a>
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
## <a name="divtop"> 反射 </a>
## <a name="divtop"> 注解 </a>
## <a name="divtop"> 输入输出流 </a>
## <a name="divtop"> 序列化与反序列化 </a>
## <a name="divtop"> 函数式接口 </a>
## <a name="divtop"> Java流式操作 </a>
