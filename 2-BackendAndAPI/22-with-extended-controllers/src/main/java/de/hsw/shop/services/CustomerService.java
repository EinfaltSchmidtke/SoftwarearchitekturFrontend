package de.hsw.shop.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.hsw.shop.beans.Customer;
import de.hsw.shop.repositories.CustomerRepository;

@Service
public class CustomerService {
    private CustomerRepository repository;

    @Autowired
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public ArrayList<Customer> findAll() {
        Iterable<Customer> iterable = repository.findAll();
        ArrayList<Customer> customers = new ArrayList<Customer>();
        iterable.forEach(e -> customers.add(e));

        return customers;
    }

    public Customer save(Customer c) {
        return repository.save(c);
    }

    public Optional<Customer> findById(long id) {
        return repository.findById(id);
    }

    public void delete(Customer c) {
        repository.delete(c);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }

    public boolean isAuthorized(long id, String password) {
        Optional<Customer> customer = findById(id);

        // Normalerweise wäre das Passwort hier gesalzen und SHA-256 gehasht und wir
        // würden einen Web Token generieren
        if (customer.isPresent() && customer.get().getPassword().equals(password)) {
            return true;
        }

        return false;
    }
}
