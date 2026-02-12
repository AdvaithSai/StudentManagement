package com.example.sms.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sms.entity.Student;
import com.example.sms.entity.StudentType;

public interface StudentRepository extends JpaRepository<Student,Integer> {
    List<Student> findByStudentType(StudentType type);
}
