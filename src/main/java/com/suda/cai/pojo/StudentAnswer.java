package com.suda.cai.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "studentanswer")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class StudentAnswer {
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
    @JoinColumn(name="problemID")
    private Problem problem;
    @ManyToOne
    @JoinColumn(name="classesID")
    private Classes classes;
    private String answer;
    private int type;
    private double score;

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

    public Problem getProblem() {
        return problem;
    }

    public void setProblem(Problem problem) {
        this.problem = problem;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "StudentAnswer{" +
                "id=" + id +
                ", exam=" + exam +
                ", student=" + student +
                ", problem=" + problem +
                ", classes=" + classes +
                ", answer='" + answer + '\'' +
                ", type=" + type +
                ", score=" + score +
                '}';
    }
}
