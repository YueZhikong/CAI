package com.suda.cai.dao;

import com.suda.cai.pojo.Course;
import com.suda.cai.pojo.Online;
import com.suda.cai.pojo.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface OnlineDAO extends JpaRepository<Online,Integer> {
    ArrayList<Online> findAllByTeacher(Teacher teacher);
    ArrayList<Online> findAllByCourse(Course course);
}
