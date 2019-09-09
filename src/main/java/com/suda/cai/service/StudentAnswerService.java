package com.suda.cai.service;

import com.suda.cai.dao.StudentAnswerDAO;
import com.suda.cai.pojo.Classes;
import com.suda.cai.pojo.Exam;
import com.suda.cai.pojo.Student;
import com.suda.cai.pojo.StudentAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class StudentAnswerService {
    @Autowired
    StudentAnswerDAO studentAnswerDAO;
    public void add(StudentAnswer bean){
        studentAnswerDAO.save(bean);
    }
    public void delete(int id){
        studentAnswerDAO.delete(id);
    }
    public StudentAnswer get(int id){
        return studentAnswerDAO.findOne(id);
    }
    public void update(StudentAnswer bean){
        studentAnswerDAO.save(bean);
    }
    public ArrayList<StudentAnswer> findByExamAndStudentAndClasses(Exam exam, Student student, Classes classes){
        return studentAnswerDAO.findByExamAndStudentAndClasses(exam,student,classes);
    }
    public ArrayList<StudentAnswer> findByExamAndStudentAndClassesAndType(Exam exam,Student student,Classes classes,int type){
        return studentAnswerDAO.findByExamAndStudentAndClassesAndType(exam, student, classes, type);
    }
}
