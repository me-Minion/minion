package com.srs.java.jvm.tuning;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shaorensheng
 * @date 2022/1/13
 */
@RestController
@RequestMapping("/tuning")
public class TuningController {

    @Autowired
    TuningDemo tuningDemo;

    @GetMapping("/hello")
    public String getHello() {
        tuningDemo.stack();
        return "hello";
    }


}
