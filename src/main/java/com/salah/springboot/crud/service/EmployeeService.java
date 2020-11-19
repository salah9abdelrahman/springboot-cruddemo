package com.salah.springboot.crud.service;

import com.salah.springboot.crud.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int id);
    void save(Employee employee);
    void delete(int id);
}
