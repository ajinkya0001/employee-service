package com.example.employeeservice.controller;

import com.example.employeeservice.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return List.of(
                new Employee(1L, "Ajinkya version 2", "DevOps"),
                new Employee(2L, "Rahul version 2", "Development"),
                new Employee(3L, "Priya version 2", "Testing")
        );
    }
}
