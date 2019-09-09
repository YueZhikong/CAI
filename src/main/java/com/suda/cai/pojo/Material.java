package com.suda.cai.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "material")
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    private String fileName;

    @ManyToOne
    @JoinColumn(name="classesID")
    private Classes classes;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Classes getClasses() {
        return classes;
    }

    public void setClasses(Classes classes) {
        this.classes = classes;
    }


    @Override
    public String toString() {
        return "Material{" +
                "id=" + id +
                ", fileName='" + fileName + '\'' +
                ", classes=" + classes +
                '}';
    }
}
