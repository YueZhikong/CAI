package com.suda.cai.service;

import com.suda.cai.dao.VideoDAO;
import com.suda.cai.pojo.*;
import com.suda.cai.pojo.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class VideoService {
    @Autowired
    VideoDAO videoDAO;
    public void add(Video bean){
        videoDAO.save(bean);
    }
    public void delete(int id){
        videoDAO.delete(id);
    }
    public Video get(int id){
        return videoDAO.findOne(id);
    }
    public void update(Video bean){
        videoDAO.save(bean);
    }
    public ArrayList<Video> findAllByOnlineAndKnowledgepoint(Online online, Knowledgepoint knowledgepoint){
        return videoDAO.findAllByOnlineAndKnowledgepoint(online,knowledgepoint);
    }
    public Video findAllByOnlineAndKnowledgepointAndTeacher(Online online, Knowledgepoint knowledgepoint, Teacher teacher){
        return videoDAO.findAllByOnlineAndKnowledgepointAndTeacher(online,knowledgepoint,teacher);
    }
    public ArrayList<Video> findAllByKnowledgepoint(Knowledgepoint knowledgepoint){
        return videoDAO.findAllByKnowledgepoint(knowledgepoint);
    }
}
