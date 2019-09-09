package com.suda.cai.dao;

import com.suda.cai.pojo.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDAO extends JpaRepository<Admin,Integer> {
    Admin findByNameAndPassword(String name,String password);
}
