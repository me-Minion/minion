package com.srs.java.javabase.easyexcel.code;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.srs.java.javabase.easyexcel.code.vo.UserVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shaorensheng
 * @date 2021/9/17
 */
public class EasyExportExcelDemo {



    public static void main(String[] args) {
        List<UserVo> userVoList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            UserVo vo = new UserVo();
            vo.setId(i);
            vo.setName("第" + i + "季");
            vo.setAge((int) Math.round(100d));
            userVoList.add(vo);
        }
        String file = "/Users/shaorenshengkoolearn-inc.com/Desktop/11.xlsx";
        //此处对象是表头
        ExcelWriterBuilder write = EasyExcelFactory.write(file, userVoList.get(0).getClass());
        write.registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).sheet("第一个").doWrite(userVoList);
    }

    public static  <T> T exportFile (String filePath, List<T> datas, String sheetName) {
        ExcelWriterBuilder write = EasyExcelFactory.write(filePath, datas.get(0).getClass());
        write.registerWriteHandler(new LongestMatchColumnWidthStyleStrategy()).sheet(sheetName).doWrite(datas);
        return null;
    }

}
