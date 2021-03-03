package de.hsw.shop.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.hsw.shop.beans.Order;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    
}
