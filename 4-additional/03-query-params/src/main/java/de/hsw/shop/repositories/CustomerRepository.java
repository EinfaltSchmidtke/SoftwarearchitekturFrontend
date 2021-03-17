package de.hsw.shop.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.hsw.shop.beans.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    
}
