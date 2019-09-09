package com.suda.cai.Controller;

import com.suda.cai.pojo.College;
import com.suda.cai.service.*;
import com.suda.cai.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class CollegeController {

    @Autowired
    CollegeService collegeService;


    //学院管理
    @GetMapping("/listCollege")
    public List<College> listCollege()throws Exception{
        return collegeService.list();
    }
    @PostMapping("/addCollege")
    public Object addCollege(@RequestBody College college)throws Exception{
        collegeService.add(college);
        return Result.success();
    }
    @PutMapping("/updateCollege/{id}")
    public Object updateCollege(@PathVariable("id")int id,@RequestBody College college)throws Exception{
        college.setId(id);
        collegeService.update(college);
        return Result.success();
    }
    @DeleteMapping("/deleteCollege/{id}")
    public Object deleteCollege(@PathVariable("id")int id)throws Exception{
        collegeService.delete(id);
        return Result.success();
    }
}
