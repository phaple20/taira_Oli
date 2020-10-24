package com.taira.box.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.taira.box.bean.model.ExcelUploadBean;
import com.taira.box.domain.Student;
import com.taira.box.listener.StudentListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/excel")
public class ExcelController {
    @GetMapping(value = "/excelManage")
    public ModelAndView excel() {
        ModelAndView mv = new ModelAndView("index/excel_event");
        ExcelUploadBean eub = new ExcelUploadBean();
        return mv;
    }
    @RequestMapping(value = "/exportExcel")
    @ResponseBody
    public void export(HttpServletResponse response) throws IOException {
        //测试导出Excel
        System.out.println("export---------------------------->");
        List<ExcelUploadBean> eb = new ArrayList<ExcelUploadBean>();
        ExcelUploadBean ub_1 = new ExcelUploadBean(1,"annie",18);
        ExcelUploadBean ub_2 = new ExcelUploadBean(2,"Sam",19);
        ExcelUploadBean ub_3 = new ExcelUploadBean(3,"Lucifer",23);
        eb.add(ub_1);
        eb.add(ub_2);
        eb.add(ub_3);
        ServletOutputStream out = response.getOutputStream();
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);
        String fileName = "测试testexportExcel";
        Sheet sheet = new Sheet(1,0,ExcelUploadBean.class);
        sheet.setAutoWidth(Boolean.TRUE);
        sheet.setSheetName("第一个sheet");
        writer.write(eb, sheet);
        response.setHeader("Content-disposition", "attachment;filename=" + new String( fileName.getBytes("gb2312"), "ISO8859-1" ) + ".xlsx");
        writer.finish();
        response.setContentType("multipart/form-data");
        response.setCharacterEncoding("utf-8");
        out.flush();
    }
    @RequestMapping(value = "/parseExcel")
    @ResponseBody
    public void getTemplate(@RequestParam("file") MultipartFile file, HttpServletResponse response) throws IOException {
        //System.out.println(file.getOriginalFilename());
        //导入
        ExcelReader excelReader = new ExcelReader(file.getInputStream(),ExcelTypeEnum.XLSX,null,new StudentListener());
        excelReader.read(new Sheet(1,1,Student.class));
        List<Object> datas = new StudentListener().getDatas();
        System.out.println(datas);
        //导出
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        //防止中文乱码
        String fileName = URLEncoder.encode("OutputExcel文件","UTF-8");
        response.setHeader("Content-disposition", "attachment;filename*=UTF-8''" + fileName + ".xlsx");
        ServletOutputStream outputStream = response.getOutputStream();
        ExcelWriterBuilder writerBuilder = EasyExcel.write(outputStream, Student.class);
        ExcelWriterSheetBuilder writeSheet = writerBuilder.sheet();
        List<Student> students = new ArrayList<Student>();
        //demo data
        for (int a = 0;a<10;a++) {
            Student data = new Student();
            data.setName("热血高校学号" + a);
            data.setGender("女");
            data.setBirthday(new Date());
            students.add(data);
        }
        writeSheet.doWrite(students);
    }
}
