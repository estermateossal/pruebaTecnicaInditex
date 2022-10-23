package com.prueba.tecnica.inditex.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.prueba.tecnica.inditex.pricebydate.PriceByDate;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class PriceByDateModelAssembler implements
    RepresentationModelAssembler<PriceByDate, EntityModel<PriceByDate>> {

  @Override
  public EntityModel<PriceByDate> toModel(PriceByDate priceByDate) {
    return EntityModel.of(priceByDate, //
        linkTo(methodOn(PriceByDateController.class).one(priceByDate.getId())).withSelfRel(),
        linkTo(methodOn(PriceByDateController.class).all()).withRel("pricesByDate"));
  }
}
