package com.example.demo.spring2.observers;

import com.example.demo.spring2.subjects.ProductDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRep extends JpaRepository<ProductDTO, Long> {

        }


