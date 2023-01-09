package com.example.demo.spring2.observers;

import com.example.demo.spring2.subjects.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRep extends JpaRepository<Category, Long> {
    Optional<Category> findByTitle(String title);
}