package com.suda.cai.dao;

import com.suda.cai.pojo.Classes;
import com.suda.cai.pojo.College;
import com.suda.cai.pojo.Course;
import com.suda.cai.pojo.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClassesDAO extends JpaRepository<Classes,Integer> {
    List<Classes> findByCourseAndCollege(Course course,College college);
    List<Classes> findByTeacher(Teacher teacher);
}
