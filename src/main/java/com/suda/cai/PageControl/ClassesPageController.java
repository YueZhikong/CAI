package com.suda.cai.PageControl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ClassesPageController {
    //班级管理

    @GetMapping(value = "/classesManage")
    public String classesManage(){
        return "/Classes/classesManage";
    }
    //老师
    @GetMapping(value = "/teacherClasses")
    public String teacherClasses(){
        return "/Classes/teacherClasses";
    }
    //批量添加学生
    @GetMapping(value = "/teacherAddStudents")
    public String teacherAddStudents(){
        return "/Classes/addStudents";
    }
    //修改班级页面
    @GetMapping(value = "/editClasses")
    public String editClasses(){
        return "/Classes/editClasses";
    }
}
