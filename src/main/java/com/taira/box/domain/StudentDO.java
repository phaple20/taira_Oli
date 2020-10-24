package com.taira.box.domain;

import com.alibaba.excel.annotation.ExcelProperty;

public class StudentDO {
    @ExcelProperty("姓名")
    private String name;
    @ExcelProperty("学号")
    private String number;

    public StudentDO(String name,String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String toString() {
        return "StudentDO{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
