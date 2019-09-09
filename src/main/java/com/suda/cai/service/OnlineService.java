package com.suda.cai.service;

import com.suda.cai.dao.OnlineDAO;
import com.suda.cai.pojo.Course;
import com.suda.cai.pojo.Knowledgepoint;
import com.suda.cai.pojo.Online;
import com.suda.cai.pojo.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class OnlineService {
    @Autowired
    OnlineDAO onlineDAO;
    public void add(Online bean){
        onlineDAO.save(bean);
    }
    public void delete(int id){
        onlineDAO.delete(id);
    }
    public Online get(int id){
        return onlineDAO.findOne(id);
    }
    public void update(Online bean){
        onlineDAO.save(bean);
    }
    public ArrayList<Online> findByTeacher(Teacher teacher){
        return onlineDAO.findAllByTeacher(teacher);
    }
    public ArrayList<Online> findAllByCourse(Course course){
        return onlineDAO.findAllByCourse(course);
    }
}
