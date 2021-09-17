package com.srs.java.javabase.easyexcel.code;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author shaorensheng
 * @date 2021/9/17
 */
@Slf4j
public class EasyExcelDemo {
    public static void main(String[] args) {
        String path = "/Users/shaorenshengkoolearn-inc.com/Desktop/1.xlsx";
        List<List<String>> lists = readExcel(path);
        log.info(JSONObject.toJSONString(lists));
    }


    public static List<List<String>> readExcel(String path) {
        try {
            FileInputStream inputStream = new FileInputStream(path);
            MyLinstener myLinstener = new MyLinstener();
            EasyExcel.read(inputStream, myLinstener).doReadAll();
            return myLinstener.getDatas();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
