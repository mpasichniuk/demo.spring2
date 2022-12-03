package com.example.demo.spring2;

import jdk.dynalink.linker.support.Guards;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;

import java.util.List;

public class FullServerRunTest {
    @Autowired
    private TestRestTemplate restTemplate;

    @Test

    public void fullRestTest() {
        List<ProductDTO> products = restTemplate.getForObject("/api/v1/products", List.class);
        assertThat(products)
                .isNotNull()
                .isNotEmpty()
                .hasSize(4);
    }

    private Guards assertThat(List<ProductDTO> products) {
    }
}


