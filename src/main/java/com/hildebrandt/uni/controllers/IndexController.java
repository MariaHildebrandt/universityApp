package com.hildebrandt.uni.controllers;

import com.hildebrandt.uni.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

   private final StudentService studentService;

    public IndexController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndexPage(Model model) {
        model.addAttribute("students", studentService.getStudents());
        return "index";
    }



}
