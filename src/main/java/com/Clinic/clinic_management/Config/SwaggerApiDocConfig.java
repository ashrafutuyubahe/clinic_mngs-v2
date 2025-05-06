package com.Clinic.clinic_management.Config;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@SecurityScheme(
        name = "bearerAuth", 
        description = "Secure your API with a JWT token for user authentication. Please provide a token in a header for accessing protected endpoints.",
        type = SecuritySchemeType.HTTP,
        scheme = "bearer",
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)
public class SwaggerApiDocConfig {

    private static final String SERVER_URL = "https://agrovolvebackend-production.up.railway.app";

    private Info apiInfo() {
        return new Info()
                .title("🚀 Welcome to the Swagger documentation for Agrovolve APIs.")
                .description("This is the official API documentation for the Agrovolve platform, powered by the Agrovolve team.")
                .version("1.0")
                .contact(new Contact()
                        .name("Ashraf")
                        .email("teamagrovolve@agrovolve.com"));
    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(apiInfo())
                .servers(List.of(
                        new Server().url(SERVER_URL).description("Production Environment")
                ))
              
                .addSecurityItem(new SecurityRequirement().addList("bearerAuth"));
    }
}
