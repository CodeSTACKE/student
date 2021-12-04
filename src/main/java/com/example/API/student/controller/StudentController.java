package com.example.API.student.controller;

import com.example.API.student.dto.Student;
import com.example.API.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentRepository studentRepo;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        return studentRepo.save(student);
    }


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getAllStudentDetails() {
        List<Student> studentList = studentRepo.findAll();
        return studentList;
    }
}
