package com.suda.cai.dao;

import com.suda.cai.pojo.College;
import com.suda.cai.pojo.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.List;

public interface TeacherDAO extends JpaRepository<Teacher,Integer> {
    Teacher getByNameAndPassword(String name,String password);
    Teacher getByName(String name);
    Teacher getByPassword(String password);
    Teacher getByIdAndPassword(int id, String password);
    ArrayList<Teacher> findAllByCollege(College college);
}
