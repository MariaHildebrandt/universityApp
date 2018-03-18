package com.hildebrandt.uni.controllers;

import com.hildebrandt.uni.domain.Student;
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

    //SHOW ALL STUDENTS
    @RequestMapping({ "/students"})
    public String getIndexPage(Model model) {
        model.addAttribute("students", studentService.getStudents());
        return "students/index";
    }

    //wie CREATE?
    @PostMapping({"/student/new"})
    public String newStudent() {
        return "students/new";
    }

    //READ
    //sollte hier nicht "Long.valueOf(id)" stehen?
    @GetMapping("/student/{id}/show")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("student", studentService.findById(new Long(id)));
        return "students/show";
    }

    //wie UPDATE?
    @GetMapping("student/{id}/update")
    public String editStudentById(@PathVariable String id, Model model){
        Student student = studentService.findById(Long.valueOf(id));
        model.addAttribute("student", studentService.editStudent(student));
        return "students/edit";
    }

    //DELETE
    @GetMapping("student/{id}/delete")
    public String deleteStudentById(@PathVariable String id){
        log.debug("Deleting id: " + id);
        studentService.deleteById(Long.valueOf(id));
        return "redirect:/students";
    }
}
