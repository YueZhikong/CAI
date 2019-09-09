package com.suda.cai.service;

import com.suda.cai.dao.StudentToClassesDAO;
import com.suda.cai.pojo.Classes;
import com.suda.cai.pojo.Student;
import com.suda.cai.pojo.StudentToClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentToClassesService {
    @Autowired
    StudentToClassesDAO studentToClassesDAO;
    public List<StudentToClasses> findByClasses(Classes classes){
        return studentToClassesDAO.findByClasses(classes);
    }
    public List<StudentToClasses> findByStudentAndClasses(Student student, Classes classes){
        return studentToClassesDAO.findByStudentAndClasses(student,classes);
    }
    public void add(StudentToClasses bean){
        studentToClassesDAO.save(bean);
    }
    public void delete(int id){
        studentToClassesDAO.delete(id);
    }
    public StudentToClasses get(int id){
        return studentToClassesDAO.findOne(id);
    }
    public void update(StudentToClasses bean){
        studentToClassesDAO.save(bean);
    }
    public StudentToClasses getAllByStudentAndClasses(Student student,Classes classes){
        return studentToClassesDAO.getAllByStudentAndClasses(student,classes);
    }
    public ArrayList<StudentToClasses> findAllByStudent(Student student){
        return studentToClassesDAO.findAllByStudent(student);
    }
}
