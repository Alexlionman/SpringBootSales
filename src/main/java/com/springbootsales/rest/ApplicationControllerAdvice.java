package com.springbootsales.rest;

import com.springbootsales.exception.PedidoNaoEncontradoException;
import com.springbootsales.exception.RegraNegocioException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(RegraNegocioException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErrors handlerRegraNegocioExcpetion(RegraNegocioException ex){
        String mensagem = ex.getMessage();
        return new ApiErrors(mensagem);
    }

    @ExceptionHandler(PedidoNaoEncontradoException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiErrors handlerPedidoNaoEncontradoException(PedidoNaoEncontradoException ex){
        String mensagem = ex.getMessage();
        return new ApiErrors(mensagem);
    }
}
