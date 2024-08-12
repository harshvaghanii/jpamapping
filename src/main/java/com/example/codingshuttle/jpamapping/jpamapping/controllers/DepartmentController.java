package com.example.codingshuttle.jpamapping.jpamapping.controllers;

import com.example.codingshuttle.jpamapping.jpamapping.entities.DepartmentEntity;
import com.example.codingshuttle.jpamapping.jpamapping.services.DepartmentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @GetMapping("/{departmentId}")
    public DepartmentEntity getDepartmentById(@PathVariable Long departmentId) {
        return service.getDepartmentById(departmentId);
    }

    @PostMapping
    public DepartmentEntity createNewDepartment(@RequestBody DepartmentEntity departmentEntity) {
        return service.createNewDepartment(departmentEntity);
    }
}
