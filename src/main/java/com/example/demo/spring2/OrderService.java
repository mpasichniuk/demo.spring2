package com.example.demo.spring2;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@NoArgsConstructor
public class OrderService {
    private ProductService productService;
    private OrderRep orderRep;

    public void createOrder(UserDTO userDTO){
        Cart cart = null;
        Order order = new Order();
        order.setUser(userDTO);
        order.setTotalPrice(cart.getTotalPrice());
        order.setItems(cart.getItems().stream().map(
                cartItem -> new OrderItem(
                        productService.findById(cartItem.getProductId()).getTitle(),
                        order,
                        cartItem.getQuantity(),
                        cartItem.getPricePerProduct(),
                        cartItem.getPrice()
                )
        ).collect(Collectors.toList()));
        orderRep.save(order);
    }

}
