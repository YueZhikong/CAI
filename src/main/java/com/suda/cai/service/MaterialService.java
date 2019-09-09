package com.suda.cai.service;

import com.suda.cai.dao.MaterialDAO;
import com.suda.cai.pojo.Classes;
import com.suda.cai.pojo.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {
    @Autowired
    MaterialDAO materialDAO;
    public void add(Material bean){
        materialDAO.save(bean);
    }
    public void delete(int id){
        materialDAO.delete(id);
    }
    public Material get(int id){
        return materialDAO.findOne(id);
    }
    public void update(Material bean){
        materialDAO.save(bean);
    }
    public List<Material> findByClasses(Classes classes){
        return materialDAO.findByClassesOrderByIdDesc(classes);
    }
}
