package com.suda.cai.PageControl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MessagePageController {
    //师生交流
    //老师
    @GetMapping(value = "/teacherListMessage")
    public String teacherMessage(){
        return "/Message/teacherListMessage";
    }
    @GetMapping(value = "/teacherBackMessage")
    public String teacherBackMessage(){
        return "/Message/teacherBackMessage";
    }
    @GetMapping(value = "teacherMessageContent")
    public String teacherMessageContent(){
        return "/Message/teacherMessageContent";
    }
    @GetMapping(value = "teacherEditMessage")
    public String teacherEditMessage(){
        return "/Message/teacherEditMessage";
    }
    //学生
    @GetMapping(value = "/studentListMessage")
    public String studentMessage(){
        return "/Message/studentListMessage";
    }
    @GetMapping(value = "/studentBackMessage")
    public String studentBackMessage(){
        return "/Message/studentBackMessage";
    }
    @GetMapping(value = "/studentMessageContent")
    public String studentMessageContent(){
        return "/Message/studentMessageContent";
    }
    @GetMapping(value = "/studentEditMessage")
    public String studentEditMessage(){
        return "/Message/studentEditMessage";
    }
    @GetMapping(value = "/haveSent")
    public String haveSent(){
        return "/Message/haveSent";
    }
    @GetMapping(value = "/teacherMessage")
    public String teacherMessages(){
        return "/Message/teacherMessage";
    }
    @GetMapping(value = "/studentMessage")
    public String studentMessages(){
        return "/Message/studentMessage";
    }
}
