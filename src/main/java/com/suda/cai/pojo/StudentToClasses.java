package com.suda.cai.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "student_classes")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class StudentToClasses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @ManyToOne
    @JoinColumn(name="studentID")
    private Student student;
    @ManyToOne
    @JoinColumn(name="classesID")
    private Classes classes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "StudentToClasses{" +
                "id=" + id +
                ", student=" + student +
                ", classes=" + classes +
                '}';
    }
}
