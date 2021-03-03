package de.hsw.shop.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import de.hsw.shop.beans.Order;
import de.hsw.shop.beans.OrderItem;
import de.hsw.shop.beans.Product;
import de.hsw.shop.repositories.OrderRepository;
import de.hsw.shop.repositories.ProductRepository;

@Service
public class ProductService {
    private ProductRepository repository;

    @Autowired
    private OrderRepository orderRepository;

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

    public ArrayList<Product> findTopThree() {
        Iterable<Order> iterableOrders = orderRepository.findAll();
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        iterableOrders.forEach(order -> orderItems.addAll(order.getOrderItems()));

        Map<Long, Integer> map = new HashMap<Long, Integer>();
        for (OrderItem orderItem: orderItems) {
            if (map.get(orderItem.getId()) == null) {
                map.put(orderItem.getId(), orderItem.getAmount());
            } else {
                int orderItemCount = map.get(orderItem.getId());
                map.put(orderItem.getId(), orderItemCount+orderItem.getAmount());
            }
        }

        ArrayList<Product> productList = new ArrayList<Product>();
        for (int i=0; i<3 ; i++) {
            if (map.size() == 0) {
                continue;
            }

            Map.Entry<Long, Integer> maxEntry = null;
            for (Map.Entry<Long, Integer> entry: map.entrySet()) {
                if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                    maxEntry = entry;
                }
            }
            productList.add(repository.findById(maxEntry.getKey()).get());
            map.remove(maxEntry.getKey());
        }

        return productList;
    }

	public ArrayList<Product> findWithoutDescription() {
		Iterable<Product> iterableProducts = repository.findAll();
        ArrayList<Product> productsWithoutDesc = new ArrayList<Product>();
        
        for (Product product : iterableProducts) {
            if(product.getLongDescription() == null){
                productsWithoutDesc.add(product);
            }
        }
        return productsWithoutDesc;
	}
}
