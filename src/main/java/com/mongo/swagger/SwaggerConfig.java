package com.mongo.swagger;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "API USUARIOS",
                description = "API de consulta de usuarios creados en BD MONGO",
                termsOfService = "www.mongo-crud.com/terminos_y_condiciones",
                version = "1.0.0",
                contact = @Contact(
                        name = "Andres Rivero",
                        url = "https://andresr.com",
                        email = "ar@mail.com"
                ),
                license = @License(
                        name = "Standard Software Use License for AndresRivero",
                        url = "www.mongo-crud.com/licence"
                )
        ),
        servers = {
                @Server(
                        description = "DEV SERVER",
                        url = "http://localhost:9090"
                ),
                @Server(
                        description = "PROD SERVER",
                        url = "http://andresrivero:9090"
                )
        })
public class SwaggerConfig {

}
