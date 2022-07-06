package com.springbootsales.domain.repository;

import com.springbootsales.domain.repository.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
