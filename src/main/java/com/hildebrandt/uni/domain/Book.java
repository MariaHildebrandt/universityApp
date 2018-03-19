package com.hildebrandt.uni.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Calendar;
import java.util.Date;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    private String title;

    @NotEmpty
    private String author;

    @NotEmpty
    private String category;

    @Column(name = "Year")
    @DateTimeFormat(pattern = "yyyy")
    private Date dateField;

    @Lob
    private String description;

    public Book(){}

    public Book(@NotEmpty String title, @NotEmpty String author, @NotEmpty String category, Date dateField, String description) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.dateField = dateField;
        this.description = description;
    }

    public Book(@NotEmpty String title, @NotEmpty String author, @NotEmpty String category, String description) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateField() {
        return dateField;
    }

    public void setDateField(Date dateField) {
        this.dateField = dateField;
    }
}
