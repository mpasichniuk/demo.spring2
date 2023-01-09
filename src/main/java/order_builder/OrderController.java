package order_builder;

import com.example.demo.spring2.subjects.UserDTO;
import com.example.demo.spring2.client_builder.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {
    private final UserService userService;
    private final OrderService orderService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewOrder(Principal principal) {
        UserDTO userDTO = userService.findByUsername(principal.getName()).orElseThrow(() -> new RuntimeException("User not found"));
       orderService.createOrder(new UserDTO());


    }
}
