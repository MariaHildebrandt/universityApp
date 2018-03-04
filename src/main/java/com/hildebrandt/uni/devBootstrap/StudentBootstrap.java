package com.hildebrandt.uni.devBootstrap;


import com.hildebrandt.uni.domain.*;
import com.hildebrandt.uni.repositories.LectureRepository;
import com.hildebrandt.uni.repositories.StudentRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final StudentRepository studentRepository;
    private final LectureRepository lectureRepository;

    public StudentBootstrap(StudentRepository studentRepository, LectureRepository lectureRepository) {
        this.studentRepository = studentRepository;
        this.lectureRepository = lectureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent){
        lectureRepository.saveAll(getLectures());
        studentRepository.saveAll(getStudents());
    }

    private List<Student> getStudents(){
        List<Student> students = new ArrayList<>(2);

        Student Richard = new Student("Richard", "Holz", 178230);
        Student Lisa = new Student("Lisa", "Schwenzfeier", 175530);
        /*
        Lecture math = new Lecture("Math");
        Lecture physics = new Lecture("Physics");
        Lecture programming = new Lecture("Programming");

        Richard.getLectures().add(math);
        Richard.getLectures().add(physics);

        Lisa.getLectures().add(programming);*/

        students.add(Richard);
        students.add(Lisa);

        return students;
    }

    private List<Lecture> getLectures(){
        List<Lecture> lectures = new ArrayList<>(3);

        Lecture math = new Lecture("Math");
        Lecture physics = new Lecture("Physics");
        Lecture programming = new Lecture("Programming");

        /*
        Richard.getLectures().add(math);
        Richard.getLectures().add(physics);

        Lisa.getLectures().add(programming);*/

        lectures.add(math);
        lectures.add(physics);
        lectures.add(programming);

        return lectures;
    }
}
