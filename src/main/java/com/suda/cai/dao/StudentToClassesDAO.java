package com.suda.cai.dao;

import com.suda.cai.pojo.Classes;
import com.suda.cai.pojo.Student;
import com.suda.cai.pojo.StudentToClasses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface StudentToClassesDAO extends JpaRepository<StudentToClasses,Integer> {
    List<StudentToClasses> findByClasses(Classes classes);
    List<StudentToClasses> findByStudentAndClasses(Student student,Classes classes);
    StudentToClasses getAllByStudentAndClasses(Student student,Classes classes);
    ArrayList<StudentToClasses> findAllByStudent(Student student);
}
