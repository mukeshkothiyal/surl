package com.mukesh.surl.openapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {
  @Value("${base.url}")
  String baseUrl;

  @Bean
  public OpenAPI openAPI() {
    Server server = new Server().url(baseUrl);
    server.description("Appointment Service API");
    List<Server> servers = new ArrayList<>();
    servers.add(server);

    return new OpenAPI().servers(servers);
  }
}
