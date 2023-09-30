package com.example.EmployeeManager.service;

import com.example.EmployeeManager.model.Employee;
import com.example.EmployeeManager.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeService {

    //Necessary field in this class to talk to repo layer
    private final EmployeeRepo employeeRepo;

    //Dependency injecting EmployeeRepo object in constructor
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;

    }

    //To find all employees
    public List<Employee> findAllEmployees() {
        return employeeRepo.findAll();
    }
}
