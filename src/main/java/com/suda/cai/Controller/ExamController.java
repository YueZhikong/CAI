package com.suda.cai.Controller;

import com.suda.cai.pojo.*;
import com.suda.cai.service.*;
import com.suda.cai.util.ImageUtil;
import com.suda.cai.util.Similarity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
public class ExamController {
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
    //题库管理
    @PostMapping("/adminEditSingleChoice/{courseID}/{chapterID}/{knowledgepointID}")
    public Object editSingleChoice(@PathVariable("courseID") int courseID, @PathVariable("chapterID") int chapterID, @PathVariable("knowledgepointID")int knowledgepointID, Problem problem, MultipartFile file, HttpServletRequest request, HttpSession session)throws Exception{
        Course course = new Course();
        course.setId(courseID);
        Chapter chapter = new Chapter();
        chapter.setId(chapterID);
        Knowledgepoint knowledgepoint = new Knowledgepoint();
        knowledgepoint.setId(knowledgepointID);
        Admin admin = (Admin)session.getAttribute("admin");
        String adminName = admin.getName();
        problem.setAuthor(adminName);
        problem.setType(1);
        problem.setCourse(course);
        problem.setChapter(chapter);
        problem.setKnowledgepoint(knowledgepoint);
        problemService.add(problem);
        saveOrUpdateImageFile(problem, file, request);
        return null;
    }
    @PostMapping("/adminEditCompletion/{courseID}/{chapterID}/{knowledgepointID}")
    public Object editCompletion(@PathVariable("courseID") int courseID,@PathVariable("chapterID") int chapterID,@PathVariable("knowledgepointID")int knowledgepointID, Problem problem, MultipartFile file, HttpServletRequest request,HttpSession session)throws Exception{
        Course course = new Course();
        course.setId(courseID);
        Chapter chapter = new Chapter();
        chapter.setId(chapterID);
        Knowledgepoint knowledgepoint = new Knowledgepoint();
        knowledgepoint.setId(knowledgepointID);
        Admin admin = (Admin)session.getAttribute("admin");
        String adminName = admin.getName();
        problem.setAuthor(adminName);
        problem.setType(2);
        problem.setCourse(course);
        problem.setChapter(chapter);
        problem.setKnowledgepoint(knowledgepoint);
        problemService.add(problem);
        saveOrUpdateImageFile(problem, file, request);
        return null;
    }
    @PostMapping("/adminEditJudgement/{courseID}/{chapterID}/{knowledgepointID}")
    public Object editJudgement(@PathVariable("courseID") int courseID,@PathVariable("chapterID") int chapterID,@PathVariable("knowledgepointID")int knowledgepointID, Problem problem, HttpServletRequest request,HttpSession session)throws Exception{
        Course course = new Course();
        course.setId(courseID);
        Chapter chapter = new Chapter();
        chapter.setId(chapterID);
        Knowledgepoint knowledgepoint = new Knowledgepoint();
        knowledgepoint.setId(knowledgepointID);
        Admin admin = (Admin)session.getAttribute("admin");
        String adminName = admin.getName();
        problem.setAuthor(adminName);
        problem.setType(3);
        problem.setCourse(course);
        problem.setChapter(chapter);
        problem.setKnowledgepoint(knowledgepoint);
        problemService.add(problem);
        return null;
    }
    @PostMapping("/adminEditShortAnswer/{courseID}/{chapterID}/{knowledgepointID}")
    public Object editShortAnswer(@PathVariable("courseID") int courseID,@PathVariable("chapterID") int chapterID,@PathVariable("knowledgepointID")int knowledgepointID, Problem problem, MultipartFile file, HttpServletRequest request,HttpSession session)throws Exception{
        Course course = new Course();
        course.setId(courseID);
        Chapter chapter = new Chapter();
        chapter.setId(chapterID);
        Knowledgepoint knowledgepoint = new Knowledgepoint();
        knowledgepoint.setId(knowledgepointID);
        Admin admin = (Admin)session.getAttribute("admin");
        String adminName = admin.getName();
        problem.setAuthor(adminName);
        problem.setType(4);
        problem.setCourse(course);
        problem.setChapter(chapter);
        problem.setKnowledgepoint(knowledgepoint);
        problemService.add(problem);
        saveOrUpdateImageFile(problem, file, request);
        return null;
    }
    private void saveOrUpdateImageFile(Problem bean, MultipartFile image, HttpServletRequest request)
            throws IOException {
        File imageFolder= new File(request.getServletContext().getRealPath("img/exam"));
        File file = new File(imageFolder,bean.getId()+".jpg");
        if(!file.getParentFile().exists())
            file.getParentFile().mkdirs();
        image.transferTo(file);
        BufferedImage img = ImageUtil.change2jpg(file);
        ImageIO.write(img, "jpg", file);
    }
    @PostMapping("/adminEditOperation/{courseID}/{chapterID}/{knowledgepointID}")
    public Object editOperstion(@PathVariable("courseID") int courseID, @PathVariable("chapterID") int chapterID, @PathVariable("knowledgepointID")int knowledgepointID, Problem problem, @RequestParam("file") MultipartFile file, @RequestParam("file2") MultipartFile file2, HttpServletRequest request, HttpSession session)throws Exception{
        Course course = new Course();
        course.setId(courseID);
        Chapter chapter = new Chapter();
        chapter.setId(chapterID);
        Knowledgepoint knowledgepoint = new Knowledgepoint();
        knowledgepoint.setId(knowledgepointID);
        Admin admin = (Admin)session.getAttribute("admin");
        String adminName = admin.getName();
        problem.setAuthor(adminName);
        problem.setType(5);
        problem.setCourse(course);
        problem.setChapter(chapter);
        problem.setKnowledgepoint(knowledgepoint);
        problemService.add(problem);
        String path = "/file/exam";
        String fileName = file.getOriginalFilename();
        String fileName2 = file2.getOriginalFilename();
        fileName = problem.getId()+ "question"+fileName;
        problem.setQuestionFileName(fileName);
        fileName2 = problem.getId()+ "answer"+fileName2;
        problem.setAnswerFileName(fileName2);
        problemService.update(problem);
        File Folder= new File(request.getServletContext().getRealPath(path));
        File dest = new File(Folder,fileName);
        File dest2 = new File(Folder,fileName2);
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
        // 检测是否存在目录
        if (!dest2.getParentFile().exists()) {
            dest2.getParentFile().mkdirs();
        }
        try {
            file2.transferTo(dest2);
        } catch (IllegalStateException c) {
            c.printStackTrace();
        } catch (IOException c) {
            c.printStackTrace();
        }
        return null;
    }
    //试卷管理

