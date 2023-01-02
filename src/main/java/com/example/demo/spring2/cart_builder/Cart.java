package com.example.demo.spring2.cart_builder;

import com.example.demo.spring2.product_builder.ProductDTO;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Cart {
    private List<CartItem> items;
    private BigDecimal totalPrice;

    public void add(ProductDTO p) {
        for (CartItem item : items) {
            if (item.getProductId().equals(p.getId())) {
                item.incrementQuantity();
                recalculate();
                return;
            }

        }

        CartItem cartItem = new CartItem(p.getId(), p.getTitle(), 1, p.getPrice(), p.getPrice());
        items.add(cartItem);
        recalculate();


    }

    private void recalculate() {
        totalPrice = BigDecimal.ZERO;
        items.forEach(i -> totalPrice = totalPrice.add(i.getPrice()));
    }

    public void increaseProductToCart(ProductDTO p) {
        for (CartItem item : items) {
            if (item.getProductId().equals(p.getId())) {
                p.setQuantity(p.getQuantity() + 1);
                recalculate();
                return;
            }
        }
    }

    public void decreaseProductToCart(ProductDTO p) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProductId().equals(p.getId())) {
                if (items.get(i).getQuantity() == 1) {
                    deleteProductInCart(p);
                    recalculate();
                    return;
                }
            }
            items.get(i).setQuantity(items.get(i).getQuantity() - 1);
            recalculate();
            return;
        }

    }

    public void deleteProductInCart(ProductDTO p) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getProductId().equals(p.getId())) {
               items.remove(i);
                    recalculate();
                    return;
                }
            }

        }
    public void clearCart() {
        items.clear();
        totalPrice = BigDecimal.ZERO;
    }
    }
