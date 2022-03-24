# JVM指令

- [GC常用参数](#GC常用参数)
- [跟踪垃圾回收](#跟踪垃圾回收)
- [跟踪类的加载和卸载](#跟踪类的加载和卸载)
- [配置堆空间与栈空间](#配置堆空间与栈空间)
- [堆栈设置](#堆栈设置)

## GC常用参数

### 堆栈设置

* -Xss：每个线程的栈大小
* -Xms：初始堆大小，默认物理内存的1/64
* -Xmx：最大堆大小，默认物理内存的1/4
* -Xmn：新生代大小
* -XX:NewSize：设置新生代初始大小
* -XX:NewRatio：默认为2，表示新生代占老年代的1/2，占整个堆内存的1/3
* -XX:SurvivorRatio：默认为8，表示一个survivor区占用1/8的Eden内存，即1/10的新生代内存
* -XX:MetaspaceSize：设置元空间大小
* -XX:MaxMetaspaceSize：设置元空间最大允许大小，默认不受限制，JVM Metaspace会进行动态扩展

<!--### 垃圾回收统计信息-->

* -XX:+PrintGC
* -XX:+PrintGCDetails
* -XX:+PrintGCTimeStamps
* -Xloggc:filename

### 收集器设置

* -XX:+UseSerialGC : 设置串行收集器 serial + serial old def new generation / tenured generation
* -XX:+UseParallelGC : 设置并行收集器 parallel + serial old PSYoungGen / ParOldGen
* -XX:+UseParallelOldGC : 老年代使用并行回收收集器 parallel + parallel old    PSYoungGen / ParOldGen
* -XX:+UseParNewGC : 在新生代使用并行收集器 parNew + serial old par new generation / tenured generation
* -XX:+UseConcMarkSweepGC : 设置CMS并发收集器 ParNew + CMS + Serial Old par new generation / concurrent mark-sweep generation
* -XX:+UseG1GC : 设置G1收集器
* -XX:ParallelGCThreads : 设置用于垃圾回收的线程数

### 并行收集器设置

* -XX:ParallelGCThreads :设置并行收集器收集时使用的CPU数。并行收集线程数。 
* -XX:MaxGCPauseMillis :设置并行收集最大暂停时间 
* -XX:GCTimeRatio :设置垃圾回收时间占程序运行时间的百分比。公式为1/(1+n)

### CMS收集器设置

* -XX:+UseConcMarkSweepGC : 设置CMS并发收集器 
* -XX:+CMSIncrementalMode : 设置为增量模式。适用于单CPU情况。 
* -XX:ParallelGCThreads : 设置并发收集器新生代收集方式为并行收集时，使用的CPU数。并行收集线程数。 
* -XX:CMSFullGCsBeforeCompaction : 设定进行多少次CMS垃圾回收后，进行一次内存压缩 
* -XX:+CMSClassUnloadingEnabled : 允许对类元数据进行回收 
* -XX:UseCMSInitiatingOccupancyOnly : 表示只在到达阀值的时候，才进行CMS回收
* -XX:+CMSIncrementalMode:设置为增量模式。适用于单CPU情况 
* -XX:ParallelCMSThreads : 设定CMS的线程数量 
* -XX:CMSInitiatingOccupancyFraction : 设置CMS收集器在老年代空间被使用多少后触发 
* -XX:+UseCMSCompactAtFullCollection : 设置CMS收集器在完成垃圾收集后是否要进行一次内存碎片的整理

### G1收集器设置

* -XX:+UseG1GC : 使用G1收集器
* -XX:ParallelGCThreads : 指定GC工作的线程数量 
* -XX:G1HeapRegionSize : 指定分区大小(1MB~32MB，且必须是2的幂)，默认将整堆划分为2048个分区 
* -XX:GCTimeRatio : 吞吐量大小，0-100的整数(默认9)，值为n则系统将花费不超过1/(1+n)的时间用于垃圾收集 
* -XX:MaxGCPauseMillis : 目标暂停时间(默认200ms) 
* -XX:G1NewSizePercent : 新生代内存初始空间(默认整堆5%) 
* -XX:G1MaxNewSizePercent : 新生代内存最大空间
* -XX:TargetSurvivorRatio : Survivor填充容量(默认50%)
* -XX:MaxTenuringThreshold : 最大任期阈值(默认15) 
* -XX:InitiatingHeapOccupancyPercen : 老年代占用空间超过整堆比IHOP阈值(默认45%),超过则执行混合收集 
* -XX:G1HeapWastePercent : 堆废物百分比(默认5%) 
* -XX:G1MixedGCCountTarget : 参数混合周期的最大总次数(默认8)



-XX:+PrintCommandLineFlags -version

查看JVM使用的默认垃圾收集器



## 跟踪垃圾回收

## 栈

1. <font color=red>+XX:-PrintGC</font>

当GC发生时打印信息

```
[GC (System.gc())  1997K->488K(125952K), 0.0014044 secs]
[Full GC (System.gc())  488K->375K(125952K), 0.0041663 secs]
```

- **GC与Full GC：代表了垃圾回收的类型；**
- **System.gc()：代表了引发方式，是通过调用gc的方法进行的垃圾回收；**
- **1997K->488K(125952K)：代表了之前使用了1997k的空间，回收之后使用488k空间，也就是此次垃圾回收节省了1997k-488k=1509k的容量。125952K代表总容量；**
- **488K->375K(125952K)：同上;**
- **0.0014044 secs：代表了垃圾回收的执行时间，以秒为单位。**
2. <font color=red>-XX:+PrintGCDetails</font>

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

- **PSYoungGen：代表了「年轻代」的回收；Parallel Scavenge**

- **ParOldGen：「老年代」；**

- **Metaspace：「元空间」。**
3. <font color=red>-XX:+PrintHeapAtGC</font>

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

## 跟踪类的加载和卸载

1 . <font color=red>-XX:+TraceClassLoading</font>

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

## 配置堆空间与栈空间

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

为什么total加起来不是2m？
total指的是实际可用的大小，在年轻代，eden是一直在使用的，from和to同时只会有一个区域被使用。

eden、from、to为啥都是512？

猜测是堆设置的太小了

默认堆大小：
初始堆大小，默认为内存的1/64
最大堆大小，默认为内存的1/4                                                                      

年轻代：老年代=1：2
eden：from：to=8：1：1

<font color=red>为什么线上-Xms和-Xmx保持一致？</font>
项目在运行过程中，堆空间会不断的收缩与扩张，势必会造成不必要的系统压力，设置成一样的，能避免GC在调整堆大小带来不必要的压力。

2. <font color=red>-Xmn</font>

设置年轻代大小

> -XX:+PrintGCDetails -Xms20m -Xmx20m -Xmn15m

```
Heap
 PSYoungGen      total 13824K, used 1475K [0x00000007bf100000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 12288K, 12% used [0x00000007bf100000,0x00000007bf270d20,0x00000007bfd00000)
  from space 1536K, 0% used [0x00000007bfe80000,0x00000007bfe80000,0x00000007c0000000)
  to   space 1536K, 0% used [0x00000007bfd00000,0x00000007bfd00000,0x00000007bfe80000)
 ParOldGen       total 5120K, used 0K [0x00000007bec00000, 0x00000007bf100000, 0x00000007bf100000)
  object space 5120K, 0% used [0x00000007bec00000,0x00000007bec00000,0x00000007bf100000)
 Metaspace       used 2674K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 287K, capacity 386K, committed 512K, reserved 1048576K
```

3. <font color=red>-XX:NewRatio=n</font>

设置老年代与年轻代的比例，默认为2.

> -Xms20m -Xmx20m -XX:NewRatio=4 -XX:+PrintGCDetails

```
Heap
 PSYoungGen      total 3584K, used 961K [0x00000007bfc00000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 3072K, 31% used [0x00000007bfc00000,0x00000007bfcf0420,0x00000007bff00000)
  from space 512K, 0% used [0x00000007bff80000,0x00000007bff80000,0x00000007c0000000)
  to   space 512K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007bff80000)
 ParOldGen       total 16384K, used 0K [0x00000007bec00000, 0x00000007bfc00000, 0x00000007bfc00000)
  object space 16384K, 0% used [0x00000007bec00000,0x00000007bec00000,0x00000007bfc00000)
 Metaspace       used 2673K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 287K, capacity 386K, committed 512K, reserved 1048576K
```

问题：-Xmn 和 -XX:NewRatio都是设置年轻代的大小的，同时设置，它俩谁生效呢？

> -Xms20m -Xmx20m -XX:NewRatio=2 -Xmn15m  -XX:+PrintGCDetails

```
Heap
 PSYoungGen      total 13824K, used 1475K [0x00000007bf100000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 12288K, 12% used [0x00000007bf100000,0x00000007bf270d20,0x00000007bfd00000)
  from space 1536K, 0% used [0x00000007bfe80000,0x00000007bfe80000,0x00000007c0000000)
  to   space 1536K, 0% used [0x00000007bfd00000,0x00000007bfd00000,0x00000007bfe80000)
 ParOldGen       total 5120K, used 0K [0x00000007bec00000, 0x00000007bf100000, 0x00000007bf100000)
  object space 5120K, 0% used [0x00000007bec00000,0x00000007bec00000,0x00000007bf100000)
 Metaspace       used 2673K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 287K, capacity 386K, committed 512K, reserved 1048576K
```

同时设置生效的是-Xmn

4. <font color=red>-XX:SurvivorRatio=n</font>
   设置Eden区与Survivor区的大小比值，默认值为8。

> -Xms20m -Xmx20m -Xmn6m -XX:SurvivorRatio=4 -XX:+PrintGCDetails

```
[GC (System.gc()) [PSYoungGen: 1024K->560K(5120K)] 1024K->568K(19456K), 0.0009209 secs] [Times: user=0.00 sys=0.00, real=0.00 secs] 
[Full GC (System.gc()) [PSYoungGen: 560K->0K(5120K)] [ParOldGen: 8K->398K(14336K)] 568K->398K(19456K), [Metaspace: 2664K->2664K(1056768K)], 0.0033488 secs] [Times: user=0.02 sys=0.00, real=0.01 secs] 
Heap
 PSYoungGen      total 5120K, used 41K [0x00000007bfa00000, 0x00000007c0000000, 0x00000007c0000000)
  eden space 4096K, 1% used [0x00000007bfa00000,0x00000007bfa0a548,0x00000007bfe00000)
  from space 1024K, 0% used [0x00000007bfe00000,0x00000007bfe00000,0x00000007bff00000)
  to   space 1024K, 0% used [0x00000007bff00000,0x00000007bff00000,0x00000007c0000000)
 ParOldGen       total 14336K, used 398K [0x00000007bec00000, 0x00000007bfa00000, 0x00000007bfa00000)
  object space 14336K, 2% used [0x00000007bec00000,0x00000007bec63b28,0x00000007bfa00000)
 Metaspace       used 2670K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 287K, capacity 386K, committed 512K, reserved 1048576K
```

Parallel垃圾收集器会对比例进行自适应分配大小。<br>
只有显式的设置比例，才会是生效，不设置为自适应，默认设置无效。
-XX:+UseAdaptiveSizePolicy 在每次Minor GC之后对From和To区进行自适应分配大小。


-XX:-UseAdaptiveSizePolicy 可以关闭自适应，但是设置了也没效果的。



此处需要注意，如果年轻代太小，自适应是不生效的。设置堆大小为20M，年轻代为10M，SurvivorRatio默认时，eden、from、to为8：1：1.
但当堆更改为200M，年轻代为100M时，eden、from、to的比例就不一定是严格按照默认的。

5. <font color=red>-XX:MetaspaceSize 和 -XX:MaxMetaspaceSize</font>
   
   > 在JDK1.8之前，所有加载的类信息都放在永久代中。JDK1.8开始，永久代被移除，取而代之的是元空间。
* -XX:MetaspaceSize：元空间发生GC的初始阈值；
  
  > -XX:MetaspaceSize 这个参数并非是设置元空间的初始大小，而是设置发生GC的初始阈值。
  > 比如，如果设置-XX:MetaspaceSize为10m，那么当元空间的数据存储量达到10m时，就会发生GC。

* -XX:MaxMetaspaceSize：设置元空间的最大空间大小。
  
  ```
  Heap
  PSYoungGen      total 38400K, used 2663K [0x0000000795580000, 0x0000000798000000, 0x00000007c0000000)
  eden space 33280K, 8% used [0x0000000795580000,0x0000000795819c20,0x0000000797600000)
  from space 5120K, 0% used [0x0000000797b00000,0x0000000797b00000,0x0000000798000000)
  to   space 5120K, 0% used [0x0000000797600000,0x0000000797600000,0x0000000797b00000)
  ParOldGen       total 87552K, used 0K [0x0000000740000000, 0x0000000745580000, 0x0000000795580000)
  object space 87552K, 0% used [0x0000000740000000,0x0000000740000000,0x0000000745580000)
  Metaspace       used 2672K, capacity 4486K, committed 4864K, reserved 1056768K
  class space    used 287K, capacity 386K, committed 512K, reserved 1048576K
  ```



4. <font color=red>-Xss</font>
   
   > 设置单个线程栈大小，一般默认512 - 1024kb。</br>
   > 单个线程栈大小跟操作系统和JDK版本都有关系，因此其默认大小是一个范围值，一般使用默认的大小就能满足需求。</br>
   > 如果在某些个别场景下，单个线程的栈空间发生内存溢出，多数情况是由于迭代的深度达到了栈的最大深度，导致内存溢出。

5. <font color=red>-XX:+PrintFlagsFinal 查看JVM运行时参数</font>
6. <font color=red>-XX:+PrintFlagsInitial 查看JVM初始参数</font>