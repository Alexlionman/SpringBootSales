package com.springbootsales;

import com.springbootsales.domain.entity.Cliente;
import com.springbootsales.domain.entity.Pedido;
import com.springbootsales.domain.repository.ClienteRepository;
import com.springbootsales.domain.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;
import java.time.LocalDate;

@EnableAutoConfiguration(exclude = {org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class})
@SpringBootApplication
@RestController
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClienteRepository clienteRepository) {
        return args -> {
//            Cliente cliente = new Cliente("Alex");
//            clienteRepository.save(cliente);
    };
}

    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }

}
