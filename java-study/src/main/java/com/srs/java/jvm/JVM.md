# JVM

## 跟踪垃圾回收

1. +XX:-PrintGC
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
2. +XX:-PrintGCDetails
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
-  **PSYoungGen：代表了「年轻代」的回收；**
-  **PSYoungGen：「老年代」；**
-  **Metaspace：「元空间」。**

3. +XX:-PrintHeapAtGC
4. +XX:-PrintGCTimeStamps


## 跟踪类的加载和卸载

