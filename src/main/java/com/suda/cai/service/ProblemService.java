package com.suda.cai.service;

import com.suda.cai.dao.ProblemDAO;
import com.suda.cai.pojo.Chapter;
import com.suda.cai.pojo.Course;
import com.suda.cai.pojo.Knowledgepoint;
import com.suda.cai.pojo.Problem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProblemService {
    @Autowired
    ProblemDAO problemDAO;
    public void add(Problem bean){
        problemDAO.save(bean);
    }
    public void delete(int id){
        problemDAO.delete(id);
    }
    public Problem get(int id){
        return problemDAO.findOne(id);
    }
    public void update(Problem bean){
        problemDAO.save(bean);
    }
    public List<Problem>  findByCourse(Course course,int type){
        return problemDAO.findByCourseAndType(course, type);
    }
    public List<Problem> findByChapter(Chapter chapter,int type){
        return problemDAO.findByChapterAndType(chapter,type);
    }
    public List<Problem> findByKnowledgepoint(Knowledgepoint knowledgepoint,int type){
        return problemDAO.findByKnowledgepointAndType(knowledgepoint, type);
    }
}
