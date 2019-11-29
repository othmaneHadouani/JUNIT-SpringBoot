package org.sid.services;

import org.sid.entities.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findEmployeeByName(String name);
    List<Employee> findAllEmployees();
}
