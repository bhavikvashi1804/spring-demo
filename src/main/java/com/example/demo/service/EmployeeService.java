package com.example.demo.service;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.model.employee.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;

    @PostConstruct()
    public void doSetUp(){
        System.out.println("----- All Employee List -----");
        List<Employee> employeeList = employeeDAO.fetchAllEmployees();
        System.out.println(employeeList);

    }
}
