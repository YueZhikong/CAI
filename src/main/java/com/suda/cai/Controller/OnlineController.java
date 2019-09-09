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
import java.util.List;

@RestController
public class OnlineController {
    @Autowired
    OnlineService onlineService;
    @Autowired
    VideoService videoService;
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
    ProblemService  problemService;
    @Autowired
    ExamService examService;
    @Autowired
    ExamContentService examContentService;
    @Autowired
    ExamStudentService examStudentService;
    @Autowired
    StudentAnswerService studentAnswerService;
    @Autowired
    AchievementService achievementService;
    //老师
    @GetMapping("/Online/listCourse")
    public List<Course> listCourse(HttpSession session){
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        return courseService.findAllByCollege(teacher.getCollege());
    }
    @GetMapping("/Online/listOnline")
    public List<Online> listOnline(HttpSession session){
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        return onlineService.findByTeacher(teacher);
    }
    @DeleteMapping("/Online/deleteOnline/{onlineID}")
    public Object deleteOnline(@PathVariable("onlineID") int onlineID){
        onlineService.delete(onlineID);
        return null;
    }
    @PostMapping("/Online/addOnline/{courseID}/{name}")
    public Object addOnline(@PathVariable("courseID") int courseID,@PathVariable("name") String name, HttpSession session){
        Course course = new Course();
        course.setId(courseID);
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        Online online = new Online();
        online.setCourse(course);
        online.setName(name);
        online.setTeacher(teacher);
        onlineService.add(online);
        return online;
    }
    @GetMapping("/Online/listChapter/{courseID}")
    public List<Chapter> listChapter(@PathVariable("courseID") int courseID){
        Course course = new Course();
        course.setId(courseID);
        return chapterService.findByCourse(course);
    }
    @GetMapping("/Online/listKnowledgepoint/{chapterID}")
    public List<Knowledgepoint> listKnowledgepoint(@PathVariable("chapterID") int chapterID){
        Chapter chapter = new Chapter();
        chapter.setId(chapterID);
        return knowledgepointService.findByChapter(chapter);
    }

    public List<Video> listVideo(int onlineID,int knowledgepointID){
        Online online = new Online();
        online.setId(onlineID);
        Knowledgepoint knowledgepoint = new Knowledgepoint();
        knowledgepoint.setId(knowledgepointID);
        return videoService.findAllByOnlineAndKnowledgepoint(online,knowledgepoint);
    }
    @PostMapping("/Online/upload/{onlineID}/{knowledgepointID}")
    public Object upload(@PathVariable("onlineID") int onlineID, @PathVariable("knowledgepointID") int knowledgepointID, HttpSession session, MultipartFile file, HttpServletRequest request){
        Online online = new Online();
        online.setId(onlineID);
        Knowledgepoint knowledgepoint = new Knowledgepoint();
        knowledgepoint.setId(knowledgepointID);
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        Video video = videoService.findAllByOnlineAndKnowledgepointAndTeacher(online,knowledgepoint,teacher);
        String fileName = file.getOriginalFilename();
        if (null == video){
            Video video1 = new Video();
            video1.setOnline(online);
            video1.setKnowledgepoint(knowledgepoint);
            video1.setTeacher(teacher);
            video1.setFilename(fileName);
            System.out.println(video1.toString());
            videoService.add(video1);
            savefile(request,file,video1.getId());
        }
        else {
            video.setFilename(fileName);
            videoService.update(video);
            savefile(request,file,video.getId());
        }
        return Result.success();
    }


    private void savefile(HttpServletRequest request,MultipartFile file,int videoID ){
        String path = "file/video";
        String fileName = String.valueOf(videoID) + ".mp4";
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
    }

    //学生
    @GetMapping("/Online/listVideo/{knowledgepointID}")
    public List<Video> listVideo(@PathVariable("knowledgepointID") int knowledgepointID){
        Knowledgepoint knowledgepoint = new Knowledgepoint();
        knowledgepoint.setId(knowledgepointID);
        return videoService.findAllByKnowledgepoint(knowledgepoint);
    }
    @GetMapping("/Online/listChapter")
    public List<Chapter> listChapter(HttpSession session){
        Classes classes = (Classes)session.getAttribute("classes");
        Course course = classes.getCourse();
        return chapterService.findByCourse(course);
    }
    //管理员
    @GetMapping("/Online/listCourses")
    public List<Course> listCourses(){
        return courseService.list();
    }
    @GetMapping("/Online/listOnline/{courseID}")
    public List<Online> listOnline(@PathVariable("courseID") int courseID){
        Course course = new Course();
        course.setId(courseID);
        return onlineService.findAllByCourse(course);
    }

    public Object deleteVideo(int videoID,HttpServletRequest request){
        videoService.delete(videoID);
        File  imageFolder= new File(request.getServletContext().getRealPath("file/video"));
        File file = new File(imageFolder,videoID+".mp4");
        file.delete();
        return null;
    }
}
