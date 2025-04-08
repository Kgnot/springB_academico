package com.frenos_el_control.principal.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.models.GroupedOpenApi;

@Configuration
public class SwaggerConfig {
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .packagesToScan("com.frenos_el_control") // Asegúrate de que coincida con tu paquete base
                .pathsToMatch("/**")
                .build();
    }
}