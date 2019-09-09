package com.suda.cai.service;

import com.suda.cai.dao.AssignmentDAO;
import com.suda.cai.pojo.Assignment;
import com.suda.cai.pojo.Classes;
import com.suda.cai.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {
    @Autowired
    AssignmentDAO assignmentDAO;
    public void add(Assignment bean){
        assignmentDAO.save(bean);
    }
    public void delete(int id){
        assignmentDAO.delete(id);
    }
    public Assignment get(int id){
        return assignmentDAO.findOne(id);
    }
    public void update(Assignment bean){
        assignmentDAO.save(bean);
    }
    public Assignment findByClassesAndStudentAndWeek(Classes classes, Student student,int week){
        return assignmentDAO.findByClassesAndStudentAndWeek(classes,student,week);
    }
    public List<Assignment> findByClassesAndStudent(Classes classes, Student student){
        return assignmentDAO.findByClassesAndStudentOrderByWeekAsc(classes,student);
    }
    public List<Assignment> findByClassesAndWeek(Classes classes,int week){
        return assignmentDAO.findByClassesAndWeek(classes,week);
    }
}
