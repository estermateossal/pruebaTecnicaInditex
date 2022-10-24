package com.prueba.tecnica.inditex.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import com.prueba.tecnica.inditex.dto.PriceByDateDTO;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class PriceByDateModelAssembler
    implements
    RepresentationModelAssembler<PriceByDateDTO, EntityModel<PriceByDateDTO>> {

  @Override
  public EntityModel<PriceByDateDTO> toModel(PriceByDateDTO priceByDateModel) {
    return EntityModel.of(priceByDateModel,
        linkTo(methodOn(PriceByDateController.class).one(priceByDateModel.getId())).withSelfRel(),
        linkTo(methodOn(PriceByDateController.class).all()).withRel("pricesByDate"));
  }
}
