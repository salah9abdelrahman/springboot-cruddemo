package com.salah.springboot.crud.controller;

import com.salah.springboot.crud.entity.Employee;
import com.salah.springboot.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest-employees")
public class EmployeeRestController {
    private final EmployeeService employeeService;

    @Autowired // @Autowired is optional when using constructor inject
    public EmployeeRestController(@Qualifier("employeeServiceRepo") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<?> getEmployees(){
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getEmployees(@PathVariable int id){
        Employee employee = employeeService.findById(id);
        if(employee == null){
            throw new RuntimeException("Employee not found");
        }
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> addEmployee(@RequestBody Employee employee){
        employee.setId(0);
        employeeService.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> updateEmployee(@RequestBody Employee employee){
        employeeService.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

}
