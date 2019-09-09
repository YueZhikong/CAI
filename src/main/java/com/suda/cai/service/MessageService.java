package com.suda.cai.service;

import com.suda.cai.dao.MessageDAO;
import com.suda.cai.pojo.Classes;
import com.suda.cai.pojo.Message;
import com.suda.cai.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class MessageService {
    @Autowired
    MessageDAO messageDAO;

    public void add(Message bean){
        messageDAO.save(bean);
    }
    public void delete(int id){
        messageDAO.delete(id);
    }
    public Message get(int id){
        return messageDAO.findOne(id);
    }
    public void update(Message bean){
        messageDAO.save(bean);
    }

    public List<Message> findByStudent(Student student,int send){
        return messageDAO.findByStudentAndSendOrderByIdDesc(student,send);
    }
    public List<Message> findByClasses(Classes classes,int send){
        return messageDAO.findByClassesAndSendOrderByIdDesc(classes,send);
    }
    public List<Message> findByStudentAndClassesAndSend(Student student,Classes classes,int sent){
        return messageDAO.findByStudentAndClassesAndSend(student, classes, sent);
    }
}
