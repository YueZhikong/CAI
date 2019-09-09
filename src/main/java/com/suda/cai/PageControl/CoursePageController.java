package com.suda.cai.PageControl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CoursePageController {
    //课程管理

    @GetMapping(value = "/courseManage")
    public String courseManage(){
        return "/Course/courseManage";
    }
    //章
    @GetMapping(value = "/chapterManage")
    public String chapterManage(){
        return "/Course/chapterManage";
    }
    //节
    @GetMapping(value = "knowledgepointManage")
    public String knowledgepointManage(){
        return "/Course/knowledgepointManage";
    }
    //修改课程
    @GetMapping(value = "/editCourse")
    public String courseEdit(){
        return "/Course/editCourse";
    }
    //修改章
    @GetMapping(value = "/editChapter")
    public String editChapter(){
        return "/Course/editChapter";
    }
}
