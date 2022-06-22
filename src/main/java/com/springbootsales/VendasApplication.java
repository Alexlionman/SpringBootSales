package com.springbootsales;

import com.springbootsales.domain.entity.Cliente;
import com.springbootsales.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@SpringBootApplication
@RestController
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClienteRepository clienteRepository) {
        return args -> {
            System.out.println("Salvando...");
            clienteRepository.save(new Cliente("Alex"));
            clienteRepository.save(new Cliente("Bruna"));

            List<Cliente> clientes = clienteRepository.findByNomeLike("Alex");
            clientes.forEach(System.out::println);

    };
}

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
