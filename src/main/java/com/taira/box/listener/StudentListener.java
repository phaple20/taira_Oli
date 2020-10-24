package com.taira.box.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.taira.box.domain.Student;

import java.util.List;

public class StudentListener extends AnalysisEventListener<Student> {

    private List<Object> datas;

    @Override
    public void invoke(Student student, AnalysisContext analysisContext) {
        System.out.println("student="+student);
    }
    
    public List<Object> getDatas() {
        return datas;
    }

    public void setDatas(List<Object> datas) {
        this.datas=datas;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
