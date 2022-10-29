package com.example.demo.spring2;

import lombok.RequiredArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductService productService;
    private Cart cart;

    @PostConstruct
    public void init() {
        cart = new Cart();
        cart.setItems(new ArrayList<>());
    }

    public Cart getCurrentCart() {
        return cart;
    }

    public void addToCart(Long productId) {
        ProductDTO p = productService.findById(productId);
        cart.add(p);
    }

    public void increaseProductToCart(Long productId) {
        ProductDTO p = productService.findById(productId);
        cart.increaseProductToCart(p);
    }

    public void decreaseProductInCart(Long productId) {
        ProductDTO p = productService.findById(productId);
        cart.decreaseProductToCart(p);
    }


    public void deleteProductInCart(Long productId) {
        ProductDTO p = productService.findById(productId);
        cart.deleteProductInCart(p);
    }


    public void clear() {
        cart.clearCart();
    }
}
