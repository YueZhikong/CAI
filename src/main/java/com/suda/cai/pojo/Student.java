package com.suda.cai.pojo;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "student")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private int stuid;

    private String name;

    private String password;

    @ManyToOne
    @JoinColumn(name="collegeID")
    private College college;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStuid() {
        return stuid;
    }

    public void setStuid(int stuid) {
        this.stuid = stuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public College getCollege() {
        return college;
    }

    public void setCollege(College college) {
        this.college = college;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", stuid=" + stuid +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", college=" + college +
                '}';
    }
}
