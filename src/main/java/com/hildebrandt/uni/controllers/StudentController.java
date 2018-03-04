package com.hildebrandt.uni.controllers;

import com.hildebrandt.uni.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @RequestMapping({"/students"})
    public String getStudentsPage(Model model){
        model.addAttribute("students", studentService.getStudents());
        return "students";
    }
}
