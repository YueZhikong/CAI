package com.suda.cai.dao;

import com.suda.cai.pojo.College;
import com.suda.cai.pojo.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface CourseDAO extends JpaRepository<Course,Integer> {
    ArrayList<Course> findAllByCollege(College college);
}
