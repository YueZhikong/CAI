package com.suda.cai.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "knowledgepoint")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Knowledgepoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name="courseID")
    private Course course;
    @ManyToOne
    @JoinColumn(name="chapterID")
    private Chapter chapter;
    private String point;

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

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    @Override
    public String toString() {
        return "Knowledgepoint{" +
                "id=" + id +
                ", course=" + course +
                ", chapter=" + chapter +
                ", point='" + point + '\'' +
                '}';
    }
}
