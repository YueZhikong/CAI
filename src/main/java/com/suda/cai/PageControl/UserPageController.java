package com.suda.cai.PageControl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller

public class UserPageController {
    //主页
    @GetMapping(value="/")
    public String index(){
        return "redirect:index";
    }
    @GetMapping(value="/index")
    public String home(){
        return "/index";
    }
    //管理员登录
    @GetMapping(value = "/adminLogin")
    public String AdminLogin(){
        return "/adminLogin";
    }
    //老师登录
    @GetMapping(value="/teacherLogin")
    public String TeacherLogin(){
        return "/teacherLogin";
    }
    //学生登录
    @GetMapping(value="/studentLogin")
    public String StudentLogin(){
        return "/studentLogin";
    }
    //学生选择
    @GetMapping(value = "studentChoose")
    public String studentChoose(){
        return "/studentChoose";
    }
    //管理员主页
    @GetMapping(value = "/adminHome")
    public String adminHome(){
        return "/adminHome";
    }
    //学生主页
    @GetMapping(value = "/studentHome")
    public String studentHome(){
        return "/studentHome";
    }
    //老师主页
    @GetMapping(value = "/teacherHome")
    public String teacherHome(){
        return "/teacherHome";
    }
    //用户管理
    //老师管理
    @GetMapping(value = "/teacherManage")
    public String teacherManage(){
        return "/User/teacherManage";
    }
    //学生管理
    @GetMapping(value = "/studentManage")
    public String studentManage(){
        return "/User/studentManage";
    }
    //退出登录
    @GetMapping("/logout")
    public String logout(HttpSession session)throws Exception{
        System.out.println(11111);
        session.removeAttribute("teacher");
        session.removeAttribute("admin");
        session.removeAttribute("student");
        session.removeAttribute("classes");
        return "redirect:index";
    }
    @GetMapping("/teacherEditPassword")
    public String teacehreditPassword(){
        return "/User/teacherEditPassword";
    }
    @GetMapping("/adminEditPassword")
    public String admineditPassword(){
        return "/User/adminEditPassword";
    }
    @GetMapping("/studentEditPassword")
    public String studenteditPassword(){
        return "/User/studentEditPassword";
    }
}
