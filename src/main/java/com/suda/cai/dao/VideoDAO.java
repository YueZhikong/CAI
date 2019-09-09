package com.suda.cai.dao;

import com.suda.cai.pojo.Knowledgepoint;
import com.suda.cai.pojo.Online;
import com.suda.cai.pojo.Teacher;
import com.suda.cai.pojo.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface VideoDAO extends JpaRepository<Video,Integer> {
    ArrayList<Video> findAllByOnlineAndKnowledgepoint(Online online, Knowledgepoint knowledgepoint);
    Video findAllByOnlineAndKnowledgepointAndTeacher(Online online, Knowledgepoint knowledgepoint, Teacher teacher);
    ArrayList<Video> findAllByKnowledgepoint(Knowledgepoint knowledgepoint);
}
