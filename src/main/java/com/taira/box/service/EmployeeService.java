package com.taira.box.service;

import com.taira.box.bean.model.EmployeeBean;

import java.util.List;

public interface EmployeeService {
   List<EmployeeBean> getMobileByEmployee(String mobile);
}
