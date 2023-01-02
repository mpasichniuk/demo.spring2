package com.example.demo.spring2.product_builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public ProductDTO findById(Long id) {
        return productRepository.findById(id);
    }
}