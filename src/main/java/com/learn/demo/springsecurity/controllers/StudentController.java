package com.learn.demo.springsecurity.controllers;

import com.learn.demo.springsecurity.pojo.Student;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/students")
public class StudentController {

    List<Student> students = new ArrayList<Student>();

    public StudentController() {
        this.students.add(new Student(1, "Aakanksha"));
        this.students.add(new Student(2, "Shiv"));
        this.students.add(new Student(3, "Ashish"));
        this.students.add(new Student(4, "Shreyash"));
    }

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable("studentId") final int studentId) throws Exception {
        return students.stream().filter(student -> student.getStudentId() == studentId).findFirst().orElseThrow(() -> new Exception("Invalid student id to retrieve"));
    }

}
