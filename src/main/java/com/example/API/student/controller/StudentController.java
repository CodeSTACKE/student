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

//    get Student with id
@GetMapping("/{id}")
@ResponseStatus(HttpStatus.OK)
public Student getCarById(@PathVariable Integer id){
    if(id!=null){
        return studentRepo.getById(id);
    }
    else
        throw new RuntimeException("No student id available");

}
    //    update
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Student getUpdateById(@RequestBody Student student, @PathVariable Integer id){
        System.out.println(id);
        System.out.println(student.getId());

        if(student.getId()==null) {
            student.setId(id);
        }
        if(student.getId()!=id)
        {
            throw new IllegalArgumentException("student ID must match parameter given");
        }
        return studentRepo.save(student);
    }
    //  Delete
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable int id) {
        studentRepo.deleteById(id);
    }


}
