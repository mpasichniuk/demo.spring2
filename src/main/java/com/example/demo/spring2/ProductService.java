package com.example.demo.spring2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.logging.Filter;

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
    public List<ProductDTO> findByFilter(Filter filter){
        BigDecimal minPrice = filter.getMinPrice();
        BigDecimal maxPrice = filter.getMaxPrice();
        if(minPrice == null) minPrice = BigDecimal.ZERO;
        if(maxPrice == null) maxPrice = BigDecimal.ZERO;
        if(maxPrice.equals(BigDecimal.ZERO))
            return productRepository.findAllByPriceGreaterThanEqual(minPrice);
        return productRepository.findAllByPriceGreaterThanEqualAndLessThanEqual(maxPrice, minPrice);

    }

    public ProductDTO findById(Long id) {
        return productRepository.findById(id);
    }
}