package de.hsw.shop.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.hsw.shop.beans.Shop;
import de.hsw.shop.repositories.ShopRepository;

@Service
public class ShopService {
    private ShopRepository repository;

    @Autowired
    public ShopService(ShopRepository repository) {
        this.repository = repository;
    }

    public ArrayList<Shop> findAll() {
        Iterable<Shop> iterable = repository.findAll();
        ArrayList<Shop> shops = new ArrayList<Shop>();
        iterable.forEach(e -> shops.add(e));

        return shops;
    }

    public Shop save(Shop c) {
        return repository.save(c);
    }

    public Optional<Shop> findById(long id) {
        return repository.findById(id);
    }

    public void delete(Shop c) {
        repository.delete(c);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
