# JVM
- [跟踪垃圾回收](#跟踪垃圾回收)
- [跟踪类的加载和卸载](#跟踪类的加载和卸载)
- [配置堆空间与栈空间](#配置堆空间与栈空间)


## 跟踪垃圾回收

1. <font color=red>+XX:-PrintGC</font>

当GC发生时打印信息
```
[GC (System.gc())  1997K->488K(125952K), 0.0014044 secs]
[Full GC (System.gc())  488K->375K(125952K), 0.0041663 secs]
```
-  **GC与Full GC：代表了垃圾回收的类型；**
-  **System.gc()：代表了引发方式，是通过调用gc的方法进行的垃圾回收；**
-  **1997K->488K(125952K)：代表了之前使用了1997k的空间，回收之后使用488k空间，也就是此次垃圾回收节省了1997k-488k=1509k的容量。125952K代表总容量；**
-  **488K->375K(125952K)：同上;**
-  **0.0014044 secs：代表了垃圾回收的执行时间，以秒为单位。**
2. <font color=red>+XX:-PrintGCDetails</font>

打印GC详细信息
```
[GC (System.gc()) [PSYoungGen: 1997K->528K(38400K)] 1997K->536K(125952K), 0.0011141 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[Full GC (System.gc()) [PSYoungGen: 528K->0K(38400K)] [ParOldGen: 8K->375K(87552K)] 536K->375K(125952K), [Metaspace: 2668K->2668K(1056768K)], 0.0036296 secs] [Times: user=0.02 sys=0.00, real=0.00 secs] 
Heap
 PSYoungGen      total 38400K, used 333K [0x0000000795580000, 0x0000000798000000, 0x00000007c0000000)
  eden space 33280K, 1% used [0x0000000795580000,0x00000007955d34a8,0x0000000797600000)
  from space 5120K, 0% used [0x0000000797600000,0x0000000797600000,0x0000000797b00000)
  to   space 5120K, 0% used [0x0000000797b00000,0x0000000797b00000,0x0000000798000000)
 ParOldGen       total 87552K, used 375K [0x0000000740000000, 0x0000000745580000, 0x0000000795580000)
  object space 87552K, 0% used [0x0000000740000000,0x000000074005ddb8,0x0000000745580000)
 Metaspace       used 2677K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 287K, capacity 386K, committed 512K, reserved 1048576K
```
-  **PSYoungGen：代表了「年轻代」的回收；Parallel Scavenge**
-  **ParOldGen：「老年代」；**
-  **Metaspace：「元空间」。**

3. <font color=red>+XX:-PrintHeapAtGC</font>

每次GC前后分别打印堆的信息
```
{Heap before GC invocations=1 (full 0):
 PSYoungGen      total 38400K, used 1997K [0x0000000795580000, 0x0000000798000000, 0x00000007c0000000)
  eden space 33280K, 6% used [0x0000000795580000,0x0000000795773448,0x0000000797600000)
  from space 5120K, 0% used [0x0000000797b00000,0x0000000797b00000,0x0000000798000000)
  to   space 5120K, 0% used [0x0000000797600000,0x0000000797600000,0x0000000797b00000)
 ParOldGen       total 87552K, used 0K [0x0000000740000000, 0x0000000745580000, 0x0000000795580000)
  object space 87552K, 0% used [0x0000000740000000,0x0000000740000000,0x0000000745580000)
 Metaspace       used 2668K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 287K, capacity 386K, committed 512K, reserved 1048576K
Heap after GC invocations=1 (full 0):
 PSYoungGen      total 38400K, used 576K [0x0000000795580000, 0x0000000798000000, 0x00000007c0000000)
  eden space 33280K, 0% used [0x0000000795580000,0x0000000795580000,0x0000000797600000)
  from space 5120K, 11% used [0x0000000797600000,0x0000000797690000,0x0000000797b00000)
  to   space 5120K, 0% used [0x0000000797b00000,0x0000000797b00000,0x0000000798000000)
 ParOldGen       total 87552K, used 8K [0x0000000740000000, 0x0000000745580000, 0x0000000795580000)
  object space 87552K, 0% used [0x0000000740000000,0x0000000740002000,0x0000000745580000)
 Metaspace       used 2668K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 287K, capacity 386K, committed 512K, reserved 1048576K
}
 {Heap before GC invocations=2 (full 1):
 PSYoungGen      total 38400K, used 576K [0x0000000795580000, 0x0000000798000000, 0x00000007c0000000)
  eden space 33280K, 0% used [0x0000000795580000,0x0000000795580000,0x0000000797600000)
  from space 5120K, 11% used [0x0000000797600000,0x0000000797690000,0x0000000797b00000)
  to   space 5120K, 0% used [0x0000000797b00000,0x0000000797b00000,0x0000000798000000)
 ParOldGen       total 87552K, used 8K [0x0000000740000000, 0x0000000745580000, 0x0000000795580000)
  object space 87552K, 0% used [0x0000000740000000,0x0000000740002000,0x0000000745580000)
 Metaspace       used 2668K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 287K, capacity 386K, committed 512K, reserved 1048576K
Heap after GC invocations=2 (full 1):
 PSYoungGen      total 38400K, used 0K [0x0000000795580000, 0x0000000798000000, 0x00000007c0000000)
  eden space 33280K, 0% used [0x0000000795580000,0x0000000795580000,0x0000000797600000)
  from space 5120K, 0% used [0x0000000797600000,0x0000000797600000,0x0000000797b00000)
  to   space 5120K, 0% used [0x0000000797b00000,0x0000000797b00000,0x0000000798000000)
 ParOldGen       total 87552K, used 375K [0x0000000740000000, 0x0000000745580000, 0x0000000795580000)
  object space 87552K, 0% used [0x0000000740000000,0x000000074005ddb8,0x0000000745580000)
 Metaspace       used 2668K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 287K, capacity 386K, committed 512K, reserved 1048576K
}
```
GC前后的堆信息</br>
Heap before GC invocations=1 (full 0)</br>
Heap after GC invocations=1 (full 0)</br>
Heap before GC invocations=2 (full 1)</br>
Heap after GC invocations=2 (full 1)</br>
为什么会有两对的before和after？
```
{Heap before GC invocations=1 (full 0):
 PSYoungGen      total 38400K, used 1997K [0x0000000795580000, 0x0000000798000000, 0x00000007c0000000)
  eden space 33280K, 6% used [0x0000000795580000,0x0000000795773448,0x0000000797600000)
  from space 5120K, 0% used [0x0000000797b00000,0x0000000797b00000,0x0000000798000000)
  to   space 5120K, 0% used [0x0000000797600000,0x0000000797600000,0x0000000797b00000)
 ParOldGen       total 87552K, used 0K [0x0000000740000000, 0x0000000745580000, 0x0000000795580000)
  object space 87552K, 0% used [0x0000000740000000,0x0000000740000000,0x0000000745580000)
 Metaspace       used 2668K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 287K, capacity 386K, committed 512K, reserved 1048576K
[GC (System.gc())  1997K->552K(125952K), 0.0012386 secs]
Heap after GC invocations=1 (full 0):
 PSYoungGen      total 38400K, used 544K [0x0000000795580000, 0x0000000798000000, 0x00000007c0000000)
  eden space 33280K, 0% used [0x0000000795580000,0x0000000795580000,0x0000000797600000)
  from space 5120K, 10% used [0x0000000797600000,0x0000000797688000,0x0000000797b00000)
  to   space 5120K, 0% used [0x0000000797b00000,0x0000000797b00000,0x0000000798000000)
 ParOldGen       total 87552K, used 8K [0x0000000740000000, 0x0000000745580000, 0x0000000795580000)
  object space 87552K, 0% used [0x0000000740000000,0x0000000740002000,0x0000000745580000)
 Metaspace       used 2668K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 287K, capacity 386K, committed 512K, reserved 1048576K
}
{Heap before GC invocations=2 (full 1):
 PSYoungGen      total 38400K, used 544K [0x0000000795580000, 0x0000000798000000, 0x00000007c0000000)
  eden space 33280K, 0% used [0x0000000795580000,0x0000000795580000,0x0000000797600000)
  from space 5120K, 10% used [0x0000000797600000,0x0000000797688000,0x0000000797b00000)
  to   space 5120K, 0% used [0x0000000797b00000,0x0000000797b00000,0x0000000798000000)
 ParOldGen       total 87552K, used 8K [0x0000000740000000, 0x0000000745580000, 0x0000000795580000)
  object space 87552K, 0% used [0x0000000740000000,0x0000000740002000,0x0000000745580000)
 Metaspace       used 2668K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 287K, capacity 386K, committed 512K, reserved 1048576K
[Full GC (System.gc())  552K->375K(125952K), 0.0050164 secs]
Heap after GC invocations=2 (full 1):
 PSYoungGen      total 38400K, used 0K [0x0000000795580000, 0x0000000798000000, 0x00000007c0000000)
  eden space 33280K, 0% used [0x0000000795580000,0x0000000795580000,0x0000000797600000)
  from space 5120K, 0% used [0x0000000797600000,0x0000000797600000,0x0000000797b00000)
  to   space 5120K, 0% used [0x0000000797b00000,0x0000000797b00000,0x0000000798000000)
 ParOldGen       total 87552K, used 375K [0x0000000740000000, 0x0000000745580000, 0x0000000795580000)
  object space 87552K, 0% used [0x0000000740000000,0x000000074005ddb8,0x0000000745580000)
 Metaspace       used 2668K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 287K, capacity 386K, committed 512K, reserved 1048576K
}
```
4. <font color=red>+XX:-PrintGCTimeStamps</font>

在每次GC发生时，额外输出GC发生的时间。需和-XX:-PrintGC或-XX:-PrintGCDetails配合使用，单独使用无效
```
0.097: [GC (System.gc())  1997K->520K(125952K), 0.0011353 secs]
0.098: [Full GC (System.gc())  520K->375K(125952K), 0.0038274 secs]
```

## <a name="跟踪类的加载和卸载"> 跟踪类的加载和卸载 </a>

1. <font color=red>-XX:+TraceClassLoading</font>

跟踪类的加载
```
[Opened /Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/rt.jar]
[Loaded java.lang.Object from /Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/rt.jar]
[Loaded java.util.List from /Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home/jre/lib/rt.jar]
[Loaded com.srs.java.jvm.stack.Stack from file:/Library/2app/3github/minion/java/target/classes/]
```
不单单加载我们代码中使用的类，还需要记载各种支持Java运行的核心类

2. <font color=red>-XX:+TraceClassUnLoading</font>

跟踪类的卸载。由于系统类加载器加载的类不会被卸载，并且只加载一次，所以普通项目很难获取到类卸载的日志。

3. <font color=red>-XX:+PrintClassHistogram</font>

打印、查看系统中类的分布情况。

```
num     #instances         #bytes  class name
----------------------------------------------
   1:         13147        1295032  [C
   2:          1053         748776  [B
   3:          2804         313280  java.lang.Class
   4:         12980         311520  java.lang.String
   5:          2135         128528  [Ljava.lang.Object;
   6:          2584          82688  java.util.concurrent.ConcurrentHashMap$Node
   7:          2301          73632  java.util.HashMap$Node
   8:           804          70752  java.lang.reflect.Method
   9:          1230          55944  [I
  10:          1188          47520  java.util.LinkedHashMap$Entry
  11:           191          37400  [Ljava.util.HashMap$Node;
  12:          2230          35680  java.lang.Object
  13:           881          35240  java.util.TreeMap$Entry
  14:           903          34408  [Ljava.lang.String;
  15:            48          32352  [Ljava.util.concurrent.ConcurrentHashMap$Node;
  16:           485          31040  java.net.URL
  17:           671          26840  java.lang.ref.Finalizer
  18:           372          26784  java.lang.reflect.Field
  19:           934          22416  java.util.LinkedList$Node
  59:           128           4096  com.sun.jmx.mbeanserver.ConvertingMethod
 938:             1             16  sun.util.locale.provider.AuxLocaleProviderAdapter$NullProvider
 939:             1             16  sun.util.locale.provider.CalendarDataUtility$CalendarWeekParameterGetter
 940:             1             16  sun.util.locale.provider.SPILocaleProviderAdapter
 941:             1             16  sun.util.locale.provider.TimeZoneNameUtility$TimeZoneNameGetter
 942:             1             16  sun.util.resources.LocaleData
 943:             1             16  sun.util.resources.LocaleData$LocaleDataResourceBundleControl
Total         62089        3982072
```
* num：自增的序列号，只是为了标注行数，没有特殊的意义；
* instances：实例数量，即类的数量；
* bytes：实例所占字节数，即占据的内存空间大小；
* class name：具体的实例；


## <a name="配置堆空间与栈空间">配置堆空间与栈空间</a>
1. <font color=red>-Xms和-Xmx</font>

配置参数-Xms1m -Xmx2m -XX:+PrintGCDetails

```
Heap
 PSYoungGen      total 1024K, used 773K [0x00000007bfe80000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 512K, 60% used [0x00000007bfe80000,0x00000007bfecd5f8,0x00000007bff00000)
  from space 512K, 90% used [0x00000007bff00000,0x00000007bff74010,0x00000007bff80000)
  to   space 512K, 0% used [0x00000007bff80000,0x00000007bff80000,0x00000007c0000000)
 ParOldGen       total 512K, used 0K [0x00000007bfe00000, 0x00000007bfe80000, 0x00000007bfe80000)
  object space 512K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bfe80000)
 Metaspace       used 2676K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 287K, capacity 386K, committed 512K, reserved 1048576K
```

为什么total加起来不是2m？</br>
total指的是实际可用的大小，在年轻代，eden是一直在使用的，from和to同时只会有一个区域被使用。

eden、from、to为啥都是512？

默认堆大小：

没有在命令中指定初始化和最大的堆大小，则取决于计算机上的物理内存大小；

默认最大堆在物理内存192M以下时是物理内存的一半；

在物理内存1GB以下时，为其四分之一；

当物理内存大于等于1GB时最大堆都为256MB



年轻代：老年代=1：2
eden：from：to=8：1：1



<font color=blue>为什么线上-Xms和-Xmx保持一致？</font></br>
项目在运行过程中，堆空间会不断的收缩与扩张，势必会造成不必要的系统压力，设置成一样的，
能避免GC在调整堆大小带来不必要的压力。

2. <font color=red>-Xmn</font>

设置年轻代的大小
同时设置-XX:NewRatio=2，生效的是-Xmn

3. <font color=red>-XX:NewRatio</font>

设置年轻代与老年代的比例，默认比例为1:2.

```
-Xms20m -Xmx20m -XX:NewRatio=1 -XX:+PrintGCDetails
```

```
Heap
 PSYoungGen      total 9216K, used 1195K [0x00000007bf600000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 8192K, 14% used [0x00000007bf600000,0x00000007bf72aee8,0x00000007bfe00000)
  from space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
  to   space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
 ParOldGen       total 10240K, used 0K [0x00000007bec00000, 0x00000007bf600000, 0x00000007bf600000)
  object space 10240K, 0% used [0x00000007bec00000,0x00000007bec00000,0x00000007bf600000)
 Metaspace       used 2674K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 287K, capacity 386K, committed 512K, reserved 1048576K
```


3. <font color=red>-XX:MetaspaceSize 和 -XX:MaxMetaspaceSize</font>
4. <font color=red>-Xss</font>
4. <font color=red>-XX:+PrintFlagsFinal 查看JVM运行时参数</font>
4. <font color=red>-XX:+PrintFlagsInitial 查看JVM初始参数</font>

* uintx MaxNewSize 年轻代大小
* uintx NewSize 年轻待大小
* uintx NewRatio 年轻代：老年代 = 2(即总共3份，年轻代占三分之一，老年代占三分之二)
* uintx OldSize 老年代大小