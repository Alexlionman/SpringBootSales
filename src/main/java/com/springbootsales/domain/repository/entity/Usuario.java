package com.springbootsales.domain.repository.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Table(name = "usuario")
@Data @NoArgsConstructor @AllArgsConstructor
@Builder
@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotEmpty(message = "{campo.login.usuario.obrigatorio}")
    @Column
    private String login;

    @NotEmpty(message = "{campo.senha.usuario.obrigatorio}")
    @Column
    private String senha;

    @Column
    private boolean admin;
}
