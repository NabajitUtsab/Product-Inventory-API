package com.example.Product.Inventory.API.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse {

    private String timestamp;
    private String error;
    private String message;
    private Map<String, String> validationErrors;
}
