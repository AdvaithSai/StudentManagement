package com.example.sms.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sms.entity.Student;
import com.example.sms.service.StudentService;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service){
        this.service = service;
    }

    @PostMapping
    public Student add(@RequestBody Student s){
        return service.addStudent(s);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        service.removeStudent(id);
    }

    @GetMapping("/{id}")
    public Student one(@PathVariable int id){
        return service.getStudent(id);
    }

    @GetMapping
    public List<Student> all(){
        return service.getAllStudents();
    }

    @GetMapping("/sort/age")
public List<Student> sortByAge(){
    return service.sortByAge();
}


    @GetMapping("/sort/name")
    public List<Student> sortByName(){
        return service.sortByName();
    }
}
