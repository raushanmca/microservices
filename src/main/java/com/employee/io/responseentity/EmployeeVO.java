package com.employee.io.responseentity;

import com.employee.io.entity.Department;
import com.employee.io.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeVO {

    private Employee employee;
    private Department departmet;
}
