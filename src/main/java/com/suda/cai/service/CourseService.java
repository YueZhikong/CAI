package com.suda.cai.service;

import com.suda.cai.dao.CourseDAO;
import com.suda.cai.pojo.College;
import com.suda.cai.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseDAO courseDAO;
    public List<Course> list(){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        return courseDAO.findAll(sort);
    }
    public void add(Course bean){
        courseDAO.save(bean);
    }
    public void delete(int id){
        courseDAO.delete(id);
    }
    public Course get(int id){
        return courseDAO.findOne(id);
    }
    public void update(Course bean){
        courseDAO.save(bean);
    }
    public ArrayList<Course> findAllByCollege(College college){
        return courseDAO.findAllByCollege(college);
    }
}
