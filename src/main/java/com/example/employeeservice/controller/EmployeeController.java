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
                new Employee(1L, "Ajinkya", "DevOps"),
                new Employee(2L, "Rahul", "Development"),
                new Employee(3L, "Priya", "Testing")
        );
    }
}