    @PostMapping("/addExam")
    public Object addExam(@RequestBody Exam exam) throws Exception{
//        System.out.println(exam.toString());
        examService.add(exam);
        return exam;
    }
    @DeleteMapping("/deleteExam/{examID}")
    public Object delete(@PathVariable("examID") int examID){
        examService.delete(examID);
        return null;
    }
    @GetMapping("/listExam/{courseID}")
    public List<Exam> listExames(@PathVariable("courseID") int courseID) throws Exception{
        Course course = new Course();
        course.setId(courseID);
        return examService.findByCourse(course);
    }
        //试卷配置
        //获取章名
        @GetMapping("/configure/listChapter/{examID}")
        public List<Chapter> getChapter(@PathVariable("examID") int examID) throws Exception{
            return chapterService.findByCourse(examService.get(examID).getCourse());
        }
    //获取节名
    @GetMapping("/configure/listKnowledgepoint/{chapterID}")
    public List<Knowledgepoint> getPoint(@PathVariable("chapterID") int chapterID) throws Exception{
        if (chapterID!=0){
            Chapter chapter = new Chapter();
            chapter.setId(chapterID);
            return knowledgepointService.findByChapter(chapter);
        }
        else {
            return null;
        }
    }
    //返回题目
    @GetMapping("/configure/listProblem/{examID}/{chapterID}/{knowledgepointID}/{type}")
    public List<Problem> listProblem(@PathVariable("examID") int examID,@PathVariable("chapterID") int chapterID, @PathVariable("knowledgepointID") int knowledgepointID,@PathVariable("type") int type)throws Exception{

        ArrayList<Problem> problems = new ArrayList<>();
        Exam exam = new Exam();
        exam.setId(examID);
        if (chapterID==0){
            Course course = examService.get(examID).getCourse();
            problems = (ArrayList<Problem>) problemService.findByCourse(course,type);
        }
        else{
            if(knowledgepointID==0){
                Chapter chapter = new Chapter();
                chapter.setId(chapterID);
                problems = (ArrayList<Problem>) problemService.findByChapter(chapter,type);
            }
            else {
                Knowledgepoint knowledgepoint = new Knowledgepoint();
                knowledgepoint.setId(knowledgepointID);
                problems = (ArrayList<Problem>) problemService.findByKnowledgepoint(knowledgepoint,type);
            }
        }
        for(Problem problem:problems){
            ExamContent examContent=examContentService.findByExamAndProblem(exam,problem);
            if (examContent==null){
                problem.setChosed(0);
            }
            else {
                problem.setChosed(examContent.getId());
            }
        }
        return problems;
    }
    @GetMapping("/configure/listChose/{examID}/{chapterID}/{knowledgepointID}/{type}")
    public ArrayList<Integer> listChose(@PathVariable("examID") int examID,@PathVariable("chapterID") int chapterID, @PathVariable("knowledgepointID") int knowledgepointID,@PathVariable("type") int type)throws Exception{
        ArrayList<Integer> chose = new ArrayList<>();
        ArrayList<Problem> problems = new ArrayList<>();
        Exam exam = new Exam();
        exam.setId(examID);
        if (chapterID==0){
            Course course = examService.get(examID).getCourse();
            problems = (ArrayList<Problem>) problemService.findByCourse(course,type);
        }
        else{
            if(knowledgepointID==0){
                Chapter chapter = new Chapter();
                chapter.setId(chapterID);
                problems = (ArrayList<Problem>) problemService.findByChapter(chapter,type);
            }
            else {
                Knowledgepoint knowledgepoint = new Knowledgepoint();
                knowledgepoint.setId(knowledgepointID);
                problems = (ArrayList<Problem>) problemService.findByKnowledgepoint(knowledgepoint,type);
            }
        }
        for(Problem problem:problems){
            ExamContent examContent=examContentService.findByExamAndProblem(exam,problem);
            if (examContent==null){
                problem.setChosed(0);
            }
            else {
                problem.setChosed(examContent.getId());
                chose.add(problem.getId());
            }
        }
        return chose;
    }
    //保存选择结果
    @PostMapping("/configure/save/{examID}/{problemID}/{type}")
    public Object save(@PathVariable("examID") int examID,@PathVariable("problemID") int problemID,@PathVariable("type") int type)throws Exception{

        Exam exam = new Exam();
        exam.setId(examID);
        Problem problem = new Problem();
        problem.setId(problemID);
        ExamContent examContent = examContentService.findByExamAndProblem(exam,problem);
        if (examContent ==null){
            ExamContent a = new ExamContent();
            a.setExam(exam);
            a.setProblem(problem);
            a.setType(type);
            examContentService.add(a);
        }
        return examContent;
    }

