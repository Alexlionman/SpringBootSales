package com.springbootsales.domain.repository;

import ch.qos.logback.core.net.server.Client;
import com.springbootsales.domain.entity.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
