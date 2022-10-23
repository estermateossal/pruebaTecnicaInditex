package com.prueba.tecnica.inditex.controller;

public class PriceByDateNotFoundException extends RuntimeException {

  PriceByDateNotFoundException(Long id) {
    super("Could not find price by date " + id);
  }
}
