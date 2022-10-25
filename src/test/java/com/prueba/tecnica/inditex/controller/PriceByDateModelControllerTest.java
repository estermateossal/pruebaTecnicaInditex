package com.prueba.tecnica.inditex.controller;

import com.prueba.tecnica.inditex.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = Application.class)
@AutoConfigureMockMvc
@TestPropertySource(
        locations = "classpath:application-integrationtest.properties")
public class PriceByDateModelControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Test
  public void getPricesByDateTestOk() throws Exception {
    MvcResult result = mockMvc.perform(get("/pricesByDate"))
            .andReturn();
    String expected = new String(Files.readAllBytes(Paths.get("src/test/resources/controller/pricesByDate.json")));
    assertEquals(expected, result.getResponse().getContentAsString());
  }

  @Test
  public void getPricesByDate1TestOk() throws Exception {
    MvcResult result = mockMvc.perform(get("/pricesByDate/1"))
            .andReturn();
    String expected = new String(Files.readAllBytes(Paths.get("src/test/resources/controller/pricesByDate1.json")));
    assertEquals(expected, result.getResponse().getContentAsString());
  }

  @Test
  public void getPricesByDateProductAndBrandTest1Ok() throws Exception {
    MvcResult result = mockMvc.perform(get("/priceByDateProductAndBrand" +
            "?date=2020-06-14-10.00.00&productId=35455&brandId=1"))
            .andReturn();
    String expected = new String(Files.readAllBytes(Paths.get("src/test/resources/controller/pricesByDateProductAndBrand1.json")));
    assertEquals(expected, result.getResponse().getContentAsString());
  }

  @Test
  public void getPricesByDateProductAndBrandTest2Ok() throws Exception {
    MvcResult result = mockMvc.perform(get("/priceByDateProductAndBrand" +
            "?date=2020-06-14-16.00.00&productId=35455&brandId=1"))
            .andReturn();
    String expected = new String(Files.readAllBytes(Paths.get("src/test/resources/controller/pricesByDateProductAndBrand2.json")));
    assertEquals(expected, result.getResponse().getContentAsString());
  }

  @Test
  public void getPricesByDateProductAndBrandTest3Ok() throws Exception {
    MvcResult result = mockMvc.perform(get("/priceByDateProductAndBrand" +
            "?date=2020-06-14-21.00.00&productId=35455&brandId=1"))
            .andReturn();
    String expected = new String(Files.readAllBytes(Paths.get("src/test/resources/controller/pricesByDateProductAndBrand3.json")));
    assertEquals(expected, result.getResponse().getContentAsString());
  }

  @Test
  public void getPricesByDateProductAndBrandTest4Ok() throws Exception {
    MvcResult result = mockMvc.perform(get("/priceByDateProductAndBrand" +
            "?date=2020-06-15-10.00.00&productId=35455&brandId=1"))
            .andReturn();
    String expected = new String(Files.readAllBytes(Paths.get("src/test/resources/controller/pricesByDateProductAndBrand4.json")));
    assertEquals(expected, result.getResponse().getContentAsString());
  }

  @Test
  public void getPricesByDateProductAndBrandTest5Ok() throws Exception {
    MvcResult result = mockMvc.perform(get("/priceByDateProductAndBrand" +
            "?date=2020-06-16-21.00.00&productId=35455&brandId=1"))
            .andReturn();
    String expected = new String(Files.readAllBytes(Paths.get("src/test/resources/controller/pricesByDateProductAndBrand5.json")));
    assertEquals(expected, result.getResponse().getContentAsString());
  }

  @Test
  public void deletePricesByDateTestOk() {
    // TODO
  }

  @Test
  public void postPricesByDateTestOk() {
    // TODO
  }

  @Test
  public void putPricesByDateTestOk() {
    // TODO
  }

}
