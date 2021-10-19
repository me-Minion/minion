# 方法
## 1. 传值
调用方和方法之间有参数传递时，要注意方法传值的问题。 

### 1.1 基本类型的传值
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
### 1.2 引用类型的传值
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
## 2. 可变参数
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
# 3. 重载
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
