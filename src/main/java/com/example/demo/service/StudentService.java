package com.example.demo.service;


import com.example.demo.model.student.Student;
import com.example.demo.dao.StudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentDAO studentDAO;

    public List<Student> fetchAllStudents(){
        List<Student> studentList = studentDAO.fetchAllStudents();
        return  studentList;
    }

    @PostConstruct
    public void doSetUp(){
        Date date = studentDAO.fetchDummyData();
        System.out.println("Current Date fetched from DB : " +date);

        System.out.println("---------------Store a new Student -----------------");
        Student student = new Student(22, "Dhruvik","Patel");
        //studentDAO.saveStudent(student);

        System.out.println("---------------Fetched All Student Data -----------------");
        List<Student> fetchedStudentData = fetchAllStudents();
        System.out.println(fetchedStudentData);

    }
}
