package com.suda.cai.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "video")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name="onlineID")
    private Online online;
    @ManyToOne
    @JoinColumn(name="knowledgepointID")
    private Knowledgepoint knowledgepoint;
    private String filename;
    @ManyToOne
    @JoinColumn(name="teacherID")
    private Teacher teacher;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Online getOnline() {
        return online;
    }

    public void setOnline(Online online) {
        this.online = online;
    }

    public Knowledgepoint getKnowledgepoint() {
        return knowledgepoint;
    }

    public void setKnowledgepoint(Knowledgepoint knowledgepoint) {
        this.knowledgepoint = knowledgepoint;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", online=" + online +
                ", knowledgepoint=" + knowledgepoint +
                ", filename='" + filename + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
