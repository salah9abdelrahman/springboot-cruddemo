//package com.salah.springboot.crud.service;
//
//import com.salah.springboot.crud.dao.EmployeeRepository;
//import com.salah.springboot.crud.entity.Employee;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class EmployeeServiceRepo implements EmployeeService {
//    private final EmployeeRepository employeeRepository;
//
//    @Autowired
//    public EmployeeServiceRepo(EmployeeRepository employeeRepository) {
//        this.employeeRepository = employeeRepository;
//    }
//
//    @Override
//    public List<Employee> findAll() {
//        return employeeRepository.findAll();
//    }
//
//    @Override
//    public Employee findById(int id) {
//        Optional<Employee> employeeOptional = employeeRepository.findById(id);
//            return employeeOptional.orElse(null);
//        }
//
//    @Override
//    public void save(Employee employee) {
//        employeeRepository.save(employee);
//    }
//
//    @Override
//    public void delete(int id) {
//        employeeRepository.deleteById(id);
//    }
//
//}
