package com.suda.cai.service;

import com.suda.cai.dao.TeacherDAO;
import com.suda.cai.pojo.College;
import com.suda.cai.pojo.Teacher;
import com.suda.cai.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeacherService {
    @Autowired
    TeacherDAO teacherDAO;

    public Page4Navigator<Teacher> list(int start, int size, int navigatePages){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(start,size,sort);
        Page pageFromJPA = teacherDAO.findAll(pageable);
        return new Page4Navigator<>(pageFromJPA,navigatePages);
    }
    public void add(Teacher bean){
        teacherDAO.save(bean);
    }
    public void delete(int id){
        teacherDAO.delete(id);
    }
    public Teacher get(int id){
        return teacherDAO.findOne(id);
    }
    public Teacher getByNameAndPassword(String name,String password){
        return teacherDAO.getByNameAndPassword(name,password);
    }
    public Teacher getByName(String name){
        return teacherDAO.getByName(name);
    }
    public Teacher getByPassword(String password){
        return teacherDAO.getByPassword(password);
    }
    public List<Teacher> list(){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        return teacherDAO.findAll(sort);
    }
    public Teacher getByIdAndPassword(int id, String password){
        return teacherDAO.getByIdAndPassword(id,password);
    }

    public ArrayList<Teacher> findAllByCollege(College college){
        return teacherDAO.findAllByCollege(college);
    }
}
