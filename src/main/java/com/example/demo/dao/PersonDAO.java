package com.example.demo.dao;

import com.example.demo.model.person.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDAO {

    @Autowired
    @Qualifier("javaConfigSessionFactory")
    SessionFactory sessionFactory;

    public List<Person> getAllPerson(){
        List<Person> personList = new ArrayList<>();
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("select p from Person p", Person.class);
            personList = query.getResultList();
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return  personList;
    }
}
