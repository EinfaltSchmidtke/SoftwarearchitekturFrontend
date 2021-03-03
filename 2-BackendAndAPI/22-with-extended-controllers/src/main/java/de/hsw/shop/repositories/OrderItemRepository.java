package de.hsw.shop.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import de.hsw.shop.beans.OrderItem;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@Repository
public interface OrderItemRepository extends CrudRepository<OrderItem, Long> {
    
}
