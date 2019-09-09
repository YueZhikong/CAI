package com.suda.cai.Controller;

import com.suda.cai.pojo.Chapter;
import com.suda.cai.pojo.College;
import com.suda.cai.pojo.Course;
import com.suda.cai.pojo.Knowledgepoint;
import com.suda.cai.service.*;
import com.suda.cai.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class CourseController {
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

    //课程管理
    @GetMapping("/listCourse")
    public List<Course> listCourse()throws Exception{
        return courseService.list();
    }
    @GetMapping("/listCourse/{collegeID}")
    public List<Course> listCourse(@PathVariable("collegeID") int collegeID) throws Exception{
        College college = new College();
        college.setId(collegeID);
        return courseService.findAllByCollege(college);
    }
    @PostMapping("/addCourse/{collegeID}")
    public Object addCourse(@RequestBody Course course, @PathVariable("collegeID") int collegeID)throws Exception{
        College college =  new College();
        college.setId(collegeID);
        course.setCollege(college);
        courseService.add(course);
        return Result.success();
    }
    @PutMapping("/updateCourse/{collegeID}/{courseID}")
    public Object addCourse(@RequestBody Course course, @PathVariable("collegeID") int collegeID,@PathVariable("courseID") int courseID)throws Exception{
        College college =  new College();
        college.setId(collegeID);
        course.setCollege(college);
        course.setId(courseID);
        courseService.update(course);
        return Result.success();
    }
    @DeleteMapping("/deleteCourse/{id}")
    public Object deleteCourse(@PathVariable("id")int id)throws Exception{
        courseService.delete(id);
        return Result.success();
    }
    //返回章节
    @GetMapping("/listChapter/{courseID}")
    public List<Chapter> findByCourse(@PathVariable("courseID") int courseID)throws Exception{
        Course course = new Course();
        course.setId(courseID);
        return chapterService.findByCourse(course);
    }
    @GetMapping("/listKnowledgepoint/{chapterID}")
    public List<Knowledgepoint> findByChapter(@PathVariable("chapterID") int chapterID)throws Exception{
        Chapter chapter = new Chapter();
        chapter.setId(chapterID);
        return knowledgepointService.findByChapter(chapter);
    }
    //编辑章
    @PostMapping("/addChapter/{courseID}")
    public Object add(@PathVariable("courseID") int courseID,@RequestBody Chapter chapter)throws  Exception{
        Course course = new Course();
        course.setId(courseID);
        chapter.setCourse(course);
        chapterService.add(chapter);
        return chapter;
    }
    @PutMapping("/updateChapter/{courseID}/{chapterID}")
    public Object add(@PathVariable("courseID") int courseID,@RequestBody Chapter chapter,@PathVariable("chapterID")int chapterID)throws  Exception{
        Course course = new Course();
        course.setId(courseID);
        chapter.setCourse(course);
        chapter.setId(chapterID);
        chapterService.update(chapter);
        return chapter;
    }
    @DeleteMapping("/deleteChapter/{id}")
    public String deleteChapter(@PathVariable("id") int id, HttpServletRequest request)  throws Exception {
        chapterService.delete(id);
        return null;
    }
    //编辑节
    @PostMapping("/addKnowledgepoint/{courseID}/{chapterID}")
    public Object add(@PathVariable("courseID") int courseID,@PathVariable("chapterID") int chapterID, @RequestBody Knowledgepoint knowledgepoint)throws  Exception{
        Course course = new Course();
        course.setId(courseID);
        Chapter chapter = new Chapter();
        chapter.setId(chapterID);
        knowledgepoint.setCourse(course);
        knowledgepoint.setChapter(chapter);
        knowledgepointService.add(knowledgepoint);
        return chapter;
    }
    @PutMapping("/updateKnowledgepoint/{courseID}/{chapterID}/{knowledgepointID}")
    public Object add(@PathVariable("courseID") int courseID,@PathVariable("chapterID") int chapterID, @RequestBody Knowledgepoint knowledgepoint,@PathVariable("knowledgepointID")int knowledgepointID)throws  Exception{
        Course course = new Course();
        course.setId(courseID);
        Chapter chapter = new Chapter();
        chapter.setId(chapterID);
        knowledgepoint.setCourse(course);
        knowledgepoint.setChapter(chapter);
        knowledgepoint.setId(knowledgepointID);
        knowledgepointService.update(knowledgepoint);
        return knowledgepoint;
    }
    @DeleteMapping("/deleteKnowledgepoint/{id}")
    public String deleteKnowledgepoint(@PathVariable("id") int id, HttpServletRequest request)  throws Exception {
        knowledgepointService.delete(id);
        return null;
    }
}
