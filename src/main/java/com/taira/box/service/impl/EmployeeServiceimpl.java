package com.taira.box.service.impl;

import com.taira.box.bean.model.EmployeeBean;
import com.taira.box.mapper.EmployeeMapper;
import com.taira.box.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service()
public class EmployeeServiceimpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    @Override
    public List<EmployeeBean> getMobileByEmployee(String mobile) {
        return employeeMapper.getMobileByEmployee(mobile);
    }
}
