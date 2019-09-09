package com.suda.cai.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "assignment")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private Date createtime;
    private String fileName;
    private String score;
    private int week;

    @ManyToOne
    @JoinColumn(name="classesID")
    private Classes classes;

    @ManyToOne
    @JoinColumn(name="studentID")
    private Student student;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Assignment{" +
                "id=" + id +
                ", createtime=" + createtime +
                ", fileName='" + fileName + '\'' +
                ", score='" + score + '\'' +
                ", week=" + week +
                ", classes=" + classes +
                ", student=" + student +
                '}';
    }
}
