package com.locadora.configs;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration 
@OpenAPIDefinition(
    info= @Info(
        title = "locadora",
        version = "1.0",
        description = "agenda de eventos"
    )
)
public class Swagger {
    
}
//Muito obrigado, irmão Thiago Tesch!