package com.suda.cai.dao;

import com.suda.cai.pojo.Course;
import com.suda.cai.pojo.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamDAO extends JpaRepository<Exam,Integer> {
    List<Exam> findByCourse(Course course);
}
