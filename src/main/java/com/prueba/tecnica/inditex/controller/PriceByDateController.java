package com.prueba.tecnica.inditex.controller;

import com.prueba.tecnica.inditex.pricebydate.PriceByDate;
import com.prueba.tecnica.inditex.pricebydate.PriceByDateRepository;
import java.util.Date;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PriceByDateController {

  private final PriceByDateRepository repository;

  PriceByDateController(PriceByDateRepository repository) {
    this.repository = repository;
  }

  @GetMapping("/pricesByDate")
  List<PriceByDate> all() {
    return repository.findAll();
  }

  @PostMapping("/pricesByDate")
  PriceByDate newPriceByDate(@RequestBody PriceByDate newPriceByDate) {
    return repository.save(newPriceByDate);
  }

  @GetMapping("/pricesByDate/{id}")
  PriceByDate one(@PathVariable Long id) {
    return repository.findById(id)
        .orElseThrow(() -> new PriceByDateNotFoundException(id));
  }

  @PutMapping("/pricesByDate/{id}")
  PriceByDate replacePriceByDate(@RequestBody PriceByDate newPriceByDate, @PathVariable Long id) {
    return repository.findById(id)
        .map(priceByDate -> {
          priceByDate.setBrandId(newPriceByDate.getBrandId());
          priceByDate.setStartDate(newPriceByDate.getStartDate());
          priceByDate.setEndDate(newPriceByDate.getEndDate());
          priceByDate.setPriceList(newPriceByDate.getPriceList());
          priceByDate.setProductId(newPriceByDate.getProductId());
          priceByDate.setPriority(newPriceByDate.getPriority());
          priceByDate.setPrice(newPriceByDate.getPrice());
          priceByDate.setCurr(newPriceByDate.getCurr());

          return repository.save(priceByDate);
        })
        .orElseGet(() -> {
          newPriceByDate.setId(id);
          return repository.save(newPriceByDate);
        });
  }

  @DeleteMapping("/pricesByDate/{id}")
  void deletePriceByDate(@PathVariable Long id) {
    repository.deleteById(id);
  }
}
