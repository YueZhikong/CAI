package com.suda.cai.PageControl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CollegePageController {
    //学院管理

    @GetMapping(value = "/collegeManage")
    public String collegeManage(){
        return "/College/collegeManage";
    }
    @GetMapping(value = "/editCollege")
    public String editCollege(){
        return "/College/editCollege";
    }
}
