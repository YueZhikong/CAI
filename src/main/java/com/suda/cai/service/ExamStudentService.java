package com.suda.cai.service;

import com.suda.cai.dao.ExamStudentDAO;
import com.suda.cai.pojo.Classes;
import com.suda.cai.pojo.Exam;
import com.suda.cai.pojo.ExamStudent;
import com.suda.cai.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ExamStudentService {
    @Autowired
    ExamStudentDAO examStudentDAO;
    public void add(ExamStudent bean){
        examStudentDAO.save(bean);
    }
    public void delete(int id){
        examStudentDAO.delete(id);
    }
    public ExamStudent get(int id){
        return examStudentDAO.findOne(id);
    }
    public void update(ExamStudent bean){
        examStudentDAO.save(bean);
    }
    public ExamStudent findByExamAndClassesAndStudent(Exam exam, Classes classes, Student student){
        return examStudentDAO.findByExamAndClassesAndStudent(exam,classes,student);
    }
    public ArrayList<ExamStudent> findByStudentAndClasses(Student student,Classes classes){
        return examStudentDAO.findByStudentAndClassesOrderByIdDesc(student,classes);
    }
    public ArrayList<ExamStudent> findByExamAndClasses(Exam exam,Classes classes){
        return examStudentDAO.findByExamAndClasses(exam,classes);
    }
}
