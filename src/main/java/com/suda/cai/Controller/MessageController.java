package com.suda.cai.Controller;

import com.suda.cai.pojo.*;
import com.suda.cai.service.*;
import com.suda.cai.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class MessageController {
    @Autowired
    CourseService courseService;
    @Autowired
    GradeService gradeService;
    @Autowired
    CollegeService collegeService;
    @Autowired
    ClassesService classesService;
    @Autowired
    StudentToClassesService studentToClassesService;
    @Autowired
    StudentService studentService;
    @Autowired
    AdminService adminService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    ChapterService chapterService;
    @Autowired
    KnowledgepointService knowledgepointService;
    @Autowired
    MessageService messageService;
    //师生交流
    //老师查看信息
    @GetMapping("/teacherListMessage/{id}")
    public List<Message> listMessageByClasses(@PathVariable("id") int id)throws Exception{
        Classes classes = new Classes();
        classes.setId(id);
        int send = 0;
        return messageService.findByClasses(classes,send);
    }
    @GetMapping("/teacherMessage/{id}")
    public List<Message> listMessagesByClasses(@PathVariable("id") int id)throws Exception{
        Classes classes = new Classes();
        classes.setId(id);
        int send = 1;
        return messageService.findByClasses(classes,send);
    }
    //老师删除信息
    @DeleteMapping("/deleteMessage/{mid}")
    public String deleteMessage(@PathVariable("mid")int mid, HttpServletRequest request)throws Exception{
        Message message = messageService.get(mid);
        String path = "/file/message";
        String fileName = message.getFileName();
        messageService.delete(mid);
        File Folder= new File(request.getServletContext().getRealPath(path));
        File dest = new File(Folder,fileName);
        dest.delete();
        return null;
    }

    //返回学生列表
    @GetMapping("/listStudents/{classesID}")
    public ArrayList<Student> findByClasses(@PathVariable("classesID") int classesID){
        Classes classes = new Classes();
        classes.setId(classesID);
        List<StudentToClasses> studentToClasses = studentToClassesService.findByClasses(classes);
        ArrayList<Student> list = new ArrayList<>();
        for (StudentToClasses i:studentToClasses){
            Student student = i.getStudent();
            list.add(student);
        }
        return list;
    }
    //老师发送消息
    @PostMapping("/teacherSendMessage/{classesID}/{studentID}")
    public Object teacherMessageBack(@PathVariable("classesID")int classesID, @PathVariable("studentID")int studentID, Message message, MultipartFile file, HttpServletRequest request, HttpSession session){
        Student student = studentService.get(studentID);
        Classes classes = classesService.get(classesID);
        Date date = new Date();
        System.out.println(date);
        String path = "/file/message";
        // 获得当前时间
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        // 转换为字符串
        String formatDate = format.format(new Date());
        // 获取文件名
        String fileName = file.getOriginalFilename();
        int x=(int)(Math.random()*10000000);
        fileName = "(日期"+ formatDate + "+"+x +")" + fileName;
        message.setStudent(student);
        message.setClasses(classes);
        message.setCreatetime(date);
        message.setBack(0);
        message.setSend(1);
        message.setFileName(fileName);
        messageService.add(message);
        File Folder= new File(request.getServletContext().getRealPath(path));
        File dest = new File(Folder,fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.success();
    }
    //返回message具体内容
    @GetMapping("/MessageContent/{mid}")
    public Message get(@PathVariable("mid")int mid) throws Exception{
        return messageService.get(mid);
    }
    //回复消息
    @PostMapping("/teacherBackMessage/{messageID}/{classesID}/{studentID}")
    public Object teacherMessageBack(@PathVariable("messageID")int messageID, @PathVariable("classesID")int classesID, @PathVariable("studentID")int studentID, Message message, MultipartFile file, HttpServletRequest request, HttpSession session){
        Message messageback = messageService.get(messageID);
        messageback.setBack(1);
        messageService.update(messageback);
        Student student = studentService.get(studentID);
        Classes classes = classesService.get(classesID);
        Date date = new Date();
        String path = "/file/message";
        // 获得当前时间
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        // 转换为字符串
        String formatDate = format.format(new Date());
        // 获取文件名
        String fileName = file.getOriginalFilename();
        int x=(int)(Math.random()*10000000);
        fileName = "(日期"+ formatDate + "+"+x +")" + fileName;
        message.setStudent(student);
        message.setClasses(classes);
        message.setCreatetime(date);
        message.setBack(0);
        message.setSend(1);
        message.setFileName(fileName);
        messageService.add(message);
        File Folder= new File(request.getServletContext().getRealPath(path));
        File dest = new File(Folder,fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.success();
    }
    //师生交流学生
    //listMessage
    @GetMapping("/studentListMessages")
    public List<Message> listMessageByStudent(HttpSession session) throws Exception {
        Student student = (Student) session.getAttribute("student");
        int id = student.getId();
        int send = 1;
        return messageService.findByStudent(student,send);
    }
    @GetMapping("/studentMessages")
    public List<Message> listMessagesByStudent(HttpSession session) throws Exception {
        Student student = (Student) session.getAttribute("student");
        Classes classes = (Classes) session.getAttribute("classes");
        int id = student.getId();
        int send = 0;
        return messageService.findByStudentAndClassesAndSend(student,classes,send);
    }
    //学生发送信息
    @PostMapping("/studentSendMessage")
    public Object add(Message message, MultipartFile file, HttpServletRequest request, HttpSession session) throws IOException {
        Student student = (Student) session.getAttribute("student");
        Classes classes = (Classes) session.getAttribute("classes");
        Date date = new Date();
        String path = "/file/message";
        // 获得当前时间
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        // 转换为字符串
        String formatDate = format.format(new Date());
        // 获取文件名
        String fileName = file.getOriginalFilename();
        int x=(int)(Math.random()*10000000);
        fileName = "(日期"+ formatDate + "+"+x +")" + fileName;
        message.setStudent(student);
        message.setClasses(classes);
        message.setCreatetime(date);
        message.setBack(0);
        message.setSend(0);
        message.setFileName(fileName);
        System.out.println(message.toString());
        messageService.add(message);
        // 获取文件的后缀名
//        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件上传路径
//		String filePath =request.getServletContext().getRealPath("file");
        // 解决中文问题,liunx 下中文路径,图片显示问题
        //fileName = UUID.randomUUID() + suffixName;
//		File dest = new File(filePath + fileName);
        File Folder= new File(request.getServletContext().getRealPath(path));
        File dest = new File(Folder,fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.success();
    }

    @PostMapping("/studentBackMessage/{messageID}/{classesID}/{studentID}")
    public Object studentBackMessage(@PathVariable("messageID")int messageID, @PathVariable("classesID")int classesID, @PathVariable("studentID")int studentID, Message message, MultipartFile file, HttpServletRequest request, HttpSession session){
        Message messageback = messageService.get(messageID);
        messageback.setBack(1);
        messageService.update(messageback);
        Student student = studentService.get(studentID);
        Classes classes = classesService.get(classesID);
        Date date = new Date();
        String path = "/file/message";
        // 获得当前时间
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        // 转换为字符串
        String formatDate = format.format(new Date());
        // 获取文件名
        String fileName = file.getOriginalFilename();
        int x=(int)(Math.random()*10000000);
        fileName = "(日期"+ formatDate + "+"+x +")" + fileName;
        message.setStudent(student);
        message.setClasses(classes);
        message.setCreatetime(date);
        message.setBack(0);
        message.setSend(0);
        message.setFileName(fileName);
        messageService.add(message);
        File Folder= new File(request.getServletContext().getRealPath(path));
        File dest = new File(Folder,fileName);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Result.success();
    }

}
