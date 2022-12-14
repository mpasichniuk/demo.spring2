package com.example.demo.spring2;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CartConverter {
        private final CartItemConverter cartItemConverter;

        public CartDTO entityToDto(Cart c) {
            return new CartDTO(c.getItems().stream().map(cartItemConverter::entityToDto).collect(Collectors.toList()), c.getTotalPrice());
        }

    }


