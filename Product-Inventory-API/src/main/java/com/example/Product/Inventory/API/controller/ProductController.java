package com.example.Product.Inventory.API.controller;

import com.example.Product.Inventory.API.model.Product;
import com.example.Product.Inventory.API.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;


    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        log.info("Get all products");
        return ResponseEntity.ok(productService.getProducts());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
        log.info("Get product by id: {}", id);
        return ResponseEntity.ok(productService.getProductById(id));
    }


    @PostMapping
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) {
        log.info("Create product: {}", product.getName());
        return ResponseEntity.ok(productService.addProduct(product));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @Valid @RequestBody Product product) {
        log.info("Update product: {}", product.getName());

        return ResponseEntity.ok(productService.updateProduct(id,product));

    }


    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        log.info("Delete product: {}", id);

        return ResponseEntity.ok(productService.deleteProductById(id));
    }



}
