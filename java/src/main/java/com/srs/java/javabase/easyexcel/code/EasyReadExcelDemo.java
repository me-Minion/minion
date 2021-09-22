package com.srs.java.javabase.easyexcel.code;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson.JSONObject;
import com.srs.java.javabase.easyexcel.code.vo.UserVo;
import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * @author shaorensheng
 * @date 2021/9/17
 */
@Slf4j
public class EasyReadExcelDemo {
    public static void main(String[] args) {
        String path = "/Users/shaorenshengkoolearn-inc.com/Desktop/1.xlsx";
        List<List<String>> lists = readExcel(path);
        List<UserVo> userVos = readExcelByVo(path);
        log.info(JSONObject.toJSONString(lists));
        log.info(JSONObject.toJSONString(userVos));
    }


    /**
     * 统一返回List<List<String>>
     * @param path
     * @return
     */
    public static List<List<String>> readExcel(String path) {
        try {
            FileInputStream inputStream = new FileInputStream(path);
            MyLinstener myLinstener = new MyLinstener();
            //读取所有的sheet
            EasyExcel.read(inputStream, UserVo.class, myLinstener).doReadAll();
            return myLinstener.getDatas();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * vo接收数据
     * @param path
     * @return
     */
    public static List<UserVo> readExcelByVo(String path) {
        try {
            FileInputStream inputStream = new FileInputStream(path);
            MyPOJOLinstener myLinstener = new MyPOJOLinstener();
            EasyExcel.read(inputStream, UserVo.class, myLinstener).doReadAll();
            return myLinstener.getDatas();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
