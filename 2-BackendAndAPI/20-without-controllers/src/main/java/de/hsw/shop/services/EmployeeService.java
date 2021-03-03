package de.hsw.shop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.hsw.shop.beans.Employee;
import de.hsw.shop.repositories.EmployeeRepository;

@Service
public class EmployeeService {
    private EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee save(Employee c) {
        return repository.save(c);
    }

    public Optional<Employee> findById(long id) {
        return repository.findById(id);
    }

    public void delete(Employee c) {
        repository.delete(c);
    }

    public boolean isAuthorized(long id, String password) {
        Optional<Employee> Employee = findById(id);

        // Normalerweise wäre das Passwort hier gesalzen und SHA-256 gehasht und wir würden einen Web Token generieren
        if(Employee.isPresent() && Employee.get().getPassword().equals(password)) {
            return true;
        }

        return false;
    }
}
