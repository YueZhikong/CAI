package com.suda.cai.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "examcontent")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class ExamContent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name="examID")
    private Exam exam;

    @ManyToOne
    @JoinColumn(name="problemID")
    private Problem problem;

    private int type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Exam getExam() {
        return exam;
    }

    public void setExam(Exam exam) {
        this.exam = exam;
    }

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "ExamContent{" +
                "id=" + id +
                ", exam=" + exam +
                ", problem=" + problem +
                ", type=" + type +
                '}';
    }
}
