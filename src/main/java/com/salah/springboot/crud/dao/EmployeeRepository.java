package com.salah.springboot.crud.dao;

import com.salah.springboot.crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import javax.validation.Valid;
import java.util.List;

@RepositoryRestResource(path = "employees")
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //   http://localhost:8080/api/employees/search/nameStartsWith?name=A
    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    public List<Employee> findByFirstNameStartingWith(@Valid @Param("name") String name);

}
