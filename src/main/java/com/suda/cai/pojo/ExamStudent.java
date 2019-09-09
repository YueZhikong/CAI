package com.suda.cai.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "examstudent")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class ExamStudent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name="examID")
    private Exam exam;

    @ManyToOne
    @JoinColumn(name="studentID")
    private Student student;
    @ManyToOne
    @JoinColumn(name="classesID")
    private Classes classes;
    private int joinexam;
    private int inquiry;
    private Date createtime;
    private long duration;
    private Date deadtime;
    private int type;
    @Transient
    private boolean judge;


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

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public int getJoinexam() {
        return joinexam;
    }

    public void setJoinexam(int joinexam) {
        this.joinexam = joinexam;
    }

    public int getInquiry() {
        return inquiry;
    }

    public void setInquiry(int inquiry) {
        this.inquiry = inquiry;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public Date getDeadtime() {
        return deadtime;
    }

    public void setDeadtime(Date deadtime) {
        this.deadtime = deadtime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean isJudge() {
        return judge;
    }

    public void setJudge(boolean judge) {
        this.judge = judge;
    }

    @Override
    public String toString() {
        return "ExamStudent{" +
                "id=" + id +
                ", exam=" + exam +
                ", student=" + student +
                ", classes=" + classes +
                ", joinexam=" + joinexam +
                ", inquiry=" + inquiry +
                ", createtime=" + createtime +
                ", duration=" + duration +
                ", deadtime=" + deadtime +
                ", type=" + type +
                ", judge=" + judge +
                '}';
    }
}
