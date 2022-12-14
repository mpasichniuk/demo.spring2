package com.example.demo.spring2;

import org.springframework.stereotype.Component;

@Component
public class CartItemConverter {
        public CartItemDTO entityToDto(CartItem c) {
            return new CartItemDTO(c.getProductId(), c.getProductTitle(), c.getQuantity(), c.getPricePerProduct(), c.getPrice());
        }
    }


