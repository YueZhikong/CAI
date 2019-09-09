package com.suda.cai.dao;

import com.suda.cai.pojo.College;
import com.suda.cai.pojo.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeDAO extends JpaRepository<Grade,Integer> {
    List<Grade> findByCollege(College college);
}
