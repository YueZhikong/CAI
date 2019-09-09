package com.suda.cai.dao;

import com.suda.cai.pojo.Achievement;
import com.suda.cai.pojo.Classes;
import com.suda.cai.pojo.Exam;
import com.suda.cai.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface AchievementDAO extends JpaRepository<Achievement,Integer> {
    ArrayList<Achievement> findByExamAndClasses(Exam exam, Classes classes);
    Achievement findByStudentAndClassesAndExam(Student student,Classes classes,Exam exam);

}
