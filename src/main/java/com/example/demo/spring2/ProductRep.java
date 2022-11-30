package com.example.demo.spring2;

import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRep extends JpaRepository<ProductDTO, Long> {

    List<ProductDTO> findAllByPriceGreaterThanEqual(BigDecimal minPrice);

    List<ProductDTO> findAllByPriceGreaterThanEqualAndLessThanEqual(BigDecimal maxPrice, BigDecimal minPrice);
}


