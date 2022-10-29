package com.example.demo.spring2;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
public class ProductDTO {
        private Long id;
        private String title;
        private BigDecimal price;
        private String categoryTitle;

    public ProductDTO(String title, long id, BigDecimal price, String categoryTitle){
        this.title = title;
        this.id = id;
        this.price = price;
        this.categoryTitle = categoryTitle;

    }

    public ProductDTO(String title) {
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = this.id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(){
        this.title = title;
    }
    public void price(){
        this.price = price;
    }
    public BigDecimal getPrice(){
        return price;
    }

    public void put(Long id, ProductDTO products) {
    }
}


