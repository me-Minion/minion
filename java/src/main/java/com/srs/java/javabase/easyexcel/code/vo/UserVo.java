package com.srs.java.javabase.easyexcel.code.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author shaorensheng
 * @date 2021/9/17
 */
@Data
public class UserVo {

    @ExcelProperty(value = "符号", index = 0)
    private Integer id;

    @ExcelProperty(value = "姓名", index = 1)
    private String name;

    @ExcelProperty(value = "年龄", index = 2)
    private Integer age;

}
