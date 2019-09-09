package com.suda.cai.PageControl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MaterialPageController {
    //班级资源
    //老师
    @GetMapping(value = "/teacherMaterial")
    public String teacherMaterial(){
        return "/Material/teacherMaterial";
    }
    //学生
    @GetMapping(value = "/studentMaterial")
    public String studentMaterial(){
        return "/Material/studentMaterial";
    }
}
