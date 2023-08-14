package com.example.demo.dao;


import com.example.demo.model.employee.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class EmployeeDAO {

    @Autowired
    @Qualifier("javaConfigSessionFactory")
    SessionFactory sessionFactory;



    public List<Employee> fetchAllEmployees() {

        List<Employee> employeeList = new ArrayList<>();
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery("select e from Employee e", Employee.class);
            employeeList = query.getResultList();
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
        } finally {
            session.close();
        }
        return employeeList;
    }

}
