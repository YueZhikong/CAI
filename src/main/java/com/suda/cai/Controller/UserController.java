package com.suda.cai.Controller;

import com.suda.cai.pojo.*;
import com.suda.cai.service.*;
import com.suda.cai.util.MD5;
import com.suda.cai.util.Result;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController

public class UserController {
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
    //学生登录
    @PostMapping("/studentLogin")
    public Object studentLogin(@RequestBody Student studentParam, HttpSession session)throws Exception {
        String password = studentParam.getPassword();
        String key = "Shin Megami Tensei";
        String md5 = MD5.md5(password,key);
        studentParam.setPassword(md5);
        Student student = studentService.findByStuidAndPassword(studentParam.getStuid(),studentParam.getPassword());
        if (null == student){
            String message = "账号密码错误";
            return Result.fail(message);
        }
        else {
            session.setAttribute("student",student);
            return Result.success();
        }
    }
    //返回和该学生有关的班级
    @GetMapping("/StudentToClasses")
    public List<Classes> StudentToClasses(HttpSession session)throws Exception{
        Student student = (Student)session.getAttribute("student");
        ArrayList<StudentToClasses> studentToClasses = studentToClassesService.findAllByStudent(student);
        ArrayList<Classes> classesArrayList = new ArrayList<>();
        for (StudentToClasses i:studentToClasses){
            Classes classes = i.getClasses();
            classesArrayList.add(classes);
        }
        return classesArrayList;
    }
    //添加classes session
    @PostMapping("/chooseClasses/{classesID}")
    public Object chooseClasses(@PathVariable("classesID")int classesID, HttpSession session)throws Exception{
        Classes classes =  classesService.get(classesID);
        session.removeAttribute("classes");
        session.setAttribute("classes",classes);
        return Result.success();
    }
    //管理员登录
    @PostMapping("/adminLogin")
    public Object login(@RequestBody Admin admin, HttpSession session)throws Exception{
        String name =  admin.getName();
        name = HtmlUtils.htmlEscape(name);
        String password = admin.getPassword();
        String key = "Shin Megami Tensei";
        String md5 = MD5.md5(password,key);
        Admin admin1 = adminService.findByNameAndPassword(name,md5);
        if(null==admin1){
            String message ="账号密码错误";
            return Result.fail(message);
        }
        else{
            session.setAttribute("admin", admin1);
            return Result.success();
        }
    }

    //老师登录
    @PostMapping("/teacherLogin")
    public Object login(@RequestBody Teacher teacher, HttpSession session)throws Exception{
        String name =  teacher.getName();
        name = HtmlUtils.htmlEscape(name);
        String password = teacher.getPassword();
        String key = "Shin Megami Tensei";
        String md5 = MD5.md5(password,key);

        Teacher teacher1 = teacherService.getByNameAndPassword(name,md5);
        if(null==teacher1){
            String message ="账号密码错误";
            return Result.fail(message);
        }
        else{
            session.setAttribute("teacher", teacher1);
            return Result.success();
        }
    }
    //老师管理
    @GetMapping("/listTeacher/{collegeID}")
    public List<Teacher> listTeacher(@PathVariable("collegeID") int collegeID)throws Exception{
        College college = new College();
        college.setId(collegeID);
        return teacherService.findAllByCollege(college);
    }

    @PostMapping("/addTeacher/{collegeID}")
    public Object addTeacher(@RequestBody Teacher teacher,@PathVariable("collegeID") int collegeID)throws Exception{
        College college = new College();
        college.setId(collegeID);
        String key = "Shin Megami Tensei";
        String password = "123456";
        teacher.setPassword(MD5.md5(password,key));
        teacher.setCollege(college);
        teacherService.add(teacher);
        return Result.success();
    }

    @PutMapping("/initTeacherPassword/{id}")
    public Object initTeacherPassword(@PathVariable("id")int id)throws Exception{
        Teacher teacher = teacherService.get(id);
        String key = "Shin Megami Tensei";
        String password = "123456";
        teacher.setPassword(MD5.md5(password,key));
        teacherService.add(teacher);
        return Result.success();
    }

