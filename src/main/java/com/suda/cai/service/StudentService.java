package com.suda.cai.service;

import com.suda.cai.dao.StudentDAO;
import com.suda.cai.pojo.College;
import com.suda.cai.pojo.Student;
import com.suda.cai.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class StudentService {
    @Autowired
    StudentDAO studentDAO;
    public void add(Student bean){
        studentDAO.save(bean);
    }
    public void delete(int id){
        studentDAO.delete(id);
    }
    public Student get(int id){
        return studentDAO.findOne(id);
    }
    public void update(Student bean){
        studentDAO.save(bean);
    }
    public Student getByStuid(int stuid){
        return studentDAO.getByStuid(stuid);
    }
    public List<Student> findByStuid(int stuid){
        return  studentDAO.findByStuidOrderByIdDesc(stuid);
    }
    public Student findByStuidAndPassword(int stuid,String password){
        return studentDAO.findByStuidAndPassword(stuid,password);
    }
    public ArrayList<Student> findAllByCollege(College college){
        return studentDAO.findAllByCollege(college);
    }
}
