package com.prueba.tecnica.inditex.repository;

import com.prueba.tecnica.inditex.model.PriceByDate;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
class LoadDatabase {

  @Bean
  CommandLineRunner initDatabase(PriceByDateRepository repository) {
    return args -> {
      log.info("Preloading (1/4) " + repository.save(PriceByDate.builder()
          .brandId(1)
          .startDate(parseDate("2020-06-14-00.00.00"))
          .endDate(parseDate("2020-12-31-23.59.59"))
          .priceList(1).productId(35455L).priority(false).price(35.50).curr("EUR").build()));

      log.info("Preloading (2/4) " + repository.save(PriceByDate.builder()
          .brandId(1)
          .startDate(parseDate("2020-06-14-15.00.00"))
          .endDate(parseDate("2020-06-14-18.30.00"))
          .priceList(2).productId(35455L).priority(true).price(25.45).curr("EUR").build()));
      log.info("Preloading (3/4) " + repository.save(PriceByDate.builder()
          .brandId(1)
          .startDate(parseDate("2020-06-15-00.00.00"))
          .endDate(parseDate("2020-06-15-11.00.00"))
          .priceList(3).productId(35455L).priority(false).price(30.50).curr("EUR").build()));
      log.info("Preloading (4/4) " + repository.save(PriceByDate.builder()
          .brandId(1)
          .startDate(parseDate("2020-06-15-16.00.00"))
          .endDate(parseDate("2020-12-31-23.59.59"))
          .priceList(4).productId(35455L).priority(true).price(38.95).curr("EUR").build()));
    };
  }

  private static Date parseDate(String date) {
    try {
      return new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss").parse(date);
    } catch (ParseException e) {
      return null;
    }
  }

}