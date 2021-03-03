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

import de.hsw.shop.beans.Customer;
import de.hsw.shop.beans.Order;
import de.hsw.shop.services.CustomerService;
import de.hsw.shop.services.OrderService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @PostMapping("/Customers/")
    public Customer save(@RequestBody Customer c) {
        return customerService.save(c);
    }

    @PostMapping("/Customers/{id}/Orders/")
    public Order save(@PathVariable long id, @RequestBody Order order) throws Exception {
        Optional<Customer> optCust = customerService.findById(id);

        if (!optCust.isPresent()) {
            throw new Exception();
        } else {
            Customer cust = optCust.get();
            order.setCustomer(cust);

            return orderService.save(order);
        }

    }

    @GetMapping("/Customers/") 
    public ArrayList<Customer> findAll() {
        return customerService.findAll();
    }

    @GetMapping("/Customers/{id}")
    public Optional<Customer> findById(@PathVariable long id) {
        return customerService.findById(id);
    }

    @DeleteMapping("/Customers/{id}")
    public void delete(@PathVariable long id) {
        customerService.deleteById(id);
    }
}
