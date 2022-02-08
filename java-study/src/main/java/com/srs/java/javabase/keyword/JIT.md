# JIT

## HSDIS 
 
 将hsdis-amd64.dylib 放入java安装路径jre/lib/server中
 
 查看hsdis是否工作
 > java -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -version
 
 执行反汇编命令
 ```
-Xcomp # 使用纯编译模式，执行很快，启动很慢。
-XX:+UnlockDiagnosticVMOptions #解锁诊断参数
-XX:+LogCompilation # JIT编译日志输出
-XX:+PrintAssembly # 打印java运行过程中的汇编
-XX:LogFile=jit.log # 日志输出地址（这么写文件生成在项目名下）
 ```
 
## JITWatch
<font color="red">JITWatch依赖HSDIS</font>

git地址: 
> git@github.com:AdoptOpenJDK/jitwatch.git

代码下载完成后，需要编译后才能使用。参照项目下QUICKSTART.txt按照步骤执行即可。

mac使用时如果遇到问题：
1. 类找不到，需要修改launchUI.sh脚本
2. 主方法找不到，也需要修改launchUI.sh脚本
脚本中添加如下代码：
```
CLASSPATH=$CLASSPATH:/Library/1tools/apache-maven-3.6.2/maven-repository/com/chrisnewland/FreeLogJ/0.0.1/FreeLogJ-0.0.1.jar
CLASSPATH=$CLASSPATH:ui/target/jitwatch-ui-1.4.4.jar
CLASSPATH=$CLASSPATH:core/target/jitwatch-core-1.4.4.jar
```
3. 启动后，界面乱码(默认启动是中文的)，需要修改ui/resources/i18n中lang_zh.properties文件。
将中文全部转为unicode，重新编译，即可正常启动。
4. 傻瓜式使用方式：编译后，在ui模块中找到org.adoptopenjdk.jitwatch.launch.LaunchUI类，直接启动，可以忽略掉问题1和2。
5. 启动时，最好把-Xms和-Xmx设置的大点，不然容易OOM。




