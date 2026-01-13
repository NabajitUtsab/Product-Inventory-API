package com.example.Product.Inventory.API.service;

import com.example.Product.Inventory.API.model.Product;
import com.example.Product.Inventory.API.repository.ProductRepo;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class ProductService {

    private final ProductRepo productRepo;

    public List<Product> getProducts() {

        log.debug(getClass().getName() + " getProducts");
        return productRepo.findAll();
    }


    public Product getProductById(long id) {

        log.debug(getClass().getName() + " getProductById");
        return productRepo.findById(id).orElseThrow();
    }


    public Product addProduct(Product product) {

        log.debug(getClass().getName() + " addProduct");
        return productRepo.save(product);
    }


    public Product updateProduct(Long id,Product product) {


        Product existingProduct = getProductById(id);


        existingProduct.setName(product.getName());
        existingProduct.setDescription(product.getDescription());
        existingProduct.setSku(product.getSku());
        existingProduct.setPrice(product.getPrice());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setStatus(product.getStatus());


        log.debug(getClass().getName() + " updateProduct");
         return productRepo.save(existingProduct);
    }


    public String deleteProductById(Long id) {


        Product existingProduct = getProductById(id);
        productRepo.delete(existingProduct);

        log.debug(getClass().getName() + " deleteProductById");
         return "Product with id " + id + " was deleted";
    }
}
