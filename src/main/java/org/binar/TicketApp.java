package org.binar;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories
@OpenAPIDefinition(
        info = @Info(contact = @Contact(name = "Elshe Erviana Angely", email = "elsherviana@gmail.com"),
                        title = "Cinema RESTful API", version = "1.0.0",
                        description = "Simple Cinema RESTful API with SpringBoot"
        ), servers = {@Server(url = "http://localhost:8080/cinema/api/v1", description = "Development")}
)
public class TicketApp {
    public static void main(String[] args) {
        SpringApplication.run(TicketApp.class, args);
    }
}
