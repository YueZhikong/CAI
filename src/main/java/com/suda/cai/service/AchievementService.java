package com.suda.cai.service;

import com.suda.cai.dao.AchievementDAO;
import com.suda.cai.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AchievementService {
    @Autowired
    AchievementDAO achievementDAO;
    public void add(Achievement bean){
        achievementDAO.save(bean);
    }
    public void delete(int id){
        achievementDAO.delete(id);
    }
    public Achievement get(int id){
        return achievementDAO.findOne(id);
    }
    public void update(Achievement bean){
        achievementDAO.save(bean);
    }
    public ArrayList<Achievement> findByExamAndClasses(Exam exam,Classes classes){
        return achievementDAO.findByExamAndClasses(exam,classes);
    }
    public Achievement findByStudentAndClassesAndExam(Student student,Classes classes,Exam exam){
        return achievementDAO.findByStudentAndClassesAndExam(student,classes,exam);
    }
}
