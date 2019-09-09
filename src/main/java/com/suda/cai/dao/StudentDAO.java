package com.suda.cai.dao;

import com.suda.cai.pojo.College;
import com.suda.cai.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.ArrayList;
import java.util.List;

public interface StudentDAO extends JpaRepository<Student,Integer> {
    Student getByStuid(int stuid);
    List<Student> findByStuidOrderByIdDesc(int stuid);
    Student findByStuidAndPassword(int stuid,String password);
    ArrayList<Student> findAllByCollege(College college);
}
