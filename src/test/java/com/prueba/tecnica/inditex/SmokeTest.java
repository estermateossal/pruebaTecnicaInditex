package com.prueba.tecnica.inditex;

import static org.assertj.core.api.Assertions.assertThat;

import com.prueba.tecnica.inditex.controller.PriceByDateController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmokeTest {

  @Autowired
  private PriceByDateController controller;

  @Test
  public void contextLoads() {
    assertThat(controller).isNotNull();
  }

}
