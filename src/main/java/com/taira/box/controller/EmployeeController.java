package com.taira.box.controller;

import com.taira.box.bean.model.VertificationCode;
import com.taira.box.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.List;
import java.util.Random;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @RequestMapping
    public String jwtIndex() {
        return "employee/index";
    }
    //获取验证码
    @GetMapping(value = "/getCode")
    @ResponseBody
    public Object sendCode(@RequestParam("mobile") String mobile,@RequestParam("isMock") Boolean isMock) {
        String vertifyCode = String.valueOf(new Random().nextInt(899999) + 100000);
        VertificationCode vc = new VertificationCode();
        vc.setMobile(mobile);
        vc.setVcode(vertifyCode);
        vc.setCreateTime(new Date());
        return employeeService.getMobileByEmployee(mobile);
    }

}