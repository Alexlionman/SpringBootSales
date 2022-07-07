package com.springbootsales.exception;

public class SenhaInvalidaException extends RuntimeException{

    public SenhaInvalidaException() {
        super("Senha invalida");
    }
}
