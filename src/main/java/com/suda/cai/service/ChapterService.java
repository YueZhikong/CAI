package com.suda.cai.service;

import com.suda.cai.dao.ChapterDAO;
import com.suda.cai.pojo.Chapter;
import com.suda.cai.pojo.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterService {
    @Autowired
    ChapterDAO chapterDAO;
    public List<Chapter> findByCourse(Course course){
        return chapterDAO.findByCourse(course);
    }
    public void add(Chapter bean){
        chapterDAO.save(bean);
    }
    public void delete(int id){
        chapterDAO.delete(id);
    }
    public Chapter get(int id){
        return chapterDAO.findOne(id);
    }
    public void update(Chapter bean){
        chapterDAO.save(bean);
    }
}
