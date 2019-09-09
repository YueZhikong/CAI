package com.suda.cai.dao;

import com.suda.cai.pojo.Classes;
import com.suda.cai.pojo.Exam;
import com.suda.cai.pojo.ExamStudent;
import com.suda.cai.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ExamStudentDAO extends JpaRepository<ExamStudent,Integer> {
    ExamStudent findByExamAndClassesAndStudent(Exam exam, Classes classes, Student student);
    ArrayList<ExamStudent> findByStudentAndClassesOrderByIdDesc(Student student,Classes classes);
    ArrayList<ExamStudent> findByExamAndClasses(Exam exam,Classes classes);
}
