package com.springbootsales.service;

import com.springbootsales.domain.entity.Pedido;
import com.springbootsales.domain.enums.StatusPedido;
import com.springbootsales.rest.dto.PedidoDTO;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface PedidoService {

    Pedido savePedido(PedidoDTO dto);

    Optional<Pedido> obterPedidoCompleto(Integer id);

    void atualizaStatus (Integer id, StatusPedido statusPedido);

}