    //考试管理
    //发卷
    //返回班级
    @GetMapping("/sendExam/listClasses")
    public List<Classes> listClassess(HttpSession session) throws Exception{
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        return classesService.findByTeacher(teacher);
    }
    //返回试卷
    @GetMapping("/sendExam/listExam/{classesID}")
    public List<Exam> listExams(@PathVariable("classesID") int classesID) throws Exception{
        Classes classes = classesService.get(classesID);
        Course course = classes.getCourse();
        return examService.findByCourse(course);
    }

    //返回examstudent列表
    @GetMapping("/sendExam/listExamStudent/{classesID}/{examID}")
    public List<ExamStudent> examStudents(@PathVariable("classesID") int classesID,@PathVariable("examID") int examID) throws Exception{
        Classes classes = classesService.get(classesID);
        Exam exam = examService.get(examID);
        Exam exam1 = new Exam();
        exam1.setName(" ");
        ArrayList<ExamStudent> examStudents = new ArrayList<>();
        ArrayList<StudentToClasses> studentToClasses = (ArrayList<StudentToClasses>) studentToClassesService.findByClasses(classes);
        for (StudentToClasses i:studentToClasses){
            Student student = i.getStudent();
            ExamStudent examStudent = examStudentService.findByExamAndClassesAndStudent(exam,classes,student);
            if (examStudent==null){
                ExamStudent examStudent1 = new ExamStudent();
                examStudent1.setClasses(classes);
                examStudent1.setExam(exam1);
                examStudent1.setStudent(student);
                examStudents.add(examStudent1);
            }
            else {
                examStudents.add(examStudent);
            }
        }
        return examStudents;
    }

