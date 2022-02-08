package com.srs.java.jvm.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

/**
 * @author shaorensheng
 * @date 2021/11/15
 */
public class Stack {

    static String base = "string";


    /**
     * -Xms50m
     * -Xmx50m
     * -XX:+PrintGCDetails
     * -XX:+HeapDumpOnOutOfMemoryError
     * -XX:HeapDumpPath=/Users/shaorenshengkoolearn-inc.com/Desktop/oom1.log
     *
     * -Xms50m -Xmx50m -XX:+PrintGCDetails -XX:+PrintGCDataStamps -Xloggc:/Users/shaorenshengkoolearn-inc.com/Desktop/oom1.log
     * @param args
     */
    public static void main(String[] args){
        //List<String> list = new ArrayList<>();
        //try {
        //    Thread.sleep(100000L);
        //} catch (InterruptedException e) {
        //    e.printStackTrace();
        //}
        //for (int i = 0; i < Integer.MAX_VALUE; i++) {
        //     String str = base + base;
        //     base = str;
        //     list.add(str.intern());
        //}
        List<String> list = new ArrayList<>();
        while (true) {
            list.add(UUID.randomUUID().toString());
        }
    }

}
