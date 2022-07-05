package com.springbootsales.rest;

import lombok.Data;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;


public class ApiErrors {

    @Getter
    private List<String> errors;

    public ApiErrors(String mensagemError) {
        this.errors = Arrays.asList(mensagemError);
    }

    public ApiErrors(List<String> errors){
        this.errors = errors;
    }
}
