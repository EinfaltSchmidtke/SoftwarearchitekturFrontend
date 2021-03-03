package de.hsw.shop.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.hsw.shop.beans.Order;
import de.hsw.shop.repositories.OrderRepository;

@Service
public class OrderService {
    private OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order save(Order c) {
        return repository.save(c);
    }

    public Optional<Order> findById(long id) {
        return repository.findById(id);
    }

    public void delete(Order c) {
        repository.delete(c);
    }
}
