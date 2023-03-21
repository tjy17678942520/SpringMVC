package edu.beuhua.controller;

import edu.beuhua.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {
    @RequestMapping("/list")
    @ResponseBody
    public List<Student> getStudent(String na){
        System.out.println(na);
        List<Student> arr = new ArrayList<>();
        arr.add(new Student("张三",67));
        arr.add(new Student("力三",37));
        arr.add(new Student("面夫",17));
        return arr;
    }
}
