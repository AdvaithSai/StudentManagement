package com.example.sms.service;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.sms.entity.Student;
import com.example.sms.entity.StudentType;
import com.example.sms.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repo;

    public StudentServiceImpl(StudentRepository repo){
        this.repo = repo;
    }

    @Override
    public Student addStudent(Student s){
        return repo.save(s);
    }

    @Override
    public void removeStudent(int id){
        repo.deleteById(id);
    }

    @Override
    public Student getStudent(int id){
        return repo.findById(id).orElse(null);
    }

    @Override
    public List<Student> getAllStudents(){
        return repo.findAll();
    }

    @Override
public List<Student> sortByAge(){
    return repo.findAll(Sort.by(Sort.Direction.ASC,"age"));
}


    @Override
    public List<Student> sortByName(){
        return repo.findAll(Sort.by(Sort.Direction.ASC,"name"));
    }
    @Override
public List<Student> getByType(StudentType type){
    return repo.findByStudentType(type);
}

}

