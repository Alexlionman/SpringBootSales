package com.springbootsales.service.impl;

import com.springbootsales.domain.entity.Pedido;
import com.springbootsales.domain.repository.ClienteRepository;
import com.springbootsales.domain.repository.PedidoRepository;
import com.springbootsales.domain.repository.ProdutoRepository;
import com.springbootsales.rest.dto.PedidoDTO;
import com.springbootsales.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public Pedido savePedido(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        //pedido.setCliente(clienteRepository.findById(idCliente));
        Integer idcliente = dto.getCliente();
        return null;
    }
}

