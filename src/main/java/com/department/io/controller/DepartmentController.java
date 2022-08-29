package com.department.io.controller;

import com.department.io.entity.Department;
import com.department.io.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    DepartmentService service;

    @PostMapping("/")
    public Department create(@RequestBody Department department){
        return service.save(department);
    }



}
