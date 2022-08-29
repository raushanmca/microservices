package com.department.io.service;

import com.department.io.entity.Department;
import com.department.io.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository repository;
    public Department save(Department department){
       return repository.save(department);
    }

    public Department getDepartmetById(Long id) {
        return repository.findById(id).get();
    }
}
