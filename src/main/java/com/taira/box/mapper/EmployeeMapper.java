package com.taira.box.mapper;

import com.taira.box.bean.model.EmployeeBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface EmployeeMapper {
    List<EmployeeBean> getMobileByEmployee(String mobile);
}
