# JAVA 

+ 筑基 
    - [方法](methoddemo/METHOD.md)
    - [封装](packaging/PACKAGING.md)
    - [继承](extend/EXTEND.md)
    - [多态](polymorphic/POLYMORPHIC.md)
    - [抽象类](abstractdemo/ABSTRACT.md)
    - [接口](interfacedemo/INTERFACE.md)
    - [内部类](innerclass/INNERCLASS.md)
    - [关键字](keyword/KEYWORD.md)
+ 融合
    - [泛型](generics/GENERICS.md)
    - [反射](#反射)
    - [注解](#注解)
    - [输入输出流](#输入输出流)
    - [序列化与反序列化](#序列化与反序列化)
    - [函数式接口](#函数式接口)
    - [Java流式操作](#Java流式操作)
    - [异常](#异常)
 












-----------------
-----------------
-----------------
-----------------
-----------------


## <a name="反射"> 反射 </a>
## <a name="注解"> 注解 </a>
## <a name="输入输出流"> 输入输出流 </a>
## <a name="序列化与反序列化"> 序列化与反序列化 </a>
## <a name="函数式接口"> 函数式接口 </a>
## <a name="Java流式操作"> Java流式操作 </a>




接口响应时间长，问题排查流程

1、先拿到curl

2、curl改造。在curl之后增加
    ```
    "\ntime_namelookup: "%{time_namelookup}"\ntime_connect: "%{time_connect}"\ntime_appconnect: "%{time_appconnect}"\ntime_pretransfer: "%{time_pretransfer}"\ntime_starttransfer: "%{time_starttransfer}"\ntime_redirect: "%{time_redirect}"\ntime_total: "%{time_total}"\n"
    ```
    
3、

4、执行结果
```
time_namelookup: 0.253
time_connect: 0.257
time_appconnect: 0.361
time_pretransfer: 0.361
time_starttransfer: 5.618
time_redirect: 0.000
time_total: 5.618
```

5、解读
DNS 查询：253ms

TCP 连接时间：pretransfter(361) - namelookup(253) = 108ms

服务器处理时间：starttransfter(5618) - pretransfer(361) = 3257ms

内容传输时间：total(5618) - starttransfer(5618) = 0ms