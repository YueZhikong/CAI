package com.suda.cai.Controller;

import com.suda.cai.pojo.Classes;
import com.suda.cai.pojo.Material;
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
import java.util.Date;
import java.util.List;

@RestController
public class MaterialController {
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
    @Autowired
    MaterialService materialService;
    @Autowired
    AssignmentService assignmentService;
    //班级资源
    @GetMapping("/studentListMaterial")
    public List<Material> findByClasses(HttpSession session) throws Exception{
        Classes classes = (Classes) session.getAttribute("classes");
        return materialService.findByClasses(classes);
    }

    @GetMapping("/teacherListMaterial/{classesID}")
    public List<Material> findAllByClasses(@PathVariable("classesID") int classesID)throws Exception{
        Classes classes = new Classes();
        classes.setId(classesID);
        return materialService.findByClasses(classes);
    }

    @PostMapping("/teacherListMaterial")
    public Object uploadMaterial(Classes classes, MultipartFile file, HttpServletRequest request, HttpSession session)throws Exception{
        Material material = new Material();
        material.setClasses(classes);
        // 获得当前时间
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        // 转换为字符串
        String formatDate = format.format(new Date());
        // 获取文件名
        String fileName = file.getOriginalFilename();
        int x=(int)(Math.random()*10000000);
        fileName = "(日期"+ formatDate + "+"+x +")" + fileName;
        String path = "file/material";
        material.setFileName(fileName);
        materialService.add(material);
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
    @DeleteMapping("/deleteMaterial/{materialID}")
    public String deleteMaterial(@PathVariable("materialID")int materialID,HttpServletRequest request)throws Exception{
        Material material = materialService.get(materialID);
        String path = "/file/material";
        String fileName = material.getFileName();
        materialService.delete(materialID);
        File Folder= new File(request.getServletContext().getRealPath(path));
        File dest = new File(Folder,fileName);
        dest.delete();
        return null;
    }
}
