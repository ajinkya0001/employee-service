package com.example.employeeservice.controller;

import com.example.employeeservice.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return List.of(
                new Employee(1L, "Ajinkya 🚀 CI/CD Build #2", "Senior DevOps"),
                new Employee(2L, "GitHub Webhook Triggered", "Jenkins"),
                new Employee(3L, "Rolling Deployment Successful", "Amazon ECS")
        );
    }

    @GetMapping("/version")
    public String version() {
        return "Employee Service Version 2 | Deployed at: " + LocalDateTime.now();
    }
    @GetMapping("/deployment")
    public String deployment() {
        return """
            Deployment Details

            Application : Employee Service
            Version     : v2
            Environment : Production
            Platform    : AWS ECS Fargate
            CI/CD       : Jenkins + GitHub Webhook
            Status      : Running Successfully
            """;
    }
}