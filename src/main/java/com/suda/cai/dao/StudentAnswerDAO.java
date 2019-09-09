package com.suda.cai.dao;

import com.suda.cai.pojo.Classes;
import com.suda.cai.pojo.Exam;
import com.suda.cai.pojo.Student;
import com.suda.cai.pojo.StudentAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface StudentAnswerDAO extends JpaRepository<StudentAnswer,Integer> {
    ArrayList<StudentAnswer> findByExamAndStudentAndClasses(Exam exam, Student student, Classes classes);
    ArrayList<StudentAnswer> findByExamAndStudentAndClassesAndType(Exam exam,Student student,Classes classes, int type);
}
