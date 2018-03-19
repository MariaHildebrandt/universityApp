package com.hildebrandt.uni.services;

import com.hildebrandt.uni.domain.Student;

import java.util.Set;

public interface StudentService {
    Set<Student> getStudents();

    Student findById(Long id);

    void deleteById(Long idToDelete);

    void updateStudent(Student student);

    void newStudent(Student student);
}