    @DeleteMapping("/deleteTeacher/{id}")
    public Object deleteTeacher(@PathVariable("id")int id)throws Exception{
        teacherService.delete(id);
        return Result.success();
    }

    //学生管理
    @GetMapping("/listStudent/{collegeID}")
    public List<Student> listStudent(@PathVariable("collegeID") int collegeID)throws Exception{
        College college = new College();
        college.setId(collegeID);
        return studentService.findAllByCollege(college);
    }

    @PostMapping("/addStudent/{collegeID}")
    public Object addStudent(@RequestBody Student student,@PathVariable("collegeID") int collegeID)throws Exception{
        College college = new College();
        college.setId(collegeID);
        String key = "Shin Megami Tensei";
        String password = "123456";
        student.setPassword(MD5.md5(password,key));
        student.setCollege(college);
        studentService.add(student);
        return Result.success();
    }

    @PutMapping("/initStudentPassword/{id}")
    public Object initStudentPassword(@PathVariable("id")int id)throws Exception{
        Student student = studentService.get(id);
        String key = "Shin Megami Tensei";
        String password = "123456";
        student.setPassword(MD5.md5(password,key));
        studentService.add(student);
        return Result.success();
    }

    @DeleteMapping("/deleteStudent/{id}")
    public Object deleteStudent(@PathVariable("id")int id)throws Exception{
        studentService.delete(id);
        return Result.success();
    }
    //批量加入学生
    @PostMapping("/addStudents")
    public Object addStudents(
            MultipartFile file, HttpServletRequest request, HttpSession session)throws Exception{
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
                String name = row.getCell(1).getStringCellValue();
                double three = row.getCell(2).getNumericCellValue();
                int collegeID = (int)three;
                Student student = new Student();
                student.setStuid(stuid);
                student.setName(name);
                College college = new College();
                college.setId(collegeID);
                student.setCollege(college);
                String key = "Shin Megami Tensei";
                String password = "123456";
                student.setPassword(MD5.md5(password,key));
                list.add(student);
            }
            //5、关闭流
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Student i:list){
            studentService.add(i);
        }
        return Result.success();
    }
    //批量添加老师
    @PostMapping("/addTeachers")
    public Object addTeachers( MultipartFile file, HttpServletRequest request, HttpSession session)throws Exception{
        ArrayList<Teacher> list = new ArrayList<>();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook(file.getInputStream());
            XSSFSheet sheetAt = workbook.getSheetAt(0);
            for (Row row : sheetAt) {
                //首行（即表头）不读取
                if (row.getRowNum() == 0) {
                    continue;
                }
                String name = row.getCell(0).getStringCellValue();
                double collegeid = row.getCell(1).getNumericCellValue();
                int collegeID = (int)collegeid;
                Teacher teacher = new Teacher();
                teacher.setName(name);
                College college = new College();
                college.setId(collegeID);
                teacher.setCollege(college);
                String key = "Shin Megami Tensei";
                String password = "123456";
                teacher.setPassword(MD5.md5(password,key));
                list.add(teacher);
            }
            //5、关闭流
            workbook.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Teacher i:list){
            teacherService.add(i);
        }
        return Result.success();
    }
    //修改密码
    @PostMapping("/editPassword/{password}")
    public Object editPassword(HttpSession session,@PathVariable("password") String password)throws Exception{
        Teacher teacher = (Teacher)session.getAttribute("teacher");
        Admin admin = (Admin)session.getAttribute("admin");
        Student student = (Student)session.getAttribute("student");
        String key = "Shin Megami Tensei";
        String md5 = MD5.md5(password,key);
        if(null!=teacher){
            teacher.setPassword(md5);
            teacherService.add(teacher);
            session.removeAttribute("teacher");
            session.setAttribute("teacher",teacher);
        }
        else if (null!=admin){
            admin.setPassword(md5);
            adminService.update(admin);
            session.removeAttribute("admin");
            session.setAttribute("admin",admin);

        }
        else if (null!=student){
            student.setPassword(md5);
            studentService.update(student);
            session.removeAttribute("student");
            session.setAttribute("student",student);

        }
        return null;
    }
}
