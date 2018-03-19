package com.hildebrandt.uni.controllers;

import com.hildebrandt.uni.domain.Student;
import com.hildebrandt.uni.exception.ResourceNotFoundException;
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
    @GetMapping({ "/students"})
    public String getIndexPage(Model model) {
        model.addAttribute("students", studentService.getStudents());
        return "students/index";
    }

    //NEW
    @RequestMapping(path = "/student/new", method = RequestMethod.GET)
    public String newProduct(Model model) {
        model.addAttribute("student", new Student());
        return "students/new";
    }

    //CREATE
    @RequestMapping(path = "/student/create", method = RequestMethod.POST)
    public String createProduct(Student student) {
        System.out.println("Creating Student in Conroller" + student.getFirstName());

        /*
        if(userService.isUserExist(user)){
            System.out.println("A User with name "+user.getName()+" already exist");
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
         */

        studentService.newStudent(student);
        return "redirect:/students";
    }


    //READ
    //sollte hier nicht "Long.valueOf(id)" stehen?
    @GetMapping("/student/{id}/show")
    public String showById(@PathVariable String id, Model model){
        model.addAttribute("student", studentService.findById(new Long(id)));
        return "students/show";
    }

    //EDIT
    @GetMapping("student/{id}/edit")
    public String editStudentById(@PathVariable Long id, Model model){
        model.addAttribute("student", studentService.findById(id));
        return "students/edit";
    }

    //UPDATE
    @RequestMapping(path = "student/{id}/update", method = RequestMethod.POST)
    public String updateStudent(@PathVariable Long id, Student student) {

        Student currentStudent = studentService.findById(id);//.orElseThrow(() -> new ResourceNotFoundException("Student", "id", id));

        currentStudent.setFirstName(student.getFirstName());
        currentStudent.setLastName(student.getLastName());
        currentStudent.setMatrikelnumber(student.getMatrikelnumber());
        currentStudent.setGender(student.getGender());

        studentService.updateStudent(currentStudent);
        return "redirect:/students";
    }


    //DELETE
    @DeleteMapping("student/{id}/delete")
    public String deleteStudentById(@PathVariable String id){
        log.debug("Deleting id: " + id);
        studentService.deleteById(Long.valueOf(id));
        return "redirect:/students";
    }
}
