package com.salah.springboot.crud.controller;

import com.salah.springboot.crud.entity.Employee;
import com.salah.springboot.crud.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@Slf4j
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
        return "employees/list-employees";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model model){
        model.addAttribute("employee", new Employee());
        return "employees/employee-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model){
        model.addAttribute("employee", employeeService.findById(id));
        return "employees/employee-form";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult, Model model){
        model.addAttribute("employee", employee);
        if(bindingResult.hasErrors()){
            return "employees/employee-form";
        }
        else {
            employeeService.save(employee);
            return "redirect:/employees";
        }
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int id){
        employeeService.delete(id);
        return "redirect:/employees";
    }
}
