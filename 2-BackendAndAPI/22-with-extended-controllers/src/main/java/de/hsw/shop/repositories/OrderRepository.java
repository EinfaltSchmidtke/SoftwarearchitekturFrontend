package de.hsw.shop.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import de.hsw.shop.beans.Order;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    
}
