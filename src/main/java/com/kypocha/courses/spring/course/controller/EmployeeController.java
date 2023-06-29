package com.kypocha.courses.spring.course.controller;

import com.kypocha.courses.spring.course.domain.Employee;
import com.kypocha.courses.spring.course.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.saveEmployee(employee), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getEmployees(){
        return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") String id){
        return new ResponseEntity<>(employeeService.getEmployee(Long.parseLong(id)), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable("id") String id,
            @RequestBody Employee updatedEmployee
    ){
        return new ResponseEntity<>(employeeService.updateEmployee(Long.parseLong(id), updatedEmployee), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") String id){
        employeeService.deleteEmployee(Long.parseLong(id));
        return new ResponseEntity<>("Employee with id: " + id + " was deleted successfully",HttpStatus.OK);
    }
}
