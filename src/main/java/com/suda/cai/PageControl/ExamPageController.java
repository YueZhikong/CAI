package com.suda.cai.PageControl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExamPageController {
    //题库管理
    //新增单选题
    @GetMapping(value = "editSingleChoice")
    public String editSingleChoice(){
        return "Exam/addProblem/editSingleChoice";
    }
    //新增填空题
    @GetMapping(value = "editCompletion")
    public String editCompletion(){
        return "Exam/addProblem/editCompletion";
    }
    //新增判断题
    @GetMapping(value = "editJudgement")
    public String editJudgement(){
        return "Exam/addProblem/editJudgement";
    }
    //新增简答题
    @GetMapping(value = "editShortAnswer")
    public String editShortAnswer(){
        return "Exam/addProblem/editShortAnswer";
    }
    //新增操作题
    @GetMapping(value = "editOperation")
    public String editOperation(){
        return "Exam/addProblem/editOperation";
    }

    //试卷管理
    @GetMapping(value = "buildExam")
    public String buildExam(){
        return "Exam/buildExam/buildExam";
    }
    @GetMapping(value = "configureSingleChoice")
    public String configureSingleChoice(){
        return "Exam/buildExam/configureSingleChoice";
    }
    @GetMapping(value = "configureCompletion")
    public String configureCompletion(){
        return "Exam/buildExam/configureCompletion";
    }
    @GetMapping(value = "configureJudgement")
    public String configureJudgement(){
        return "Exam/buildExam/configureJudgement";
    }
    @GetMapping(value = "configureShortAnswer")
    public String configureShortAnswer(){
        return "Exam/buildExam/configureShortAnswer";
    }
    @GetMapping(value = "configureOperation")
    public String configureOperation(){
        return "Exam/buildExam/configureOperation";
    }

    //考试管理
    //发卷
    @GetMapping(value = "sendExam")
    public String sendExam(){
        return "Exam/onlineExam/sendExam";
    }
    //在线考试
    @GetMapping(value = "onlineExam")
    public String studentExam(){
        return "Exam/onlineExam/onlineExam";
    }
    @GetMapping(value = "studentSingleChoice")
    public String studentSingleChoice(){
        return "Exam/onlineExam/SingleChoice";
    }
    @GetMapping(value = "studentCompletion")
    public String studentCompletion(){
        return "Exam/onlineExam/Completion";
    }
    @GetMapping(value = "studentJudgement")
    public String studentJudgement(){
        return "Exam/onlineExam/Judgement";
    }
    @GetMapping(value = "studentShortAnswer")
    public String studentShortAnswer(){
        return "Exam/onlineExam/ShortAnswer";
    }
    @GetMapping(value = "studentOperation")
    public String studentOperation(){
        return "Exam/onlineExam/Operation";
    }

    //批阅试卷
    @GetMapping(value = "/teacherMark")
    public String teacherMark(){
        return "Exam/markExam/mark";
}
    @GetMapping(value ="/markCompletion" )
    public String markCompletion(){
        return "Exam/markExam/markCompletion";
    }
    @GetMapping(value ="/markShortAnswer" )
    public String markShortAnswer(){
        return "Exam/markExam/markShortAnswer";
    }
    @GetMapping(value ="/markOperation" )
    public String markOperation(){
        return "Exam/markExam/markOperation";
    }

    @GetMapping(value = "/achievement")
    public String achievement(){
        return "Exam/markExam/achievement";
    }
    //修改问题
    @GetMapping(value = "updateSingleChoice")
    public String updateSingleChoice(){
        return "Exam/addProblem/updateSingleChoice";
    }
    @GetMapping(value = "updateCompletion")
    public String updateCompletion(){
        return "Exam/addProblem/updateCompletion";
    }
    @GetMapping(value = "updateJudgement")
    public String updateJudgement(){
        return "Exam/addProblem/updateJudgement";
    }
    @GetMapping(value = "updateShortAnswer")
    public String updateShortAnswer(){
        return "Exam/addProblem/updateShortAnswer";
    }
    @GetMapping(value = "updateOperation")
    public String updateOperation(){
        return "Exam/addProblem/updateOperation";
    }
}
