package com.example.springboot_ex305;

import javax.persistence.*;
import java.util.Set;


@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String coursename;
    private String description;
    private int credits;

    @ManyToMany
    private Set<Student> students;

    public Course() {
    }

    public Course(String coursename, String description, int credits, Set<Student> students) {
        this.coursename = coursename;
        this.description = description;
        this.credits = credits;
        this.students = students;
    }


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
