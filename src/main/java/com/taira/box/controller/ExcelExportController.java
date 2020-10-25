package com.taira.box.controller;

import com.taira.box.domain.StudentDO;
import com.taira.box.util.ExcelUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ExcelExportController {
    @GetMapping("/exportexcel")
    @ResponseBody
    public void exportexcel(HttpServletResponse response) throws IOException {
        List<StudentDO> list = new ArrayList<>();
        list.add(new StudentDO("Annie","001"));
        list.add(new StudentDO("Sam","002"));
        list.add(new StudentDO("Lucifer","003"));
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename="+"testExcel.xls");
        ExcelUtil.writeExcel(response, list);
    }
}