package com.suda.cai.Controller;

import com.suda.cai.pojo.Assignment;
import com.suda.cai.pojo.Classes;
import com.suda.cai.pojo.Student;
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
public class AssignmentController {
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
    AssignmentService assignmentService;
    //作业
    //老师
    @GetMapping("/teacherListAssignment/{classesID}/{week}")
    public List<Assignment> findByClassesAndWeek(@PathVariable("classesID")int classesID, @PathVariable("week")int week)throws Exception{
        Classes classes = new Classes();
        classes.setId(classesID);
        return assignmentService.findByClassesAndWeek(classes,week);
    }
    @PutMapping("/markAssignment/{assignmentID}/{score}")
    public Object update(@PathVariable("assignmentID")int assignmentID,@PathVariable("score") String score) throws Exception{
        Assignment assignment = assignmentService.get(assignmentID);
        assignment.setScore(score);
        assignmentService.update(assignment);
        return null;
    }

    //学生

    @PostMapping("/sendAssignment")
    public Object uploadMaterial(Assignment assignment, MultipartFile file, HttpServletRequest request, HttpSession session)throws Exception{
        Student student = (Student) session.getAttribute("student");
        assignment.setStudent(student);
        Classes classes = (Classes) session.getAttribute("classes");
        assignment.setClasses(classes);
        int week = assignment.getWeek();
        // 获得当前时间
        DateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        // 转换为字符串
        String formatDate = format.format(new Date());
        Date date = new Date();
        assignment.setCreatetime(date);
        // 获取文件名
        String fileName = file.getOriginalFilename();
        int x=(int)(Math.random()*10000000);
        fileName = "(日期"+ formatDate + "+"+x +")" + fileName;
        String path = "file/assignment";
        assignment.setFileName(fileName);
        Assignment h = assignmentService.findByClassesAndStudentAndWeek(classes,student,week);
        if (h==null){
            assignmentService.add(assignment);
        }
        else {
            assignment.setId(h.getId());
            assignmentService.update(assignment);
        }
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
    @GetMapping("/studentListAssignment")
    public List<Assignment> listAssignment(HttpSession session)throws Exception{
        Classes classes = (Classes) session.getAttribute("classes");
        Student student = (Student) session.getAttribute("student");
        return assignmentService.findByClassesAndStudent(classes,student);
    }
}
