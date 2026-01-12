package com.example.Product.Inventory.API.service;

import com.example.Product.Inventory.API.model.Product;
import com.example.Product.Inventory.API.repository.ProductRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;

    public List<Product> getProducts() {
        return productRepo.findAll();
    }


    public Product getProductById(long id) {
        return productRepo.findById(id).orElseThrow();
    }


    public Product addProduct(Product product) {
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

         return productRepo.save(existingProduct);
    }


    public String deleteProductById(Long id) {

        Product existingProduct = getProductById(id);
        productRepo.delete(existingProduct);

         return "Product with id " + id + " was deleted";
    }
}
