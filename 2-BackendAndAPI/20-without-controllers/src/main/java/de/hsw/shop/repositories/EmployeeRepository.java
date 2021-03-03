package de.hsw.shop.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.hsw.shop.beans.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
    
}
