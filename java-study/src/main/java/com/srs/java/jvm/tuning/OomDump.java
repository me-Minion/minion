package com.srs.java.jvm.tuning;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * @author shaorensheng
 * @date 2022/1/14
 */
@Component
public class OomDump {

    @Override
    protected void finalize() throws Throwable {
        //super.finalize();
        System.out.println("OOM");
    }

    /**
     * JVM 参数
     * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/shaorenshengkoolearn-inc.com/Desktop/oom.log
     */
    public void oom() {
        List<Object> lists = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (true) {
            lists.add(new OomObject(i++, UUID.randomUUID().toString()));
        }
    }

    public static void main(String[] args) {
        //OomDump dump = new OomDump();
        //dump.oom();

        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> collect = integers.stream().filter(x -> x > 7).map(x -> x).collect(Collectors.toList());
        System.out.println(collect);


    }

}
