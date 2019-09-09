package com.suda.cai.dao;

import com.suda.cai.pojo.Assignment;
import com.suda.cai.pojo.Classes;
import com.suda.cai.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentDAO extends JpaRepository<Assignment,Integer> {
    Assignment findByClassesAndStudentAndWeek(Classes classes, Student student, int week);
    List<Assignment> findByClassesAndStudentOrderByWeekAsc(Classes classes,Student student);
    List<Assignment> findByClassesAndWeek(Classes classes,int week);
}
