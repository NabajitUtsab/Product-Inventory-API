package com.example.Product.Inventory.API.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Product extends AuditEntity {

    @Id
    @GeneratedValue
    private Long id;

    @NotBlank(message = "Name must not be blank")
    private String name;

    @Size(max = 500 , message = "Description must be no longer than 500 characters ")
    private String description;

    @NotBlank(message = "Stock Keeping Unit must not be blank")
    private String sku;

    @NotNull(message = "Price must not be null")
    @Positive(message = "Price must be positive")
    private Double price;

    @NotNull(message = "Quantity must not be null")
    @Min(value = 0, message = "Quantity must be zero or more")
    private Integer quantity;

    @NotNull(message = "Status must not be null")
    @Enumerated(EnumType.STRING)
    private ProductStatus status;

}

