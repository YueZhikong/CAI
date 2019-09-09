package com.suda.cai.dao;

import com.suda.cai.pojo.College;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CollegeDAO extends JpaRepository<College,Integer> {
}
