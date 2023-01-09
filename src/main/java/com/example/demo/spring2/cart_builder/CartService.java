package com.example.demo.spring2.cart_builder;

import com.example.demo.spring2.subjects.ProductDTO;
import com.example.demo.spring2.product_builder.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import java.util.ArrayList;

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
