package com.taira.box.util;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.taira.box.domain.StudentDO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ExcelUtil {
    public static void writeExcel(HttpServletResponse response, List<StudentDO> list) throws IOException {
        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream()).build();
        WriteSheet sheet = EasyExcel.writerSheet(0,"sheet").head(StudentDO.class).build();
        excelWriter.write(list, sheet);
        excelWriter.finish();
    }
}
