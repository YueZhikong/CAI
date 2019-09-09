package com.suda.cai.service;

import com.suda.cai.dao.CollegeDAO;
import com.suda.cai.pojo.College;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollegeService {
    @Autowired
    CollegeDAO collegeDAO;
    public List<College> list(){
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        return collegeDAO.findAll(sort);
    }
    public College get(int id){
        return collegeDAO.findOne(id);
    }
    public void add(College bean){
        collegeDAO.save(bean);
    }
    public void delete(int id){
        collegeDAO.delete(id);
    }
    public void update(College bean){
        collegeDAO.save(bean);
    }
}
