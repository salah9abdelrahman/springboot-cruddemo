package com.salah.springboot.crud.dao;

import com.salah.springboot.crud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(int id);
    void save(Employee employee);
    void delete(int id);
}
