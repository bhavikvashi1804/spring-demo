package com.example.demo.service;

import com.example.demo.dao.PersonDAO;
import com.example.demo.model.person.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonDAO personDAO;

    public List<Person> getAllPerson(){
        List<Person> personList = personDAO.getAllPerson();
        return  personList;
    }

    @PostConstruct()
    public void doSetUp(){
        System.out.println("----- Person List -----");
        System.out.println(getAllPerson());
    }


}
