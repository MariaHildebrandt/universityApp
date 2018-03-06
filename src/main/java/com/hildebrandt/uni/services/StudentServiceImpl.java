package com.hildebrandt.uni.services;

import com.hildebrandt.uni.domain.Student;
import com.hildebrandt.uni.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository = studentRepository;
    }

    @Override
    public Set<Student> getStudents(){
        Set<Student> studentSet = new HashSet<>();

        studentRepository.findAll().iterator().forEachRemaining(studentSet::add);
        return studentSet;
    }

    @Override
    public Student findById(Long id) {

        Optional<Student> studentOptional = studentRepository.findById(id);

        if (!studentOptional.isPresent()) {
            throw new RuntimeException("Student Not Found!");
        }

        return studentOptional.get();
    }

    @Override
    public void deleteById(Long idToDelete) {
        //StudentRepository.deleteById(idToDelete);
    }


}
