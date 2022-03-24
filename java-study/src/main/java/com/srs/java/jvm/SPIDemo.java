package com.srs.java.jvm;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ServiceLoader;

/**
 * @author shaorensheng
 * @date 2022/2/11
 */
public class SPIDemo {


    public static void main(String[] args) {
        //ServiceLoader<Driver> load = ServiceLoader.load(Driver.class);
        //System.out.println(load);

        //try {
        //    String name = DriverManager.class.getName();
        //    System.out.println(name);
        //    DriverManager.getConnection("www.baidu.com");
        //
        //} catch (SQLException e) {
        //    e.printStackTrace();
        //}

        Integer i = 10;
        Integer ii = 20;

        if (i < 20 ){
            System.out.println(111);
        } else if (ii < 30) {
            System.out.println(222);
        }
    }

}
