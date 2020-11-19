package com.salah.springboot.crud.controller;

import com.salah.springboot.crud.entity.Employee;
import com.salah.springboot.crud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(@Qualifier("employeeServiceRepo") EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String employeesList(Model model){
        List<Employee> employeeList = employeeService.findAll();
        model.addAttribute("employees",employeeList);
        return "list-employees";
    }
}
