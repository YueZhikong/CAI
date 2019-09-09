package com.suda.cai.dao;

import com.suda.cai.pojo.Exam;
import com.suda.cai.pojo.ExamContent;
import com.suda.cai.pojo.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;

public interface ExamContentDAO extends JpaRepository<ExamContent,Integer> {
    ArrayList<ExamContent> findByExamAndType(Exam exam, int type);
    ExamContent findByExamAndProblem(Exam exam, Problem problem);
    ArrayList<ExamContent> findByExam(Exam exam);
}