    //设置考试类型
    @PostMapping("/sendExam/confType/{examID}/{classesID}/{studentID}/{type}/{duration}")
    public Object confType(@PathVariable("examID") int examID, @PathVariable("classesID") int classesID,@PathVariable("studentID") int studentID,@PathVariable("type") int type,@PathVariable("duration") long duration)throws Exception{
        ExamStudent examStudent = isExamstudentExist(examID,classesID,studentID);
        if(examStudent.isJudge()){
            if (type==0){
                examStudent.setType(type);
                examStudent.setDuration(0);
                examStudent.setCreatetime(null);
                examStudent.setDeadtime(null);
                examStudentService.update(examStudent);

            }
            else {
                examStudent.setType(type);
                Date createtime = new Date();
                examStudent.setCreatetime(createtime);
                examStudent.setDuration(duration);
                Date deadtime = new Date(createtime.getTime()+ duration*60*1000);
                System.out.println(deadtime);
                examStudent.setDeadtime(deadtime);
                examStudentService.update(examStudent);
            }
            return examStudent;
        }else {
            return null;
        }
    }

    //设置是否允许在线考试
    @PostMapping("/sendExam/confJoinExam/{examID}/{classesID}/{studentID}/{joinexam}")
    public Object confJoinExam(@PathVariable("examID") int examID, @PathVariable("classesID") int classesID,@PathVariable("studentID") int studentID,@PathVariable("joinexam") int joinexam)throws Exception{
        ExamStudent examStudent = isExamstudentExist(examID,classesID,studentID);
        if (examStudent.isJudge()){
            examStudent.setJoinexam(joinexam);
            examStudentService.update(examStudent);
            return examStudent;
        }
        else {
            return null;
        }
    }

    //设置是否学生查询成绩
    @PostMapping("/sendExam/confInquiry/{examID}/{classesID}/{studentID}/{inquiry}")
    public Object confInquiry(@PathVariable("examID") int examID, @PathVariable("classesID") int classesID,@PathVariable("studentID") int studentID,@PathVariable("inquiry") int inquiry)throws Exception{
        ExamStudent examStudent = isExamstudentExist(examID,classesID,studentID);
        if (examStudent.isJudge()){
            examStudent.setInquiry(inquiry);
            examStudentService.update(examStudent);
            return examStudent;
        }
        else {
            return null;
        }
    }

    //发卷
    @PostMapping("/sendExam/{examID}/{classesID}/{studentID}")
    public Object sendExam(@PathVariable("examID") int examID, @PathVariable("classesID") int classesID,@PathVariable("studentID") int studentID)throws Exception{
        ExamStudent examStudent = isExamstudentExist(examID,classesID,studentID);
        if (examStudent.isJudge()){
            return null;
        }
        else {
            examStudentService.add(examStudent);
            return examStudent;
        }
    }

    //判断examstudent是否存在
    private ExamStudent isExamstudentExist(int examID, int classesID,int studentID){
        Exam exam = new Exam();
        exam.setId(examID);
        Classes classes = new Classes();
        classes.setId(classesID);
        Student student = new Student();
        student.setId(studentID);
        ExamStudent examStudent = new ExamStudent();
        examStudent.setExam(exam);
        examStudent.setClasses(classes);
        examStudent.setStudent(student);
        ExamStudent examStudent1 = examStudentService.findByExamAndClassesAndStudent(exam,classes,student);
        if (examStudent1==null){
            examStudent.setJudge(false);
            return examStudent;
        }
        else {
            examStudent1.setJudge(true);
            return examStudent1;
        }
    }

