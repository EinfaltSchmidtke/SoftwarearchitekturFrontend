package de.hsw.shop.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.hsw.shop.beans.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    
}
