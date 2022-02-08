package com.srs.java.jvm.tuning;

import org.springframework.stereotype.Component;

/**
 * @author shaorensheng
 * @date 2022/1/13
 */
@Component
public class TuningDemo {


    public void stack() {
        int[] ints = new int[1024 * 5];

    }


}
