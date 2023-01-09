package order_builder;

import com.example.demo.spring2.cart_builder.Cart;
import com.example.demo.spring2.observers.OrderRep;
import com.example.demo.spring2.product_builder.ProductService;
import com.example.demo.spring2.subjects.Order;
import com.example.demo.spring2.subjects.UserDTO;
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
