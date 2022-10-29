package com.example.demo.spring2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRep productRepository;

    public List<ProductDTO> findAll(String titleFilter, String priceFilter, Integer pageValue, Integer sizeValue, String sortFieldValue) {
        return productRepository.findAll();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void createNewProduct(ProductDTO productDto) {
        ProductDTO product = new ProductDTO();
        product.setTitle(productDto.getTitle());
        product.setPrice(productDto.getPrice());
        productRepository.save(product);
    }

    public Optional<ProductDTO> findById(Long id) {
        return productRepository.findById(id);
    }
}