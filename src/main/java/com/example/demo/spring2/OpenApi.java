package com.example.demo.spring2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class OpenApi {

        @Bean
        public OpenAPI api() {
            return new OpenAPI()
                    .info(
                            new Info()
                                    .title("GeekBrains - Продуктовый сервис")
                                    .version("1")
                    );
        }
    }

