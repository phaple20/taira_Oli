package com.taira.box.bean.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

@Data
public class ExcelUploadBean extends BaseRowModel {
    @ExcelProperty(value = {"主键ID"}, index = 0)
    private Integer id;
    @ExcelProperty(value = {"用户姓名"}, index = 1)
    private String name;
    @ExcelProperty(value = {"用户年龄"}, index = 2)
    private Integer age;

    public ExcelUploadBean() {

    }
    public ExcelUploadBean(int id, String name, int age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }
}
