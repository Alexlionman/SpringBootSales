package com.springbootsales.service;

import com.springbootsales.domain.entity.Pedido;
import com.springbootsales.rest.dto.PedidoDTO;
import org.springframework.stereotype.Service;

public interface PedidoService {

    Pedido savePedido(PedidoDTO dto);

}
