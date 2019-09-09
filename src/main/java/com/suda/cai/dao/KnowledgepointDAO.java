package com.suda.cai.dao;

import com.suda.cai.pojo.Chapter;
import com.suda.cai.pojo.Knowledgepoint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KnowledgepointDAO extends JpaRepository<Knowledgepoint,Integer> {
    List<Knowledgepoint> findByChapter(Chapter chapter);
}
