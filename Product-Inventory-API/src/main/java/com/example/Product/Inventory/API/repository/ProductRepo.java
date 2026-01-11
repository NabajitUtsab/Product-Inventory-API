package com.example.Product.Inventory.API.repository;

import com.example.Product.Inventory.API.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Repository;

@Repository
@EnableJpaAuditing
public interface ProductRepo extends JpaRepository<Product, Long> {
}
