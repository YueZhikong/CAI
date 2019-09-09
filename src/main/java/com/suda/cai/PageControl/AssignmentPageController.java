package com.suda.cai.PageControl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AssignmentPageController {
    //作业管理

    //老师
    @GetMapping(value = "/teacherAssignment")
    public String teacherAssignment(){
        return "/Assignment/teacherAssignment";
    }

    //学生

    @GetMapping(value = "/studentAssignment")
    public String studentAssignment(){
        return "/Assignment/studentAssignment";
    }
}
