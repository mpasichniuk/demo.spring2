package com.example.demo.spring2.product_builder;

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
        private int quantity;

    public ProductDTO(String title, long id, BigDecimal price, String categoryTitle, int quantity){
        this.title = title;
        this.id = id;
        this.price = price;
        this.categoryTitle = categoryTitle;
        this.quantity = quantity;

    }

    public ProductDTO(String title) {
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id =id;
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
    public int getQuantity()
    {
        return quantity;
    }
    public void setQuantity(int quantity){
        this.quantity= quantity;
    }
    public void put(Long id, ProductDTO products) {
    }


}


