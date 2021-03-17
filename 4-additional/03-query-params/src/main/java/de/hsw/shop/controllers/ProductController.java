package de.hsw.shop.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.hsw.shop.beans.Product;
import de.hsw.shop.services.ProductService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/Products/") 
    public ArrayList<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/Products/") 
    public ArrayList<Product> findByActive(@RequestParam boolean active) {
        return productService.findByActive(active);
    }
}
