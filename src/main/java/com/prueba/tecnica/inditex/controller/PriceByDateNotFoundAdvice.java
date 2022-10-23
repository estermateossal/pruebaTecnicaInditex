package com.prueba.tecnica.inditex.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PriceByDateNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(PriceByDateNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String priceByDateNotFoundHandler(PriceByDateNotFoundException ex) {
    return ex.getMessage();
  }

}
