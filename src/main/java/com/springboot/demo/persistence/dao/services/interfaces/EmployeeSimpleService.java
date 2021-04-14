package com.springboot.demo.persistence.dao.services.interfaces;

import com.springboot.demo.persistence.model.Employee;

import java.util.List;
import java.util.Optional;


public interface EmployeeSimpleService {
    List<Employee> findAll() throws InterruptedException;

    Employee addEmployee(Employee employee);

    void removeById(long id);

    void listAllEmployee();

    List<Employee> findEmployeeByName(String name);

    List<Employee> findEmployeeByNameAndPosition(String name, String position);

    List<Employee> findEmployeeByNameAndPhone(String name, String phone);

    void throwException();

    Optional<Employee> findById(long id) throws InterruptedException;

    void clearCache();
}
