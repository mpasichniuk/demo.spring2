package com.example.demo.spring2;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @GetMapping
    public Cart getCurrentCart() {
        return cartService.getCurrentCart();
    }

    @GetMapping("/add/{productId}")
    public void addProductToCart(@PathVariable Long productId) {
        cartService.addToCart(productId);
    }
    @GetMapping("/increase/{productId}")
    public void increaseProductToCart(@PathVariable Long productId){
        cartService.increaseProductToCart(productId);
    }
    @GetMapping("/decrease/{productId}")
    public void decreaseProductInCart( @PathVariable Long productId){
        cartService.decreaseProductInCart(productId);
    }
    @GetMapping("/delete/{productId}")
    public void deleteProductInCart(@PathVariable Long productId){
        cartService.deleteProductInCart(productId);

    }
    @GetMapping("/clear")
    public void clearCart(){
        cartService.clear();
    }
}
