package com.itbaizhan.controller;

import com.itbaizhan.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    private SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
    @RequestMapping("/student")
    public String getStudent(HttpServletRequest request) throws ParseException {
        Student stu0 = new Student("张三",78,sf.parse("2009-12-3"));
        Student stu1 = new Student("里斯",56,sf.parse("2003-2-23"));
        Student stu2 = new Student("王五",26,sf.parse("2013-2-4"));

        List<Student> students = new ArrayList<>();
        students.add(stu0);
        students.add(stu1);
        students.add(stu2);

        request.setAttribute("list",students);

        return "show";


    }
}
