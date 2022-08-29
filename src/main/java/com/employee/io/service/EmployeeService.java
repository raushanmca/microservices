package com.employee.io.service;

import com.employee.io.entity.Department;
import com.employee.io.entity.Employee;
import com.employee.io.repository.EmployeeRepository;
import com.employee.io.responseentity.EmployeeVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository er;

    @Autowired
    RestTemplate restTemplate;

    public Employee create(Employee employee) {
        return er.save(employee);
    }

    public EmployeeVO getEmployeeDetailsById(Long id, String username) {
        Department dept = null;
        EmployeeVO employeeVO = new EmployeeVO();
        final Employee employee = er.findById(id).get();
        employeeVO.setEmployee(employee);

        if(username.equalsIgnoreCase(employee.getName())) {
             dept = restTemplate.getForObject("http://DEPARTMENT-API/department/" + employeeVO.getEmployee().getDeptId()
                    , Department.class);


        }
        else {
             dept = new Department(new Long(404),"**********");
        }
        employeeVO.setDepartmet(dept);
        return employeeVO;

    }
}
