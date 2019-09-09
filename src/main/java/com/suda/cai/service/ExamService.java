package com.suda.cai.service;

import com.suda.cai.dao.ExamDAO;
import com.suda.cai.pojo.Course;
import com.suda.cai.pojo.Exam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {
    @Autowired
    ExamDAO examDAO;
    public void add(Exam bean){
        examDAO.save(bean);
    }
    public void delete(int id){
        examDAO.delete(id);
    }
    public Exam get(int id){
        return examDAO.findOne(id);
    }
    public void update(Exam bean){
        examDAO.save(bean);
    }
    public List<Exam> findByCourse(Course course){
        return examDAO.findByCourse(course);
    }
}
