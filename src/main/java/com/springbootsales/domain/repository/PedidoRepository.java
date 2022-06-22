package com.springbootsales.domain.repository;

import com.springbootsales.domain.entity.Cliente;
import com.springbootsales.domain.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {

    List<Pedido> findByCliente(Cliente cliente);

}
