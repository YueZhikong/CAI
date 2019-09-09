package com.suda.cai.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "achievement")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Achievement {
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
    private double score1;
    private double score2;
    private double score3;
    private double score4;
    private double score5;
    private double total;
    @ManyToOne
    @JoinColumn(name="classesID")
    private Classes classes;

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

    public double getScore1() {
        return score1;
    }

    public void setScore1(double score1) {
        this.score1 = score1;
    }

    public double getScore2() {
        return score2;
    }

    public void setScore2(double score2) {
        this.score2 = score2;
    }

    public double getScore3() {
        return score3;
    }

    public void setScore3(double score3) {
        this.score3 = score3;
    }

    public double getScore4() {
        return score4;
    }

    public void setScore4(double score4) {
        this.score4 = score4;
    }

    public double getScore5() {
        return score5;
    }

    public void setScore5(double score5) {
        this.score5 = score5;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Achievement{" +
                "id=" + id +
                ", exam=" + exam +
                ", student=" + student +
                ", score1=" + score1 +
                ", score2=" + score2 +
                ", score3=" + score3 +
                ", score4=" + score4 +
                ", score5=" + score5 +
                ", total=" + total +
                ", classes=" + classes +
                '}';
    }
}
