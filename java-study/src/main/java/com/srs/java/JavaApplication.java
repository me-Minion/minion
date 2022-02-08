package com.srs.java;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * -XX:+PrintGC
 * -XX:+PrintGCDetails
 * -XX:+PrintGCTimeStamps
 * -XX:+PrintGCDateStamps
 * -Xloggc:/Users/shaorenshengkoolearn-inc.com/Desktop/exam-webapp.log
 *
 *
 * -XX:+UseG1GC
 * -XX:+UseConcMarkSweepGC
 */
@SpringBootApplication(scanBasePackages = "com.srs.java")
public class JavaApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaApplication.class, args);
    }

}
