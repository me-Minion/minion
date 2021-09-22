# JAVA 

+ 筑基 
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

## <a name="divtop"> 封装 </a>
## <a name="divtop"> 继承 </a>
## <a name="divtop"> 多态 </a>
## <a name="divtop"> 抽象类 </a>
## <a name="divtop"> 接口 </a>
## <a name="divtop"> 内部类 </a>
## <a name="divtop"> 泛型（Generics） </a>
### 什么是泛型
**泛型，允许在定义类、接口时通过一个标识表示类中某个属性的类型或者是某个方法的返回值及参数类型。这个类型参数将在使用时（例如，继承或实现这个接口，用这个类型声明变量、创建对象时）确定（即传入实际的类型参数，也称为类型实参）。**

### 优点 
+ 保证类型安全（避免运行期抛出ClassCastException）
+ 便捷（避免强制类型转换） 

### 泛型类
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
### 泛型方法
```java
public class GenericsMethod {

    public <T> void print(T t) {
        System.out.println(t);
    }

    public static void main(String[] args) {
        GenericsMethod method = new GenericsMethod();
        method.print(123);
        method.print(123L);
        method.print(123F);
        method.print(123D);
        method.print("123");
    }
}
```
## <a name="divtop"> 反射 </a>
## <a name="divtop"> 注解 </a>
## <a name="divtop"> 输入输出流 </a>
## <a name="divtop"> 序列化与反序列化 </a>
## <a name="divtop"> 函数式接口 </a>
## <a name="divtop"> Java流式操作 </a>
