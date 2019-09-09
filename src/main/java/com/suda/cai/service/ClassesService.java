package com.suda.cai.service;

import com.suda.cai.dao.ClassesDAO;
import com.suda.cai.pojo.Classes;
import com.suda.cai.pojo.College;
import com.suda.cai.pojo.Course;
import com.suda.cai.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesService {
    @Autowired
    ClassesDAO classesDAO;
    @Autowired
    CollegeService collegeService;
    @Autowired
    CourseService courseService;
    public List<Classes> listByCourseAndCollege(int courseID,int collegeID){
        Course course = courseService.get(courseID);
        College college = collegeService.get(collegeID);

        return classesDAO.findByCourseAndCollege(course,college);
    }
    public List<Classes> findByTeacher(Teacher teacher){
        return classesDAO.findByTeacher(teacher);
    }
    public void add(Classes bean){
        classesDAO.save(bean);
    }
    public void delete(int id){
        classesDAO.delete(id);
    }
    public Classes get(int id){
        return classesDAO.findOne(id);
    }
    public void update(Classes bean){
        classesDAO.save(bean);
    }
}
