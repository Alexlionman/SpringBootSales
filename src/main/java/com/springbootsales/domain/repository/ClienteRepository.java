package com.springbootsales.domain.repository;

import com.springbootsales.domain.repository.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ClienteRepository extends JpaRepository <Cliente, Integer>{

    @Query(value = "select c from Cliente c where c.nome like :nome")
    List<Cliente> findByNomeLike(@Param("nome") String nome);

    List<Cliente> findByNomeOrIdOrderById(String nome, Integer id);

    @Query( "delete from Cliente c where c.nome = :nome ")
    @Modifying
    void deleteByNome(String nome);

    Cliente findOneByNome(String nome);

    boolean existsByNome(String nome);

    //find the "Clientes" whit their "Pedidos"
    @Query(" select c from Cliente c left join fetch c.pedidos where c.id = :id ")
    Cliente findClienteFetchPedidos(@Param("id") Integer id);

}
