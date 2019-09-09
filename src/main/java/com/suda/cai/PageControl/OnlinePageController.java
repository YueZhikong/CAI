package com.suda.cai.PageControl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OnlinePageController {
    //管理员
    @GetMapping(value = "adminDeleteOnline")
    public String adminDeleteOnline(){
        return "/Online/adminDeleteOnline";
    }
    @GetMapping(value = "adminViewOnline")
    public String adminViewOnline(){
        return "/Online/adminViewOnline";
    }
    //学生
    @GetMapping(value = "studentViewOnline")
    public String studentViewOnline(){
        return "/Online/studentViewOnline";
    }
    //老师
    @GetMapping(value = "teacherCreateOnline")
    public String teacherCreateOnline(){
        return "/Online/teacherCreateOnline";
    }
    @GetMapping(value = "teacherUploadOnline")
    public String teacherUploadOnline(){
        return "/Online/teacherUploadOnline";
    }
    @GetMapping(value = "teacherViewOnline")
    public String teacherViewOnline(){
        return "/Online/teacherViewOnline";
    }
    @GetMapping(value = "viewOnline")
    public String viewOnline(){
        return "/Online/viewOnline";
    }
}
