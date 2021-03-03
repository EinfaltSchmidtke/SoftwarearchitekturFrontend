package de.hsw.shop.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.hsw.shop.beans.Employee;
import de.hsw.shop.services.EmployeeService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class EmployeeController {
    
    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/Employees/")
    public Employee save(@RequestBody Employee c) {
        return employeeService.save(c);
    }

    @GetMapping("/Employees/") 
    public ArrayList<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/Employees/{id}")
    public Optional<Employee> findById(@PathVariable long id) {
        return employeeService.findById(id);
    }

    @DeleteMapping("/Employees/{id}")
    public void delete(@PathVariable long id) {
        employeeService.deleteById(id);
    }
}
