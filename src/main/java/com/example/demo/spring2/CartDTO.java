package com.example.demo.spring2;

import java.math.BigDecimal;
import java.util.List;

public class CartDTO {
    private List<CartItemDTO> items;
    private BigDecimal totalPrice;

    public List<CartItemDTO> getItems() {
        return items;
    }

    public void setItems(List<CartItemDTO> items) {
        this.items = items;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public CartDTO() {
    }

    public CartDTO(List<CartItemDTO> items, BigDecimal totalPrice) {
        this.items = items;
        this.totalPrice = totalPrice;
    }
}


