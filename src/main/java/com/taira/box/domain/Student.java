package com.taira.box.domain;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.util.Date;

@Data
public class Student extends BaseRowModel {
    @ExcelProperty(value = {"学生姓名"},index = 0)
    private String name;
    @ExcelProperty(value = {"学生性别"},index = 1)
    private String gender;
    @ExcelProperty(value = {"学生出生日期"},index = 2)
    private Date birthday;
}
