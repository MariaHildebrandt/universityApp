package com.hildebrandt.uni.controllers;

import com.hildebrandt.uni.services.StudentService;
import org.springframework.stereotype.Controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Controller
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping({ "/students"})
    public String getIndexPage(Model model) {
        model.addAttribute("students", studentService.getStudents());
        return "students/index";
    }

    @GetMapping("/student/{id}/show")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("student", studentService.findById(new Long(id)));
        return "students/show";
    }


    @GetMapping("student/{id}/delete")
    public String deleteById(@PathVariable String id){

        log.debug("Deleting id: " + id);

        studentService.deleteById(Long.valueOf(id));
        return "redirect:/students";
    }

    @GetMapping("/student/{id}/edit")
    public String editById(@PathVariable String id, Model model){
        model.addAttribute("student", studentService.findById(new Long(id)));
        return "students/edit";
    }


    @RequestMapping(value = "/student/new", method = RequestMethod.GET)
    public String newStudent() {
        return "students/new";
    }

}
