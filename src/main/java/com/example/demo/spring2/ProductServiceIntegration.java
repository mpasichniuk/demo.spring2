package com.example.demo.spring2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class ProductServiceIntegration {
    private final RestTemplate restTemplate;

    public ProductDTO findById(Long id) {
        return restTemplate.getForObject("http://localhost:8189/demo.spring2/api/v1/products/" + id, ProductDTO.class);
    }
}