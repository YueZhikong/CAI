package com.suda.cai.dao;

import com.suda.cai.pojo.Chapter;
import com.suda.cai.pojo.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ChapterDAO extends JpaRepository<Chapter,Integer> {
    List<Chapter> findByCourse(Course course);
}
