package com.springbootsales.domain.repository;

import com.springbootsales.domain.repository.entity.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository <ItemPedido, Integer> {
}
