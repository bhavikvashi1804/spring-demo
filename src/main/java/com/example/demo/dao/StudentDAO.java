package com.example.demo.dao;


import com.example.demo.model.student.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class StudentDAO {

    @Autowired
    SessionFactory sessionFactory;

    public Date fetchDummyData() {
        try (Session session = sessionFactory.openSession()) {
            return (Date) session.createNativeQuery("SELECT CURRENT_DATE FROM DUAL").getSingleResult();
        }
    }

    public List<Student> fetchAllStudents() {

        List<Student> studentList = new ArrayList<>();
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("select s from Student s", Student.class);
            studentList = query.getResultList();
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return studentList;
    }

    public void saveStudent(Student student) {
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();
            session.save(student);
            session.getTransaction().commit();
            session.close();
        }
    }
}
