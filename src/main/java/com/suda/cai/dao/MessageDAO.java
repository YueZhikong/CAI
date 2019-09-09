package com.suda.cai.dao;

import com.suda.cai.pojo.Classes;
import com.suda.cai.pojo.Message;
import com.suda.cai.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageDAO extends JpaRepository<Message,Integer> {
    List<Message> findByStudentOrderByIdDesc(Student student);
    List<Message> findByClassesAndSendOrderByIdDesc(Classes classes,int send);
    List<Message> findByStudentAndSendOrderByIdDesc(Student student,int send);
    List<Message> findByStudentAndClassesAndSend(Student student, Classes classes, int send);
}
