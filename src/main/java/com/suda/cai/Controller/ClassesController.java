package com.suda.cai.Controller;

import com.suda.cai.pojo.*;
import com.suda.cai.service.*;
import com.suda.cai.util.Result;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ClassesController {
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
    //班级管理
    @GetMapping("/listClasses/{teacherID}")
    public List<Classes> listClasses(@PathVariable("teacherID") int teacherID)throws Exception{
        Teacher teacher = new Teacher();
        teacher.setId(teacherID);
        return classesService.findByTeacher(teacher);
    }
    @GetMapping("/listClasses")
    public List<Classes> listClasses(HttpSession session)throws Exception{
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        System.out.println(teacher.toString());
        return classesService.findByTeacher(teacher);
    }
    @DeleteMapping("/deleteClasses/{classesID}")
    public Object deleteClasses(@PathVariable("classesID") int classesID)throws Exception{
        classesService.delete(classesID);
        return null;
    }
    @PostMapping("/addClasses/{name}/{courseID}/{collegeID}")
    public Object add(@PathVariable("name") String name, @PathVariable("courseID") int courseID,@PathVariable("collegeID") int collegeID, HttpSession session)throws Exception{
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        Course course = new Course();
        course.setId(courseID);
        College college = new College();
        college.setId(collegeID);
        Classes classes = new Classes();
        classes.setName(name);
        classes.setCollege(college);
        classes.setCourse(course);
        classes.setTeacher(teacher);
        classesService.add(classes);
        return classes;
    }
    @PutMapping("/updateClasses/{name}/{courseID}/{collegeID}/{classesID}")
    public Object add(@PathVariable("name") String name, @PathVariable("courseID") int courseID,@PathVariable("collegeID") int collegeID,@PathVariable("classesID")int classesID, HttpSession session)throws Exception{
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        Course course = new Course();
        course.setId(courseID);
        College college = new College();
        college.setId(collegeID);
        Classes classes = new Classes();
        classes.setName(name);
        classes.setCollege(college);
        classes.setCourse(course);
        classes.setTeacher(teacher);
        classes.setId(classesID);
        classesService.update(classes);
        return classes;
    }
    //批量添加学生至班级
    @PostMapping("/addStudentsToClasses/{classesID}")
    public Object addStudentsToClasses(@PathVariable("classesID") int classesID, MultipartFile file)throws Exception{
        Classes classes = new Classes();
        classes.setId(classesID);
        ArrayList<Student> list = new ArrayList<>();
        try {
            //1、获取文件输入流
//            InputStream inputStream = new FileInputStream("/Users/Shared/区域数据.xls");

            //2、获取Excel工作簿对象
            XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
            //3、得到Excel工作表对象
            XSSFSheet sheetAt = workbook.getSheetAt(0);
            //4、循环读取表格数据
            for (Row row : sheetAt) {
                //首行（即表头）不读取
                if (row.getRowNum() == 0) {
                    continue;
                }
                //读取当前行中单元格数据，索引从0开始
                double one = row.getCell(0).getNumericCellValue();
                int stuid = (int)one;
                Student student = studentService.getByStuid(stuid);
                list.add(student);
            }
            //5、关闭流
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Student i:list){
            StudentToClasses studentToClasses = studentToClassesService.getAllByStudentAndClasses(i,classes);
            if (null == studentToClasses){
                StudentToClasses studentToClasses1 = new StudentToClasses();
                studentToClasses1.setClasses(classes);
                studentToClasses1.setStudent(i);
                studentToClassesService.add(studentToClasses1);
            }
        }
        return Result.success();
    }
    @DeleteMapping("/deleteStudentFromClasses/{studentID}/{classesID}")
    public Object deleteStudentFromClasses(@PathVariable("studentID")int studentID,@PathVariable("classesID") int classesID)throws Exception{
        Student student = new Student();
        Classes classes = new Classes();
        student.setId(studentID);
        classes.setId(classesID);
        StudentToClasses studentToClasses = studentToClassesService.getAllByStudentAndClasses(student,classes);
        studentToClassesService.delete(studentToClasses.getId());
        return null;
    }
}
