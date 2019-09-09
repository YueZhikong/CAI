package com.suda.cai.service;

import com.suda.cai.dao.ExamContentDAO;
import com.suda.cai.pojo.Exam;
import com.suda.cai.pojo.ExamContent;
import com.suda.cai.pojo.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ExamContentService {
    @Autowired
    ExamContentDAO examContentDAO;
    public void add(ExamContent bean){
        examContentDAO.save(bean);
    }
    public void delete(int id){
        examContentDAO.delete(id);
    }
    public ExamContent get(int id){
        return examContentDAO.findOne(id);
    }
    public void update(ExamContent bean){
        examContentDAO.save(bean);
    }
    public ArrayList<ExamContent> findByExamAndType(Exam exam, int type){
        return examContentDAO.findByExamAndType(exam,type);
    }
    public ExamContent findByExamAndProblem(Exam exam, Problem problem){
        return examContentDAO.findByExamAndProblem(exam,problem);
    }
    public ArrayList<ExamContent> findByExam(Exam exam){
        return examContentDAO.findByExam(exam);
    }
}
