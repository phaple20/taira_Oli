package com.taira.box.bean.model;

import lombok.Data;

import java.util.Date;

@Data
public class EmployeeBean {
    private Integer id;
    private Integer employeeId;
    private String name;
    private String mobile;
    private Date createTime;
    private Date updateTime;
}