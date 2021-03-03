package de.hsw.shop.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.hsw.shop.beans.Shop;

@Repository
public interface ShopRepository extends CrudRepository<Shop, Long> {
    
}
