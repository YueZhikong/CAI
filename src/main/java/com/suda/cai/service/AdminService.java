package com.suda.cai.service;

import com.suda.cai.dao.AdminDAO;
import com.suda.cai.pojo.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    AdminDAO adminDAO;
    public void add(Admin bean){
        adminDAO.save(bean);
    }
    public void delete(int id){
        adminDAO.delete(id);
    }
    public Admin get(int id){
        return adminDAO.findOne(id);
    }
    public void update(Admin bean){
        adminDAO.save(bean);
    }
    public Admin findByNameAndPassword(String name,String password){
        return adminDAO.findByNameAndPassword(name,password);
    }
}
