package com.suda.cai.dao;

import com.suda.cai.pojo.Chapter;
import com.suda.cai.pojo.Course;
import com.suda.cai.pojo.Knowledgepoint;
import com.suda.cai.pojo.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProblemDAO extends JpaRepository<Problem,Integer> {
    List<Problem> findByCourseAndType(Course course,int type);
    List<Problem> findByChapterAndType(Chapter chapter,int type);
    List<Problem> findByKnowledgepointAndType(Knowledgepoint knowledgepoint,int type);
}
