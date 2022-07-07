package com.springbootsales.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor @Data
@AllArgsConstructor
public class TokenDTO {

    private String login;
    private String token;

}
