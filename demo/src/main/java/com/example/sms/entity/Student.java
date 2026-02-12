package com.example.sms.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private String course;

     @Enumerated(EnumType.STRING)
    private StudentType studentType;

    public Student(){}

    public Student(String name,int age,String course,StudentType type){
        this.name=name;
        this.age=age;
        this.course=course;
        this.studentType=type;
    }

    public int getId(){return id;}
    public void setId(int id){this.id=id;}

    public String getName(){return name;}
    public void setName(String name){this.name=name;}

    public int getAge(){return age;}
    public void setAge(int age){this.age=age;}

    public String getCourse(){return course;}
    public void setCourse(String course){this.course=course;}
    public StudentType getStudentType(){
        return studentType;
    }

    public void setStudentType(StudentType studentType){
        this.studentType=studentType;
    }
}

