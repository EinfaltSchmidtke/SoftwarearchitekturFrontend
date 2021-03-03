package de.hsw.shop.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.hsw.shop.beans.Product;
import de.hsw.shop.services.ProductService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/Products/")
    public Product save(@RequestBody Product c) {
        return productService.save(c);
    }

    @GetMapping("/Products/") 
    public ArrayList<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/Products/{id}")
    public Optional<Product> findById(@PathVariable long id) {
        return productService.findById(id);
    }

    @DeleteMapping("/Products/{id}")
    public void delete(@PathVariable long id) {
        productService.deleteById(id);
    }

    @GetMapping("/ProductsWithoutDescription/")
    public ArrayList<Product> productsWithoutDescription() {
        return productService.findWithoutDescription();
    }

    @GetMapping("/ProductTopThree/")
    public ArrayList<Product> findTopThree() {
        return productService.findTopThree();
    }
}
