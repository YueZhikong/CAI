package com.suda.cai.dao;

import com.suda.cai.pojo.Classes;
import com.suda.cai.pojo.Material;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MaterialDAO extends JpaRepository<Material,Integer> {
    List<Material> findByClassesOrderByIdDesc(Classes classes);
}
