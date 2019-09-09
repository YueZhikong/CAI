package com.suda.cai.service;

import com.suda.cai.dao.KnowledgepointDAO;
import com.suda.cai.pojo.Chapter;
import com.suda.cai.pojo.Knowledgepoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KnowledgepointService {
    @Autowired
    KnowledgepointDAO knowledgepointDAO;
    public void add(Knowledgepoint bean){
        knowledgepointDAO.save(bean);
    }
    public void delete(int id){
        knowledgepointDAO.delete(id);
    }
    public Knowledgepoint get(int id){
        return knowledgepointDAO.findOne(id);
    }
    public void update(Knowledgepoint bean){
        knowledgepointDAO.save(bean);
    }
    public List<Knowledgepoint> findByChapter(Chapter chapter){
        return knowledgepointDAO.findByChapter(chapter);
    }
}
