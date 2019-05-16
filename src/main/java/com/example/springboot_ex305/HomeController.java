package com.example.springboot_ex305;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {
    @Autowired
    StudentRepository studentRepository;

    @Autowired
    CourseRepository courseRepository;

    @RequestMapping("/")
    public String index(Model model) {
        //First let's create the student
        Student student = new Student();
        student.setFirstname("Rekha");
        student.setLastname("Mundhra");

        //Now let's create a course
        Course course = new Course();
        course.setCoursename("Physics");
        course.setCredits(3);
        course.setDescription("Speed, Velocity and Acceleration");

        //Add the course to an empty list
        Set<Course> courses = new HashSet<Course>();
        courses.add(course);

        //Add the list of courses to the student's course list
        student.setCourses(courses);

        //Add the student to the database
        studentRepository.save(student);

        //Add the course to the list of courses
        courseRepository.save(course);

        //Get all the students from the database and send them to
        //the template
        model.addAttribute("students", studentRepository.findAll());
        return "index";

    }
}
