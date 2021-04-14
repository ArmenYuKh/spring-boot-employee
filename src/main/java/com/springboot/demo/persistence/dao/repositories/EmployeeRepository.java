package com.springboot.demo.persistence.dao.repositories;

import com.springboot.demo.persistence.model.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    List<Employee> findEmployeeByName(String name);
    List<Employee> findEmployeeByNameAndPosition(String name, String position);
    @Query("select e from Employee e where e.name= :name and e.phone= :phone")
    List<Employee> getPhone(@Param("name") String name, @Param("phone") String phone);
}
