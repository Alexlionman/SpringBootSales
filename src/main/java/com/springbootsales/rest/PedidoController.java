package com.springbootsales.rest;

import com.springbootsales.domain.entity.Pedido;
import com.springbootsales.rest.dto.PedidoDTO;
import com.springbootsales.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/pedidos")
public class PedidoController {

    @Autowired
    PedidoService pedidoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer save(@RequestBody PedidoDTO dto){
        Pedido pedido = pedidoService.savePedido(dto);
        return pedido.getId();
    }


}
