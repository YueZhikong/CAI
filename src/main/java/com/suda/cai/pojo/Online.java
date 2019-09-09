package com.suda.cai.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "online")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Online {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name="courseID")
    private Course course;
    private String name;
    @ManyToOne
    @JoinColumn(name="teacherID")
    private Teacher teacher;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Online{" +
                "id=" + id +
                ", course=" + course +
                ", name='" + name + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
