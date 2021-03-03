package de.hsw.shop.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import de.hsw.shop.beans.Shop;
import de.hsw.shop.services.ShopService;

@RestController
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping("/Shops/")
    public Shop save(@RequestBody Shop c) {
        return shopService.save(c);
    }

    @GetMapping("/Shops/") 
    public ArrayList<Shop> findAll() {
        return shopService.findAll();
    }

    @GetMapping("/Shops/{id}")
    public Optional<Shop> findById(@PathVariable long id) {
        return shopService.findById(id);
    }

    @DeleteMapping("/Shops/{id}")
    public void delete(@PathVariable long id) {
        shopService.deleteById(id);
    }
}
