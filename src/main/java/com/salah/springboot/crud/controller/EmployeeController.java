package com.salah.springboot.crud.controller;

import com.salah.springboot.crud.entity.Employee;
import com.salah.springboot.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    private ResponseEntity<?> getEmployees(){
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    private ResponseEntity<?> getEmployees(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if(employee == null){
            throw new RuntimeException("Employee not found");
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/employees")
    private ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping("/employees")
    private ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

}
