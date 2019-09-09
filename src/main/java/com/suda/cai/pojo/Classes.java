package com.suda.cai.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "classes")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name="courseID")
    private Course course;

    @ManyToOne
    @JoinColumn(name="collegeID")
    private College college;
    @ManyToOne
    @JoinColumn(name="teacherID")
    private Teacher teacher;

    @Transient
    private Student student;
    @Transient
    private Grade grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Classes{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course=" + course +
                ", college=" + college +
                ", teacher=" + teacher +
                ", student=" + student +
                ", grade=" + grade +
                '}';
    }
}
