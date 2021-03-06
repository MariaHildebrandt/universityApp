package com.hildebrandt.uni.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private Integer matrikelnumber;
    private String gender;

    /*@ManyToMany
    @JoinTable(name="student_lecture",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "lecture_id"))
    private Set<Lecture> lectures = new HashSet<>();*/

    public Student(){}

    public Student(String firstName, String lastName, Integer matrikelnumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.matrikelnumber = matrikelnumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getMatrikelnumber() {
        return matrikelnumber;
    }

    public void setMatrikelnumber(Integer matrikelnumber) {
        this.matrikelnumber = matrikelnumber;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    /*
    public Set<Lecture> getLectures() {
        return lectures;
    }

    public void setLectures(Set<Lecture> lectures) {
        this.lectures = lectures;
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(lastName, student.lastName) &&
                Objects.equals(matrikelnumber, student.matrikelnumber) &&
                Objects.equals(gender, student.gender);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", matrikelnumber=" + matrikelnumber +
                ", gender='" + gender + '\'' +
                '}';
    }
}
