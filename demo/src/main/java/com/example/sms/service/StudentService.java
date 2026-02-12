package com.example.sms.service;

import java.util.List;

import com.example.sms.entity.Student;
import com.example.sms.entity.StudentType;

public interface StudentService {

    Student addStudent(Student s);
    void removeStudent(int id);
    Student getStudent(int id);
    List<Student> getAllStudents();
List<Student> getByType(StudentType type);

    List<Student> sortByAge();
    List<Student> sortByName();
}