    //学生在线考试
    //判断对应的考试
    @GetMapping("/exam")
    public Object checktype(HttpSession session)throws Exception{
        Student student = (Student)session.getAttribute("student");
        Classes classes = (Classes)session.getAttribute("classes");
        ArrayList<ExamStudent> examStudents = examStudentService.findByStudentAndClasses(student,classes);
        if(examStudents.size()==0){
            return null;
        }
        else {
            ExamStudent examStudent = examStudents.get(0);
            checkStudentAnswer(examStudent);
            return examStudent;
        }
    }

    //返回题目
    @GetMapping("/exam/listStudentAnswer/{examID}/{type}")
    public ArrayList<StudentAnswer> listStudentAnswer(@PathVariable("examID") int examID,@PathVariable("type")int type, HttpSession session) throws Exception{
        Exam exam = new Exam();
        exam.setId(examID);
        Student student = (Student)session.getAttribute("student");
        Classes classes = (Classes)session.getAttribute("classes");
        ExamStudent examStudent = examStudentService.findByExamAndClassesAndStudent(exam,classes,student);
        int Examtype = examStudent.getType();
        if (Examtype==1){
            Date deadtime = examStudent.getDeadtime();
            Date now = new Date();
            long sub = now.getTime() - deadtime.getTime();
            if (sub > 0){
                return null;
            }
            else {
                return studentAnswerService.findByExamAndStudentAndClassesAndType(exam,student,classes,type);

            }
        }else {
            return studentAnswerService.findByExamAndStudentAndClassesAndType(exam,student,classes,type);
        }
    }
    //返回examstudent
    @GetMapping("/exam/listExamStudent/{examID}")
    public ExamStudent listExamStudent(@PathVariable("examID")int examID,HttpSession session)throws Exception{
        Student student = (Student)session.getAttribute("student");
        Classes classes = (Classes)session.getAttribute("classes");
        Exam exam = new Exam();
        exam.setId(examID);
        return examStudentService.findByExamAndClassesAndStudent(exam,classes,student);
    }
    //返回答案
    @GetMapping("/exam/listAnswer/{examID}/{type}")
    public ArrayList<String> listAnswer(@PathVariable("examID") int examID,@PathVariable("type")int type, HttpSession session)throws Exception{
        ArrayList<String> answers = new ArrayList<>();
        Exam exam = new Exam();
        exam.setId(examID);
        Student student = (Student)session.getAttribute("student");
        Classes classes = (Classes)session.getAttribute("classes");
        ArrayList<StudentAnswer> studentAnswers = studentAnswerService.findByExamAndStudentAndClassesAndType(exam,student,classes,type);
        for (StudentAnswer studentAnswer:studentAnswers){
            String answer = studentAnswer.getAnswer();
            answers.add(answer);
        }
        ExamStudent examStudent = examStudentService.findByExamAndClassesAndStudent(exam,classes,student);
        int Examtype = examStudent.getType();
        if (Examtype==1){
            Date deadtime = examStudent.getDeadtime();
            Date now = new Date();
            long sub = now.getTime() - deadtime.getTime();
            if (sub > 0){
                return null;
            }
            else {
                return answers;

            }
        }else {
            return answers;
        }
    }
    //提交答案
    @PostMapping("/exam/saveStudentAnswer/{studentanswerID}/{answer}")
    public Object saveAnswer(@PathVariable("studentanswerID") int studentanswerID,@PathVariable("answer") String answer) throws Exception{
        StudentAnswer studentAnswer = studentAnswerService.get(studentanswerID);
        studentAnswer.setAnswer(answer);
        studentAnswerService.update(studentAnswer);
        return studentAnswer;
    }
    //提交操作题答案
    @PostMapping("/exam/saveAnswer/{studentanswerID}")
    public Object save(@PathVariable("studentanswerID") int studentanswerID, @RequestParam("file") MultipartFile file, HttpServletRequest request)throws Exception{
        StudentAnswer studentAnswer = studentAnswerService.get(studentanswerID);
        System.out.println(studentAnswer.toString());
        //获取文件名
        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        fileName = studentanswerID + fileName;
        String path = "file/answers";
        File Folder= new File(request.getServletContext().getRealPath(path));
        File dest = new File(Folder,fileName);
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
        studentAnswer.setAnswer(fileName);
        studentAnswerService.update(studentAnswer);
        return studentAnswer;
    }
    //检查studentanswer是否存在，不存在则生成空白的studentanswer
    private void checkStudentAnswer(ExamStudent examStudent){
        Exam exam = examStudent.getExam();
        Student student = examStudent.getStudent();
        Classes classes = examStudent.getClasses();
        ArrayList<StudentAnswer> studentAnswers = studentAnswerService.findByExamAndStudentAndClasses(exam,student,classes);
        if (studentAnswers.size()==0){
            ArrayList<ExamContent> examContents = examContentService.findByExam(exam);
            for(ExamContent i:examContents){
                StudentAnswer studentAnswer = new StudentAnswer();
                Problem problem = i.getProblem();
                int type = problem.getType();
                studentAnswer.setExam(exam);
                studentAnswer.setStudent(student);
                studentAnswer.setClasses(classes);
                studentAnswer.setProblem(problem);
                studentAnswer.setType(type);
                studentAnswerService.add(studentAnswer);
            }
        }
    }

