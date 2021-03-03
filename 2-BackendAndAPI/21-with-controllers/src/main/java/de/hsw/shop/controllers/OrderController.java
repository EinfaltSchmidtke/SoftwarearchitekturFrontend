package de.hsw.shop.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.hsw.shop.beans.Order;
import de.hsw.shop.services.OrderService;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/Orders/")
    public Order save(@RequestBody Order c) {
        return orderService.save(c);
    }

    @GetMapping("/Orders/") 
    public ArrayList<Order> findAll() {
        return orderService.findAll();
    }

    @GetMapping("/Orders/{id}")
    public Optional<Order> findById(@PathVariable long id) {
        return orderService.findById(id);
    }

    @DeleteMapping("/Orders/{id}")
    public void delete(@PathVariable long id) {
        orderService.deleteById(id);
    }
}
