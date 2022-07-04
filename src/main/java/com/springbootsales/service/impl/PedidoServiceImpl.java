package com.springbootsales.service.impl;

import com.springbootsales.domain.entity.Cliente;
import com.springbootsales.domain.entity.ItemPedido;
import com.springbootsales.domain.entity.Pedido;
import com.springbootsales.domain.entity.Produto;
import com.springbootsales.domain.repository.ClienteRepository;
import com.springbootsales.domain.repository.ItemPedidoRepository;
import com.springbootsales.domain.repository.PedidoRepository;
import com.springbootsales.domain.repository.ProdutoRepository;
import com.springbootsales.exception.RegraNegocioException;
import com.springbootsales.rest.ClienteController;
import com.springbootsales.rest.dto.ItemPedidoDTO;
import com.springbootsales.rest.dto.PedidoDTO;
import com.springbootsales.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    ItemPedidoRepository itemPedidoRepository;

    @Override
    @Transactional
    public Pedido savePedido(PedidoDTO dto) {
        Integer idCliente = dto.getCliente();
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new RegraNegocioException(("Código de cliente inexistente")));

        Pedido pedido = new Pedido();
        pedido.setTotal(dto.getTotal());
        pedido.setDataPedido(LocalDate.now());
        pedido.setCliente(cliente);

        List<ItemPedido> itensPedido = convertItens(pedido, dto.getItens());

        pedidoRepository.save(pedido);
        itemPedidoRepository.saveAll(itensPedido);
        pedido.setItens(itensPedido);

       return pedido;
    }

    private List<ItemPedido> convertItens(Pedido pedido, List<ItemPedidoDTO> itens){
        if(itens.isEmpty()){
            throw new RegraNegocioException("Não é possível salvar um pedido sem itens");
        }

        return itens.stream()
                .map(dto -> {
                    Integer idProduto = dto.getProduto();
                    Produto produto = produtoRepository
                            .findById(idProduto)
                            .orElseThrow(() -> new RegraNegocioException("Código de produto inválido:" + idProduto));

                    ItemPedido itemPedido = new ItemPedido();
                    itemPedido.setQuantidade(dto.getQuantidade());
                    itemPedido.setPedido(pedido);
                    itemPedido.setProduto(produto);
                    return itemPedido;
                }).collect(Collectors.toList());
    }
}

