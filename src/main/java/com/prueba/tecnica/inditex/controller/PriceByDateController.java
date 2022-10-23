package com.prueba.tecnica.inditex.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.prueba.tecnica.inditex.pricebydate.PriceByDate;
import com.prueba.tecnica.inditex.pricebydate.PriceByDateRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
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

  private final PriceByDateModelAssembler assembler;

  PriceByDateController(PriceByDateRepository repository, PriceByDateModelAssembler assembler) {
    this.repository = repository;
    this.assembler = assembler;
  }

  @GetMapping("/pricesByDate")
  CollectionModel<EntityModel<PriceByDate>> all() {
    List<EntityModel<PriceByDate>> pricesByDate = repository.findAll()
        .stream()
        .map(assembler::toModel)
        .collect(Collectors.toList());

    return CollectionModel.of(
        pricesByDate, linkTo(methodOn(PriceByDateController.class).all()).withSelfRel());
  }

  @PostMapping("/pricesByDate")
  ResponseEntity<?> newPriceByDate(@RequestBody PriceByDate newPriceByDate) {
    EntityModel<PriceByDate> entityModel = assembler.toModel(repository.save(newPriceByDate));

    return ResponseEntity //
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
        .body(entityModel);
  }

  @GetMapping("/pricesByDate/{id}")
  EntityModel<PriceByDate> one(@PathVariable Long id) {
    PriceByDate priceByDate = repository.findById(id)
        .orElseThrow(() -> new PriceByDateNotFoundException(id));

    return assembler.toModel(priceByDate);
  }

  @PutMapping("/pricesByDate/{id}")
  ResponseEntity<?> replacePriceByDate(@RequestBody PriceByDate newPriceByDate, @PathVariable Long id) {
    PriceByDate updatedPriceByDate = repository.findById(id) //
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

    EntityModel<PriceByDate> entityModel = assembler.toModel(updatedPriceByDate);

    return ResponseEntity //
        .created(entityModel.getRequiredLink(IanaLinkRelations.SELF).toUri()) //
        .body(entityModel);
  }

  @DeleteMapping("/pricesByDate/{id}")
  ResponseEntity<?> deletePriceByDate(@PathVariable Long id) {
    repository.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
