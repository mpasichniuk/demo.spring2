package com.example.demo.spring2;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRep extends JpaRepository<ProductDTO, Long> {

        }


