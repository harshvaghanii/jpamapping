package com.example.codingshuttle.jpamapping.jpamapping.controllers;

import com.example.codingshuttle.jpamapping.jpamapping.entities.DepartmentEntity;
import com.example.codingshuttle.jpamapping.jpamapping.entities.EmployeeEntity;
import com.example.codingshuttle.jpamapping.jpamapping.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @GetMapping("/{employeeId}")
    public EmployeeEntity getDepartmentById(@PathVariable Long employeeId) {
        return service.getEmployeeById(employeeId);
    }

    @PostMapping
    public EmployeeEntity createNewDepartment(@RequestBody EmployeeEntity employeeEntity) {
        return service.createNewEmployee(employeeEntity);
    }

}
