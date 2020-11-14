package com.salah.springboot.crud.dao;


import com.salah.springboot.crud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDAOJpaImp implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOJpaImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        Query query = entityManager.createQuery("select e from Employee e");
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        //save or update employee based on id
        Employee dbEmployee = entityManager.merge(employee);

        //get the generated id
        employee.setId(dbEmployee.getId());
    }

    @Override
    public void delete(int id) {
        Query query = entityManager.createQuery("delete from Employee" +
                " where id=:empId");
        query.setParameter("empId", id);
        query.executeUpdate();

    }
}
