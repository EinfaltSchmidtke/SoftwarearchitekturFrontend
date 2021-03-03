package de.hsw.shop.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.hsw.shop.beans.Product;
import de.hsw.shop.repositories.ProductRepository;

@Service
public class ProductService {
    private ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product save(Product c) {
        return repository.save(c);
    }

    public ArrayList<Product> findAll() {
        Iterable<Product> iterable = repository.findAll();
        ArrayList<Product> products = new ArrayList<Product>();
        iterable.forEach(e -> products.add(e));

        return products;
    }

    public Optional<Product> findById(long id) {
        return repository.findById(id);
    }

    public void delete(Product c) {
        repository.delete(c);
    }

    public void deleteById(long id) {
        repository.deleteById(id);
    }
}
