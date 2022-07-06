package com.springbootsales.service;

import com.springbootsales.domain.repository.entity.Pedido;
import com.springbootsales.domain.enums.StatusPedido;
import com.springbootsales.rest.dto.PedidoDTO;

import java.util.Optional;

public interface PedidoService {

    Pedido savePedido(PedidoDTO dto);

    Optional<Pedido> obterPedidoCompleto(Integer id);

    void atualizaStatus (Integer id, StatusPedido statusPedido);

}
