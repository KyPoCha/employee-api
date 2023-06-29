package com.kypocha.courses.spring.course.service;

import com.kypocha.courses.spring.course.domain.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    Employee getEmployee(Long id);
    List<Employee> getEmployees();

    Employee updateEmployee(Long id, Employee employee);

    void deleteEmployee(Long id);

}
