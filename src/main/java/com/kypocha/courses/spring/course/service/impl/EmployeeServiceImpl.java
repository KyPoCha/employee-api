package com.kypocha.courses.spring.course.service.impl;

import com.kypocha.courses.spring.course.domain.Employee;
import com.kypocha.courses.spring.course.exception.ResourceNotFoundException;
import com.kypocha.courses.spring.course.repository.EmployeeRepository;
import com.kypocha.courses.spring.course.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployee(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException(
                                Employee.class.getName(),
                                id.toString(),
                                EmployeeService.class.getName()
                        )
                );
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Long id, Employee updateEmployee) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(
                        () -> new ResourceNotFoundException(
                                Employee.class.getName(),
                                id.toString(),
                                EmployeeService.class.getName()
                        )
                );
        employee.setEmail(updateEmployee.getEmail());
        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());

        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
