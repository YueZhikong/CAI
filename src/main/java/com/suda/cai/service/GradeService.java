package com.suda.cai.service;

import com.suda.cai.dao.GradeDAO;
import com.suda.cai.pojo.College;
import com.suda.cai.pojo.Grade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    @Autowired
    GradeDAO gradeDAO;
    @Autowired
    CollegeService collegeService;
    public List<Grade> list(){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        return gradeDAO.findAll(sort);
    }

    public List<Grade> listByCollege(int collegeID){
        College college = collegeService.get(collegeID);
        return gradeDAO.findByCollege(college);
    }
    public void add(Grade bean){
        gradeDAO.save(bean);
    }
    public void delete(int id){
        gradeDAO.delete(id);
    }
    public Grade get(int id){
        return gradeDAO.findOne(id);
    }
    public void update(Grade bean){
        gradeDAO.save(bean);
    }
}
