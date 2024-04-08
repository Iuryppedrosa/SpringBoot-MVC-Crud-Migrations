package com.crud.services;

import com.crud.entities.Product;
import com.crud.repositorys.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProducService {
    @Autowired
    private ProductRepository productRepository;
    public Product delete(String id) {
        Optional<Product> product = productRepository.findById(id);
        productRepository.delete(product.get());
        return product.get();
    }
}