    //批阅试卷
    //返回班级
    @GetMapping("/markExam/listClasses")
    public List<Classes> listClasses(HttpSession session) throws Exception{
        Teacher teacher = (Teacher) session.getAttribute("teacher");
        return classesService.findByTeacher(teacher);
    }
    //返回试卷
    @GetMapping("/markExam/listExam/{classesID}")
    public List<Exam> listExam(@PathVariable("classesID") int classesID) throws Exception{
        Classes classes = classesService.get(classesID);
        Course course = classes.getCourse();
        return examService.findByCourse(course);
    }
    //返回achievement
    @GetMapping("/markExam/listAchievement/{examID}/{classesID}")
    public ArrayList<Achievement> listAchievement(@PathVariable("examID") int examID,@PathVariable("classesID") int classesID)throws Exception{
        Exam exam = examService.get(examID);
        Classes classes = classesService.get(classesID);
        ArrayList<Achievement> achievements = achievementService.findByExamAndClasses(exam,classes);
        if (achievements.size()==0){
            createAchievement(exam,classes);
            ArrayList<Achievement> achievementArrayList = achievementService.findByExamAndClasses(exam,classes);
            for (Achievement achievement:achievementArrayList){
                Student student = achievement.getStudent();
                correct(exam,student,1,classes);
                correct(exam,student,2,classes);
                correct(exam,student,3,classes);
                double score1 = calculation(1,exam,student,classes);
                achievement.setScore1(score1);
                double score2 = calculation(2,exam,student,classes);
                achievement.setScore2(score2);
                double score3 = calculation(3,exam,student,classes);
                achievement.setScore3(score3);
                double score4 = calculation(4,exam,student,classes);
                achievement.setScore4(score4);
                double score5 = calculation(5,exam,student,classes);
                achievement.setScore5(score5);
                achievement.setTotal(score1+score2+score3+score4+score5);
                achievementService.update(achievement);
            }
        }
        else{
            for (Achievement achievement:achievements){
                Student student = achievement.getStudent();
                correct(exam,student,1,classes);
                correct(exam,student,3,classes);
                double score1 = calculation(1,exam,student,classes);
                achievement.setScore1(score1);
                double score2 = calculation(2,exam,student,classes);
                achievement.setScore2(score2);
                double score3 = calculation(3,exam,student,classes);
                achievement.setScore3(score3);
                double score4 = calculation(4,exam,student,classes);
                achievement.setScore4(score4);
                double score5 = calculation(5,exam,student,classes);
                achievement.setScore5(score5);
                achievement.setTotal(score1+score2+score3+score4+score5);
                achievementService.update(achievement);
            }

        }
        return achievementService.findByExamAndClasses(exam,classes);
    }
    //返回studentanswer
    @GetMapping("/mark/listStudentAnswer/{examID}/{studentID}/{classesID}/{type}")
    public ArrayList<StudentAnswer> listStudentAnswer(@PathVariable("examID") int examID,@PathVariable("studentID") int studentID,@PathVariable("classesID") int classesID,@PathVariable("type") int type)throws Exception{
        Exam exam = new Exam();
        exam.setId(examID);
        Student student = new Student();
        student.setId(studentID);
        Classes classes = new Classes();
        classes.setId(classesID);
        return studentAnswerService.findByExamAndStudentAndClassesAndType(exam,student,classes,type);
    }
    //返回scores
    @GetMapping("/mark/listScore/{examID}/{studentID}/{classesID}/{type}")
    public ArrayList<Double> listScore(@PathVariable("examID") int examID,@PathVariable("studentID") int studentID,@PathVariable("classesID") int classesID,@PathVariable("type") int type)throws Exception{
        ArrayList<Double> scores = new ArrayList<>();
        Exam exam = new Exam();
        exam.setId(examID);
        Student student = new Student();
        student.setId(studentID);
        Classes classes = new Classes();
        classes.setId(classesID);
        ArrayList<StudentAnswer> studentAnswers = studentAnswerService.findByExamAndStudentAndClassesAndType(exam,student,classes,type);
        for (StudentAnswer studentAnswer:studentAnswers){
            scores.add(studentAnswer.getScore());
        }
        return scores;
    }
    //save StudentAnswer
    @PostMapping("/mark/saveStudentAnswer/{studentanswerID}/{score}")
    public Object save(@PathVariable("studentanswerID") int studentanswerID,@PathVariable("score") double score)throws Exception{
        StudentAnswer studentAnswer = studentAnswerService.get(studentanswerID);
        studentAnswer.setScore(score);
        studentAnswerService.update(studentAnswer);
        return studentAnswer;
    }
    //创造Achievement
    private void createAchievement(Exam exam,Classes classes){
        ArrayList<ExamStudent> examStudents = examStudentService.findByExamAndClasses(exam,classes);
        for(ExamStudent examStudent:examStudents){
            Achievement achievement = new Achievement();
            achievement.setExam(examStudent.getExam());
            achievement.setStudent(examStudent.getStudent());
            achievement.setClasses(examStudent.getClasses());
            achievementService.add(achievement);
        }
    }
    //根据类型、试卷、分值计算类型分值
    private double calculation(int type,Exam exam,Student student,Classes classes){
        ArrayList<StudentAnswer> studentAnswers = studentAnswerService.findByExamAndStudentAndClassesAndType(exam,student,classes,type);
        double sum = 0;
        for (StudentAnswer studentAnswer:studentAnswers){
            sum = sum + studentAnswer.getScore();
        }
        return sum;
    }
    //给已有的studentAnswer判断对错,并赋分
    private void correct(Exam exam,Student student,int type,Classes classes){
        double score;
        if (type==1){
            score = exam.getScore1();
        }
        else if(type == 2){
            score = exam.getScore2();
        }
        else if (type == 3){
            score = exam.getScore3();
        }
        else if (type == 4){
            score = exam.getScore4();
        }
        else {
            score = exam.getScore5();
        }
        ArrayList<StudentAnswer> studentAnswers = studentAnswerService.findByExamAndStudentAndClassesAndType(exam,student,classes,type);
        for (StudentAnswer studentAnswer:studentAnswers){
            //标准答案
            String answer1 = studentAnswer.getProblem().getAnswer();
            //学生答案
            String answer2 = studentAnswer.getAnswer();
            double similarity = Similarity.score(answer1,answer2);
            if (similarity>0.5){
                studentAnswer.setScore(score*similarity);
            }else {
                studentAnswer.setScore(0);
            }
            studentAnswerService.update(studentAnswer);
        }
    }
    @GetMapping("/listAchievement")
    public List<Achievement> achievementList(HttpSession session)throws Exception{
        Student student =(Student)session.getAttribute("student");
        Classes classes = (Classes)session.getAttribute("classes");
        ArrayList<Achievement> achievements = new ArrayList<>();
        ArrayList<ExamStudent> examStudents = examStudentService.findByStudentAndClasses(student,classes);
        for (ExamStudent examStudent:examStudents){
            if (examStudent.getInquiry()==1){
                achievements.add(achievementService.findByStudentAndClassesAndExam(student,classes,examStudent.getExam()));
            }
        }
        return achievements;
    }
}
