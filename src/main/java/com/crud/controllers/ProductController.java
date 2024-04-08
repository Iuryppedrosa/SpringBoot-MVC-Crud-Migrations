package com.crud.controllers;

import com.crud.entities.Product;
import com.crud.entities.RequestProduct;
import com.crud.repositorys.ProductRepository;
import com.crud.services.ProducService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProducService producService;

    @GetMapping
    public ResponseEntity getProducts() {
        List<Product> products = productRepository.findAll();

        return ResponseEntity.ok().body(products);

//        var allProducts = productRepository.findAll();
//        return ResponseEntity.ok(allProducts);
    }

    @PostMapping
    public ResponseEntity createProduct(@RequestBody @Validated RequestProduct product) {

        Product productSave = new Product(product);
        productRepository.save(productSave);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProduct(@PathVariable String id, @RequestBody @Validated RequestProduct productRequest) {
        Optional<Product> productData = productRepository.findById(id);

        if (productData.isPresent()) {
            Product product = productData.get();
            // Update product details here
            product.setName(productRequest.name());
            product.setPrice_in_cents(productRequest.price_in_cents());
            // ... other property updates

            Product updatedProduct = productRepository.save(product);
            return ResponseEntity.ok().body(updatedProduct);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        Product product = producService.delete(id);
        return ResponseEntity.noContent().build();
    }



}
