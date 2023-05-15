package com.crudspringapi.crudspringapi.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI api() {

        return new OpenAPI()
                .info(new Info()
                        .title("API Service")
                        .version("v1")
                        .description("REST API com Spring"));
    }
}
