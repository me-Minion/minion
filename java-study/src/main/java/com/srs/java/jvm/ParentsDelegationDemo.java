package com.srs.java.jvm;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.ServiceLoader;
import java.util.logging.Logger;

/**
 * @author shaorensheng
 * @date 2022/2/10
 */
public class ParentsDelegationDemo implements Driver {


    public static void main(String[] args) {
        //ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        //System.out.println(systemClassLoader);
        //A a = new A(new B());
        //System.out.println(a.getClass().getClassLoader());
        //ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        //Class<?> aClass = null;
        //try {
        //    aClass = Class.forName("java.sql.Driver", false, contextClassLoader);
        //} catch (ClassNotFoundException e) {
        //    e.printStackTrace();
        //}
        //System.out.println(B.class.getName());
        //System.out.println(aClass == Driver.class);
        //System.out.println(Driver.class.getClassLoader());
        //
        //
        //Thread.currentThread().setContextClassLoader(contextClassLoader);

        //try {
        //    Class<?> aClass = Class.forName("com.mysql.jdbc.Driver");
        //} catch (ClassNotFoundException e) {
        //    e.printStackTrace();
        //}

        try {
            //ClassLoader classLoader = DriverManager.class.getClassLoader();
            //ClassLoader classLoader1 = A.class.getClassLoader();
            //System.out.println(classLoader);
            //System.out.println(classLoader1);
            Connection connection = DriverManager.getConnection("www.baidu.com");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


    @Override
    public Connection connect(String url, Properties info) throws SQLException {
        return null;
    }

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return false;
    }

    @Override
    public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
        return new DriverPropertyInfo[0];
    }

    @Override
    public int getMajorVersion() {
        return 0;
    }

    @Override
    public int getMinorVersion() {
        return 0;
    }

    @Override
    public boolean jdbcCompliant() {
        return false;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
