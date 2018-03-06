package com.hildebrandt.uni.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Lecture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String topic;

    /*
    @ManyToMany(mappedBy = "lectures")
    private Set<Student> students = new HashSet<>();*/

    public Lecture(){}

    public Lecture(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    /*
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }*/
}
