package com.employee.io.controller;

import com.employee.io.entity.Employee;
import com.employee.io.jwtutils.JWTUtility;
import com.employee.io.repository.EmployeeRepository;
import com.employee.io.responseentity.EmployeeVO;
import com.employee.io.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.Header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/employee")
@Slf4j
public class EmployeeController {

    @Autowired
    private EmployeeService es;

    @Autowired
    private HttpServletRequest header;

    @Autowired
    JWTUtility utility;

    @PostMapping("/")
    public Employee create(@RequestBody Employee employee){
        log.info("inside employee class controller");
        return es.create(employee);

    }

    @GetMapping("/{id}")
    public EmployeeVO getEmployeeDetails(@PathVariable ("id") Long id){

       String token =  header.getHeader("Authorization");
       String username = utility.getUsernameFromToken(token.substring(7,token.length()));
       return es.getEmployeeDetailsById(id, username);


    }
}
