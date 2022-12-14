package com.example.demo.spring2;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductResource {


    private final ProductService productService;

    @GetMapping
    public List<ProductDTO> listPage(
            @RequestParam(required = false) String titleFilter,
            @RequestParam(required = false) String priceFilter,
            @RequestParam(required = false) Optional<Integer> page,
            @RequestParam(required = false) Optional<Integer> size,
            @RequestParam(required = false) Optional<String> sortField
    ) {
        Integer pageValue = page.orElse(1) - 1;
        Integer sizeValue = size.orElse(3);
        String sortFieldValue = sortField.filter(s -> !s.isBlank()).orElse("id");
        Page<ProductDTO> allByFilter = (Page<ProductDTO>) productService.findAll(titleFilter, priceFilter, pageValue, sizeValue, sortFieldValue);
        List<ProductDTO> products = allByFilter.get().collect(Collectors.toList());
        return products;
    }

}

